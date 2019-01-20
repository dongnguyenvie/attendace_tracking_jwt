package com.APIATTENDANCE.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.APIATTENDANCE.application.entity.format.PlaceFormat;
import com.APIATTENDANCE.application.service.PlaceService;

@RestController
@CrossOrigin(origins = "*")
//v1.1.2
@RequestMapping("/api/place")
public class GeoController {
	
	@Autowired
	PlaceService placeService;
	
	//(new reset)
	@PostMapping("/geo")
	public ResponseEntity<?> ResetAndAddNew(@RequestBody PlaceFormat geo){
		placeService.DeleteAllRelationship(geo);
		return new ResponseEntity<>(placeService.AddGeoRelationship(geo), HttpStatus.OK);
	}
	
	//(Add more)
	@PutMapping("/geo")
	public ResponseEntity<?> AddGeoRelationship(@RequestBody PlaceFormat geo){
		return new ResponseEntity<>(placeService.AddGeoRelationship(geo), HttpStatus.OK);
	}
	
	//(return array geo of place)
	@PostMapping("/geo/get")
	public ResponseEntity<?> GetGeo(@RequestBody PlaceFormat geo){
		return new ResponseEntity<>(placeService.GetGeoAndRelationship(geo) , HttpStatus.OK);
	}
	
	//(Delete Geo)
	@DeleteMapping("/geo")
	public ResponseEntity<?> DeleteAllRelationship(@RequestBody PlaceFormat placeID){
		return new ResponseEntity<>(placeService.DeleteAllRelationship(placeID), HttpStatus.OK);
	}
	
	
//	@PostMapping("")
//	public ResponseEntity<?> AddGeoRelationship(GeoFormat geo){
//		return new ResponseEntity<>(geo, HttpStatus.OK);
//	}
}

