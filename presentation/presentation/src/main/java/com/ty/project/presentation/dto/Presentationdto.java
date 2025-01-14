package com.ty.project.presentation.dto;

import com.ty.project.presentation.enums.Presentationstatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class Presentationdto {
	
	private String course;
	private String topic;
	@Enumerated(EnumType.STRING)
	private Presentationstatus Pstatus=Presentationstatus.ASSIGNED;
	private Double Pscore;
	
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Presentationstatus getPstatus() {
		return Pstatus;
	}
	public void setPstatus(Presentationstatus pstatus) {
		Pstatus = pstatus;
	}
	public Double getPscore() {
		return Pscore;
	}
	public void setPscore(Double pscore) {
		Pscore = pscore;
	}
	
	

}
