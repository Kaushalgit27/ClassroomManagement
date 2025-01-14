package com.ty.project.presentation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.project.presentation.entity.Presentation;
import com.ty.project.presentation.entity.Rating;
import com.ty.project.presentation.service.Recordservice;

@Controller
@RequestMapping("/rating")
public class Recordcontroller {
	
	Recordservice rs;
	
	public Recordcontroller(Recordservice rs){
		this.rs=rs;
	}
	
	
	//rating the presentation
	@PostMapping("/addingrating")
	public ResponseEntity<String> ratingpresentation( @RequestBody Rating rating, @RequestParam int uid, @RequestParam int pid){
	return	rs.rateThePresentation(rating,uid,pid);
		
	}
	//getting all the rating of particular student
	@GetMapping("/getallrating")
	public ResponseEntity<List<Rating>> getallrating(@RequestParam int uid){
		List<Rating> rat= rs.getoverallrating(uid);
		
		return new ResponseEntity<List<Rating>>(rat, HttpStatus.OK);
		
	}
	
	

}
