package com.daysluck.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.daysluck.dao.UserRepository;
import com.daysluck.domain.User;
import com.daysluck.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Resource
	public RedisTemplate<String, String> redisTemplate;
	
	@Cacheable(value="userInfo")
	public User findByName(String name) {
		System.out.println("DemoInfoServiceImpl.findById()=========从数据库中进行获取的....name="+name);
	    return userRepository.findByName(name);
	}

	@CacheEvict(value="userInfo")
	public void deleteFromCache(Integer id) {
		System.out.println("UserServiceImpl.delete().从缓存中删除.");
	}

	public void test() {
		ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("mykey4", "random1="+Math.random());
        System.out.println(valueOperations.get("mykey4"));
	}

}
