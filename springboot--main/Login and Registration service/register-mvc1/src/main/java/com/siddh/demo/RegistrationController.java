package com.anand.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anand.demo.model.User;
import com.anand.demo.model.UserRepo;
@RestController
public class RegistrationController {

	@Autowired
	 private UserRepo userRepo;
	@RequestMapping("/check")
	public String registercheck() {
	     
		  return "Check Regitster !!";
	  }
	
@RequestMapping("/register-user/{userName}/{password}")
public String registerUser(@PathVariable("userName")String userName,
		  @PathVariable("password")String password) {
	 System.out.println(" In Register Microservice From Login Microservice Start  ");
      User u=new User();
      u.setId(5);
      u.setName(userName);
      u.setPassword(password);
      
      userRepo.save(u);
      System.out.println(" In Register Microservice From Login Microservice End  ");
	  return "Succesfully registered !!";
  }
}
