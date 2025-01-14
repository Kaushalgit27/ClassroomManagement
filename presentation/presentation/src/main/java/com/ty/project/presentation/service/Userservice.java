package com.ty.project.presentation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.project.presentation.controller.Usercontroller;
import com.ty.project.presentation.dto.Userdto;
import com.ty.project.presentation.entity.User;
import com.ty.project.presentation.enums.Role;
import com.ty.project.presentation.enums.Status;
import com.ty.project.presentation.exception.UsernotfoundException;
import com.ty.project.presentation.repository.Userrepository;

@Service
public class Userservice {
	
	Userrepository userrepository;
	public Userservice(Userrepository userrepository) {
		this.userrepository= userrepository;
	}

	public boolean registration(User userrequest) {
		Optional<User> opt= userrepository.findByEmail(userrequest.getEmail());
		
		if(opt.isPresent()) {
			return false;
			
		}
		else {
			User createuser=new User();
			BeanUtils.copyProperties(userrequest, createuser);
			userrepository.save(createuser);
			return true;
			
		}	
		
	}

	//my logic for login
//	public ResponseEntity<String> logIn(String email, String password) {
//	Optional<User> opt=userrepository.findByEmail(email);
//	if(opt.isPresent()) {
//		User passuser=opt.get();
//		if(passuser.getPassword().equals(password)) {
//			return  new ResponseEntity<String>("Login Successful", HttpStatus.OK);
//		}
//		else {
//			return  ResponseEntity.badRequest().body("Wrong password");
//			
//		}
//	}else {
//		return ResponseEntity.badRequest().body("Wrong email");
//	}
//		
//	}
	
	
	//sir logic using exception
	public boolean logIn(String email,String password) {
		User userfind=userrepository.findByEmail(email).orElseThrow(() -> new UsernotfoundException("User is not register"));
		
		if(userfind.getPassword().equals(password)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	//getting all data by admin

	public List<User> getalldatas() {
		return userrepository.findAll();
		
	}
	
	//updating status by admin

	public ResponseEntity<String> Changestatus(int aid ,int uid) {
		Optional<User> opt=userrepository.findById(aid);
		
		if(opt.isPresent()) {
			User isadmin=opt.get();
			if(isadmin.getRole().equals(Role.ADMIN)){
				User userfindbyid=userrepository.findById(uid).orElseThrow(() -> new UsernotfoundException("User is not register"));
				
				Status stat=userfindbyid.getStatus();
				
				if(stat.equals(Status.ACTIVE)) {
					userfindbyid.setStatus(Status.INACTIVE);
					
				}
				else {
					userfindbyid.setStatus(Status.ACTIVE);
				}	
				
				userrepository.save(userfindbyid);
				return new ResponseEntity<String>("Status is updated", HttpStatus.OK);
				
			}
			else{
				return ResponseEntity.badRequest().body("you are not admin");
			}
		}
		else{
			return ResponseEntity.badRequest().body("No such id found");
		
		}
	
		
	}

	public Userdto getdatas(int uid) {
		User user=userrepository.findById(uid).orElseThrow(() -> new UsernotfoundException("User is not register"));
		if(user.getStatus().equals(Status.ACTIVE)) {
			Userdto userdto=new Userdto();
			BeanUtils.copyProperties(user, userdto);
			return userdto;
			
		}else {
			return null;
		}
		
	}

	
	
	
}
