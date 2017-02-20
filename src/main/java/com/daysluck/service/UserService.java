package com.daysluck.service;

import com.daysluck.domain.User;

public interface UserService {

	
	public User findByName(String name);
	
	public void deleteFromCache(Integer id);
	
	void test();
}
