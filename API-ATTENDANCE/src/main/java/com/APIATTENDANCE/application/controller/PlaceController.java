package com.APIATTENDANCE.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.APIATTENDANCE.application.entity.Place;
import com.APIATTENDANCE.application.service.PlaceService;

@RestController
@CrossOrigin(origins = "*")
//v1.1.2
@RequestMapping("/api/place")
public class PlaceController {
	
	@Autowired
	PlaceService placeService;
	
	@RequestMapping("/all")
	public ResponseEntity<?> GetAll(){
		return new ResponseEntity<>(placeService.GetAll(),HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?> AddPlace(@RequestBody Place place){
		return new ResponseEntity<>(placeService.AddAndUpdate(place), HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<?> UpdatePlace(@RequestBody Place place){
		return new ResponseEntity<>(placeService.AddAndUpdate(place), HttpStatus.OK);
	}
	
	@DeleteMapping("")
	public ResponseEntity<?> DeleteById(@RequestBody Place place){
		return new ResponseEntity<>(placeService.DeleteById(place), HttpStatus.OK);
	}
	
	@RequestMapping("")
	public ResponseEntity<?> GetInfoById(@RequestParam("id") int id){
		return new ResponseEntity<>(placeService.GetInfoByID(id), HttpStatus.OK);
	}
	
}
