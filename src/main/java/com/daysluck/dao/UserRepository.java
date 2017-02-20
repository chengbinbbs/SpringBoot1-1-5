package com.daysluck.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daysluck.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	public User findByName(String name);
}
