package com.APIATTENDANCE.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APIATTENDANCE.application.entity.UserFrequency;
import com.APIATTENDANCE.application.repository.UserFrequencyRepository;

@Service
public class UserFrequencyService {

	@Autowired
	UserFrequencyRepository userFrequencyServer;
	
	public List<UserFrequency> GetAll(){
		return userFrequencyServer.findAll();
	}
}
