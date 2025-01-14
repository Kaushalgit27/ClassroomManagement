package com.ty.project.presentation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.project.presentation.entity.User;

public interface Userrepository extends JpaRepository<User, Integer> {
 public Optional<User> findByEmail(String email);
	

}
