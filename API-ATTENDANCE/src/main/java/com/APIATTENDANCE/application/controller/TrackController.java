package com.APIATTENDANCE.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.APIATTENDANCE.application.entity.User;
import com.APIATTENDANCE.application.entity.format.TrackingFomat;
import com.APIATTENDANCE.application.service.TrackService;
import com.APIATTENDANCE.application.service.UserService;

@RestController
@CrossOrigin(origins = "*")
//v1.1.2
@RequestMapping("/api/track")
public class TrackController {
	
	@Autowired TrackService trackService;
	@Autowired UserService userService;
	
	
	@RequestMapping(value="")
	public ResponseEntity<?> GetAll(){
		return new ResponseEntity<>(trackService.GetAll(), HttpStatus.OK);
	}
	
	//(Add ArrayList Points)
	@PostMapping(value="")
	public ResponseEntity<?> AddListTracking(@RequestBody List<TrackingFomat> lstTrack){
		return new ResponseEntity<>(trackService.AddListTracking(lstTrack), HttpStatus.OK);
	}
	
	//(get all track of user)
	@PostMapping("/filter")
	public ResponseEntity<?> FilterUser(@RequestBody TrackingFomat track){
		return new ResponseEntity<>(trackService.GetListTrackByIdTime(track), HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> DeleteTrackByUserId(@RequestBody TrackingFomat track){
		return new ResponseEntity<>(trackService.DeleteListTrackByUserId(track), HttpStatus.OK);
	}
	
}
