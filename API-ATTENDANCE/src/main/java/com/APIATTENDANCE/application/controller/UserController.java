package com.APIATTENDANCE.application.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.APIATTENDANCE.application.entity.User;
import com.APIATTENDANCE.application.entity.format.UserFormat;
import com.APIATTENDANCE.application.security.JwtService;
import com.APIATTENDANCE.application.service.UserService;
import com.APIATTENDANCE.application.util.UtilMess;

import ch.qos.logback.classic.pattern.Util;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener.Yielding;

@RestController
@CrossOrigin(origins = "*")
//v1.1.2
@RequestMapping("/api/us")
public class UserController {

	@Autowired UserService userService;
	
	@Autowired JwtService jwtService;
	
 
    
	
	//(return list user with paging)
	@RequestMapping(value="")
	public ResponseEntity<?> GetAll(){
//		SecurityContext context = SecurityContextHolder.getContext();
//		Authentication authentication = context.getAuthentication();
//		Object auth =  authentication.getDetails();
		
		
		
		return new ResponseEntity<>(userService.GetAll(), HttpStatus.OK);
	}

	//get user by param /id
	@RequestMapping(value="/{id}")
	public ResponseEntity<?> GetOneUser(@PathVariable("id") int id){
		return new ResponseEntity<>(userService.GetOneUser(id),HttpStatus.OK);
	}

	//add new user
	@PostMapping(value="")
	public ResponseEntity<?> AddUser(@RequestBody User us){
		return new ResponseEntity<>(userService.AddUser(us), HttpStatus.OK);
	}

	//edit info user
	@PutMapping(value="")
	public ResponseEntity<?> UpdateUser(@RequestBody User us){
		return new ResponseEntity<>(userService.UpdateUser(us), HttpStatus.OK);
	}

	//delete user by id
	@DeleteMapping(value="")
	public ResponseEntity<?> DeleteUserById(@RequestBody User user){
		return new ResponseEntity<>(userService.DeleteById(user), HttpStatus.OK);
	}

	//login user
	@PostMapping(value="/login")
	public ResponseEntity<?> LoginUser(@RequestBody UserFormat fuser){
		String result;
		try {
			User user= userService.CheckLoginUser(fuser);
			result =  jwtService.generateTokenLogin(user);
		} catch (Exception e) {
			return new ResponseEntity<>(UtilMess.dialog(false, "Login false"), HttpStatus.OK);
		}
		return new ResponseEntity<>(UtilMess.dialog(true, result), HttpStatus.OK); 
		
		
	}
}
