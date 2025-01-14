package com.ty.project.presentation.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.project.presentation.entity.Presentation;
import com.ty.project.presentation.entity.Rating;
import com.ty.project.presentation.entity.User;
import com.ty.project.presentation.exception.PresentationnotFoundException;
import com.ty.project.presentation.exception.RatingException;
import com.ty.project.presentation.exception.UsernotfoundException;
import com.ty.project.presentation.repository.Presentationrepository;
import com.ty.project.presentation.repository.Ratingrepository;
import com.ty.project.presentation.repository.Userrepository;

@Service
public class Recordservice {
	
	Ratingrepository ratingrepo;
	Presentationrepository pr;
	Userrepository ur;
	public Recordservice(Ratingrepository ratingrepo,	Presentationrepository pr,Userrepository ur) {
		this.ratingrepo=ratingrepo;
		this.pr=pr;
		this.ur=ur;
	}

	public  ResponseEntity<String>  rateThePresentation(Rating rating, int uid,int pid) {
		
		User use=ur.findById(uid).orElseThrow(() -> new UsernotfoundException("User is not register"));
		Presentation pres=pr.findById(pid).orElseThrow(() -> new PresentationnotFoundException("No presentations found for the given user ID: "));
		
		rating.setUser(use);
		rating.setPresentation(pres);
		ratingrepo.save(rating);
		
		return new ResponseEntity<String>("Rating added for given user id and presentation id", HttpStatus.OK);
	
		
	}
	
	//getting list of rating

	public List<Rating> getoverallrating( int uid) {
		List<Rating> rate=ratingrepo.findByUser_Id(uid);
		if(rate.isEmpty()) {
			 throw new RatingException("No presentations found for the given user ID: " + uid);
		}
		
		
		return rate;
	}

}
