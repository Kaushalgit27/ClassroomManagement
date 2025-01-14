package com.ty.project.presentation.entity;

import java.util.List;

import com.ty.project.presentation.enums.Role;
import com.ty.project.presentation.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "app_user")
public class User {
	
	
	
	public User() {
	
	}
	



	public User(Integer id, String name, String email, Long phone, String password, List<Presentation> presentation,
			Status status, Role role, Double userscore) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.presentation = presentation;
		this.status = status;
		this.role = role;
		this.userscore = userscore;
	}

	//@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String email;
	private Long phone;
	
	private String password;
	 
	//presentation
	@OneToMany(mappedBy = "user")
	private List<Presentation> presentation;
	
	public List<Rating> getUrating() {
		return Urating;
	}

	public void setUrating(List<Rating> urating) {
		Urating = urating;
	}

	@Enumerated(EnumType.STRING)
	private Status status=Status.ACTIVE;
	
	@Enumerated(EnumType.STRING)
	private Role role=Role.ADMIN;
	
	private  Double userscore;
	
	//rating
	@OneToMany(mappedBy="user")
	private List<Rating> Urating;
	
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Presentation> getPresentation() {
		return presentation;
	}

	public void setPresentation(List<Presentation> presentation) {
		this.presentation = presentation;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Double getUserscore() {
		return userscore;
	}

	public void setUserscore(Double userscore) {
		this.userscore = userscore;
	}
	
	

	
	
	
	
	

}
