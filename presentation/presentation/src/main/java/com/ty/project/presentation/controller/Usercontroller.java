package com.ty.project.presentation.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.project.presentation.dto.Userdto;
import com.ty.project.presentation.entity.User;
import com.ty.project.presentation.service.Userservice;


@RestController
@RequestMapping("/user")
public class Usercontroller {
	
	Userservice userservice;
	
	public Usercontroller(Userservice userservice) {
		this.userservice=userservice;
	}
	
	
	//Registration
//	@PostMapping("/register", consumes = { "application/json", "application/xml" },
//			  produces = {"application/json","application/xml" }
//			
//			
//			)
	 @PostMapping(value = "/register", consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	public ResponseEntity<String> Register ( @RequestBody User userrequest ) {
		boolean respo=userservice.registration(userrequest);
		
		if(respo) {
			return new ResponseEntity<String>("register", HttpStatus.CREATED);
		}
		else {
			return ResponseEntity.badRequest().body("already registered");
		}
	
		
	}
	
	//Login
	@PostMapping("/login")
	public ResponseEntity<String> Login(@RequestParam String email,@RequestParam String password ) {
		//my logic for login api 
		//return userservice.logIn(email,password);
		
		boolean respo=userservice.logIn(email, password);
		
		if(respo) {
			return new ResponseEntity<String>("Login Successful", HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<String>("Login failed", HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	//fetching data for user
	@GetMapping("/fetchdetail")
	public Userdto getdata(@RequestParam int uid) {
		return userservice.getdatas(uid);
	}
	
	//Admin getting all data
	@GetMapping("/admin/getall")
	public  List<User> getalldata() {
		
		return userservice.getalldatas();
		
	}
	
	//Admin changing status
	
	@PostMapping("/admin/updatestatus")
	public ResponseEntity<String> Updatestatus(@RequestParam int aid,@RequestParam int uid ){
		return userservice.Changestatus(aid,uid);
		
	
		
	}
	
	
	
	
	
	
	
	
	
	

}
