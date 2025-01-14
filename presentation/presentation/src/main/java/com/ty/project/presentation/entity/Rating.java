package com.ty.project.presentation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Rating {
	public Rating() {
		
	}
	
	public Rating(Integer rid, Integer communication, Integer content, Integer liveliness, Integer usageProps,
			Double totalScore, User user, Presentation presentation) {
		super();
		this.rid = rid;
		this.communication = communication;
		this.content = content;
		this.liveliness = liveliness;
		this.usageProps = usageProps;
		this.totalScore = totalScore;
		this.user = user;
		this.presentation = presentation;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rid;
	
	private Integer communication;
	private Integer content;
	private Integer liveliness;
	private Integer usageProps;
	private Double totalScore;
	
	@ManyToOne	
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	
	@ManyToOne	
	@JoinColumn(name = "presentation_id")
	@JsonIgnore
	private Presentation presentation;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getCommunication() {
		return communication;
	}

	public void setCommunication(Integer communication) {
		this.communication = communication;
	}

	public Integer getContent() {
		return content;
	}

	public void setContent(Integer content) {
		this.content = content;
	}

	public Integer getLiveliness() {
		return liveliness;
	}

	public void setLiveliness(Integer liveliness) {
		this.liveliness = liveliness;
	}

	public Integer getUsageProps() {
		return usageProps;
	}

	public void setUsageProps(Integer usageProps) {
		this.usageProps = usageProps;
	}

	public Double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Presentation getPresentation() {
		return presentation;
	}

	public void setPresentation(Presentation presentation) {
		this.presentation = presentation;
	}

}
