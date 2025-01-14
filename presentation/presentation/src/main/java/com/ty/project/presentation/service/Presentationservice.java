package com.ty.project.presentation.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.project.presentation.dto.Presentationdto;
import com.ty.project.presentation.entity.Presentation;
import com.ty.project.presentation.entity.User;
import com.ty.project.presentation.enums.Presentationstatus;
import com.ty.project.presentation.enums.Role;
import com.ty.project.presentation.exception.PresentationnotFoundException;
import com.ty.project.presentation.exception.UsernotfoundException;
import com.ty.project.presentation.repository.Presentationrepository;
import com.ty.project.presentation.repository.Userrepository;

@Service
public class Presentationservice {
	
	Presentationrepository pr;
	Userrepository ur;
	
	public Presentationservice(Presentationrepository pr ,Userrepository ur) {
		this.pr=pr;
		this.ur=ur;
		
	}
	
	//assiging the presentation to user in presentation table

	public String assignpresentation(Presentation pres, int uid,int aid) {
	    Optional<User> admin=ur.findById(aid);
	    if(admin.get().getRole().equals(Role.ADMIN) ) {
		 User finduser=ur.findById(uid).orElseThrow(() -> new UsernotfoundException("User is not register"));
		 pres.setUser(finduser);
		 pr.save(pres);
		 return "Presentation is added with user";
	    }else {
	    	return "You are not an admin";
	    	
	    }
		
		
		
	}
	
	//getting list of presentation

	public List<Presentation> getallpresdata(int uid) {
		
		List<Presentation> listpre=pr.findByUser_Id(uid);
		if(listpre.isEmpty()) {
			 throw new PresentationnotFoundException("No presentations found for the given user ID: " + uid);
		}
		
		return listpre;	
		
	}

	
	//fetching presentation data
	public Presentationdto fetchpresentation(int pid) {
		Presentation present=pr.findById(pid).orElseThrow(() -> new PresentationnotFoundException("No presentations found for the given user ID: "));
		Presentationdto pdto=new Presentationdto();
		BeanUtils.copyProperties(present, pdto);
		
		
		
		return pdto ;
	}

	

//	public String updatethestatus(int uid,Presentationstatus stat) {
//		List<Presentation> listpre=pr.findByUser_Id(uid);
//		
//		if(listpre.isEmpty()) {
//			throw new PresentationnotFoundException("No presentations found for the given user ID: " + uid);
//		}
//		else {
//			
//			for(int i=0;i<listpre.size();i++) {
//				listpre.get(i).setPstatus(stat);
//				Presentation pre= new Presentation();
//				BeanUtils.copyProperties(listpre.get(i), pre);
//				pr.save(pre);
//				
//			}
//			
//			return "record updated";
//			
//		
//		}
//		
//	}
	
	//updating the status of presentation 
	
	public ResponseEntity<String> updatethestatus (int uid,String course, Presentationstatus stat) {
		List<Presentation> listpre=pr.findByUser_Id(uid);
		if(listpre.isEmpty()) {
			throw new PresentationnotFoundException("No presentations found for the given user ID: " + uid);
		}
		else {
			
			for(int i=0;i<listpre.size();i++) {
				
				if(listpre.get(i).getCourse().equals(course)) {
				      listpre.get(i).setPstatus(stat);
				
				       Presentation pre= new Presentation();
			           BeanUtils.copyProperties(listpre.get(i), pre);
				      pr.save(pre);
				}
				
			}
			
			return new ResponseEntity<String>("Presentation status updated", HttpStatus.OK);
			
		}
		
		
	}
	
	//updating the score

	public ResponseEntity<String> patchthescore(int uid, String course, Double pscore) {
		
		List<Presentation> listpre=pr.findByUser_Id(uid);
		if(listpre.isEmpty()) {
			throw new PresentationnotFoundException("No presentations found for the given user ID: " + uid);
		}
		else {
			
			for(int i=0;i<listpre.size();i++) {
				
				if(listpre.get(i).getCourse().equals(course)) {
				      listpre.get(i).setPscore(pscore);;
				
				       Presentation pre= new Presentation();
			           BeanUtils.copyProperties(listpre.get(i), pre);
				      pr.save(pre);
				}
				
			}
			
			return new ResponseEntity<String>("Presentation Score updated", HttpStatus.OK);
			
		}
		
	
	}
	

	
	
	
	

}
