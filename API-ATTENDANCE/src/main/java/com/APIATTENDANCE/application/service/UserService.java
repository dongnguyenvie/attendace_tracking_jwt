package com.APIATTENDANCE.application.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.APIATTENDANCE.application.entity.User;
import com.APIATTENDANCE.application.entity.format.JsonFormat;
import com.APIATTENDANCE.application.entity.format.UserFormat;
import com.APIATTENDANCE.application.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userServer;

	public Object GetAll() {
		List<User> lstUser = userServer.findAll();
		
		String[] key = {"us_id","us_avatar","us_created","us_email","us_facebook_url","us_firstname","us_lastname","us_male","us_phone","us_token","us_username","role"};
		List<Object> objUser = new ArrayList<>();
		for(User us : lstUser) {
			Object[] value = {us.getUs_id(), us.getUs_avatar(), us.getUs_email(), us.getUs_facebook_url(), us.getUs_firstname(), us.getUs_lastname(), us.getUs_male(), us.getUs_phone(), us.getUs_phone(),us.getUs_token(), us.getUs_username(), us.getRole()};
			objUser.add(new JsonFormat(key,value).encode());
		}
		
		return objUser;
	}
	
	public Object UpdateUser(User user) {
		try {
			User us = userServer.save(user);
			return JsonFormat.message(true, "success");
		} catch (Exception e) {
			return JsonFormat.message(false, "false");
		}
	}
	public Object AddUser(User userNew) {
		try {
			Map<String, Object> user =  new HashMap<>();
			User fUser = userServer.save(userNew);
			user.put("us_id", fUser.getUs_id());
			user.put("lastname", fUser.getUs_lastname());
			user.put("firstname", fUser.getUs_firstname());
			user.put("token", fUser.getUs_token());
			
			return JsonFormat.message(true, user);
		} catch (Exception e) {
			return JsonFormat.message(false, "false");
		}
	}

	public User GetOneUser(int id) {
		return userServer.getOne(id);
	}

	public User FilterUser(User user) {
		User us = userServer.getOne(user.getUs_id());
		return us;
	}

	public Map<String, Object> DeleteById(User user) {
		try {
			userServer.deleteById(user.getUs_id());
			return JsonFormat.message(true, "Success");
		} catch (Exception e) {
			return JsonFormat.message(false, e.getMessage());
		}
	}

	public Map<String, Object> LoginUser(UserFormat userFormat) {
		User fUser = userServer.LoginUser(userFormat.getUsername(), userFormat.getPassword());
		if (null == fUser){
			return JsonFormat.message(false, "false");
		}
		String[] key = {"us_id","lastname","firstname","token"};
		Object[] value = {fUser.getUs_id(),fUser.getUs_lastname(),fUser.getUs_firstname(),fUser.getUs_token()};
		
		return JsonFormat.message(true, new JsonFormat(key,value).encode());

	}
	
	public User CheckLoginUser(UserFormat userFormat) {
		return userServer.LoginUser(userFormat.getUsername(), userFormat.getPassword());
	}

}
