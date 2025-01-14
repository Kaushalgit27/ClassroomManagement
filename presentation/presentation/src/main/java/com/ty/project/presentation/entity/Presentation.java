package com.ty.project.presentation.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ty.project.presentation.enums.Presentationstatus;
import com.ty.project.presentation.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Presentation {
	
	public Presentation() {
	
	}

	public Presentation(Integer pid, String course, String topic, User user, Presentationstatus pstatus,
			Double pscore) {
		super();
		this.pid = pid;
		this.course = course;
		this.topic = topic;
		this.user = user;
		Pstatus = pstatus;
		Pscore = pscore;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	private String course;
	private String topic;
	
	@ManyToOne	
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy="presentation")
	private List<Rating> Prating;
	
	
	public List<Rating> getPrating() {
		return Prating;
	}

	public void setPrating(List<Rating> prating) {
		Prating = prating;
	}

	@Enumerated(EnumType.STRING)
	private Presentationstatus Pstatus=Presentationstatus.ASSIGNED;
	
	private Double Pscore;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
