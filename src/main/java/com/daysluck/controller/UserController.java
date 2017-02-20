package com.daysluck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daysluck.domain.User;
import com.daysluck.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/find/{name}")
	public @ResponseBody String find(@PathVariable String name){
		User loaded = userService.findByName(name);
		System.out.println("loaded="+loaded);
		User cached = userService.findByName(name);
	    System.out.println("cached="+cached);
	    return"ok";
	}
	
	@RequestMapping("/delete/{id}")
    public @ResponseBody String delete(@PathVariable Integer id){
		userService.deleteFromCache(id);
        return"ok";
    }
   
    @RequestMapping("/test")
    public @ResponseBody String test(){
    	userService.test();
        System.out.println("DemoInfoController.test()");
        return"ok";
    }
}
