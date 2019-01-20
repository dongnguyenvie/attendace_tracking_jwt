package com.APIATTENDANCE.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.APIATTENDANCE.application.entity.Company;
import com.APIATTENDANCE.application.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	
	@Autowired CompanyService companyService;
	
	@RequestMapping("")
	public ResponseEntity<?> GetAll(){
		return new ResponseEntity<>(companyService.GetAll(), HttpStatus.OK);
	}
	
	@PostMapping("/filter")
	public ResponseEntity<?> GetCompanyByProvice(@RequestBody Company com){
		return new ResponseEntity<>(companyService.GetComUsingProvice(com), HttpStatus.OK);
	}
	
}
