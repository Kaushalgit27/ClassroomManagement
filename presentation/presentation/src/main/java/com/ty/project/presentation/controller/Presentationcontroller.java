package com.ty.project.presentation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.project.presentation.dto.Presentationdto;
import com.ty.project.presentation.entity.Presentation;
import com.ty.project.presentation.enums.Presentationstatus;
import com.ty.project.presentation.service.Presentationservice;

@RestController
@RequestMapping("/Presentation")
public class Presentationcontroller {
	
	Presentationservice ps;
	
	public Presentationcontroller(Presentationservice ps) {
		this.ps=ps;
		
	}
	
	//assigning presentation
	@PostMapping("admin/assign")
	public String Assignthepresentation( @RequestBody Presentation pres,@RequestParam int uid ,@RequestParam int aid) {
		
		return ps.assignpresentation(pres,uid,aid);
		
	
		
	}
	
	//getting presentation data
	@GetMapping("/getpresentation")
	public Presentationdto fetchingdata(@RequestParam int pid) {
	
		
		return ps.fetchpresentation(pid);
		
		
		
	}
	
	
	// getting all presentation data by student id
	
	@GetMapping("/getallpresentation")
	public ResponseEntity<List<Presentation>> Getalldata( @RequestParam int uid){
		List<Presentation> findusersid=ps.getallpresdata(uid);
	
		return new ResponseEntity<List<Presentation>>(findusersid, HttpStatus.OK);
	
	}
	
	//changing presentation status
//	@PutMapping("/Updatestatus")
//	public String UpdateStatus(@RequestParam int uid,@RequestParam Presentationstatus stat){
//		return ps.updatethestatus(uid,stat);
//		
//		
//	}
	
	@PutMapping("/Updatestatus")
	public ResponseEntity<String> UpdateStatus(@RequestParam int uid,@RequestParam String course,@RequestParam Presentationstatus stat){
		return ps.updatethestatus(uid,course,stat);
	}
	
	@PatchMapping("/Patchscore")
	public ResponseEntity<String> Patchscore(@RequestParam int uid,@RequestParam String course,@RequestParam Double pscore){
		return ps.patchthescore(uid,course,pscore);
	}
	
	
	

}
