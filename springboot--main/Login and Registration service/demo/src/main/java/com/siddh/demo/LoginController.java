package com.anand.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.anand.demo.model.User;
import com.anand.demo.model.UserRepo;


@Controller
public class LoginController {
     @Autowired
     private UserRepo userRepo;
      
     RestTemplate restTemplate=new RestTemplate();
@RequestMapping("/")
public String checkMvc()
{
	return "login";
}
@RequestMapping("/Login")
public String loginHomePage(@RequestParam("userName") String userName,
		@RequestParam("password") String password,Model model)
{
	User u = null;
	try {
		u=userRepo.findByName(userName);
	}catch (Exception e) {
		System.out.println("User not found !!");
		
	}
	if(u!=null) {
	model.addAttribute("Username" ,userName);
	return "homepage";
	}
	model.addAttribute("error","Wrong Username and password !!!");
	
return "login";
}


@RequestMapping("/register")
 public String gotoRegistrtionPage() {
 return "register";
}

@RequestMapping("/set-user")
public String gotoRegisterMicroservice(@RequestParam("userName") String userName,
		@RequestParam("password1") String password1,
		@RequestParam("password2") String password2,Model model){
	    System.out.println("***Going To Register Microservice From Login Microservice Start  ");
       if(password1.equals(password2)) {
    	   restTemplate.getForObject("http://localhost:8081/register-user/"+userName+"/"+password1,
    			   String.class);
       model.addAttribute("registerSuccess","Successfully registered,kindly login to continue!!");
}else  {
    	   
    	   model.addAttribute("registrationError", "Password Not Same");
       }
       System.out.println("** Going To Register Microservice From Login Microservice End  ");
	return "login";
}

}



