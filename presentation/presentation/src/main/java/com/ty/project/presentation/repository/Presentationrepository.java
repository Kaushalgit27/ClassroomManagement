package com.ty.project.presentation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.project.presentation.entity.Presentation;

public interface Presentationrepository extends  JpaRepository<Presentation,Integer> {

	//List<Presentation> findByUser_Id(int userId);

	public List<Presentation> findByUser_Id(int uid);

	
}
