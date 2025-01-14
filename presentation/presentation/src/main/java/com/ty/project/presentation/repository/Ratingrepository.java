package com.ty.project.presentation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.project.presentation.entity.Presentation;
import com.ty.project.presentation.entity.Rating;

public interface Ratingrepository extends JpaRepository<Rating,Integer> {
	public 	List<Rating> findByUser_Id(int uid);

}
