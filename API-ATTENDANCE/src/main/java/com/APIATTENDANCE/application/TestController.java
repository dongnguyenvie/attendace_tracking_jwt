package com.APIATTENDANCE.application;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.APIATTENDANCE.application.entity.Track;
import com.APIATTENDANCE.application.entity.format.JsonFormat;
import com.APIATTENDANCE.application.entity.format.PlaceFormat;
import com.APIATTENDANCE.application.entity.format.TrackingFomat;
import com.APIATTENDANCE.application.service.CompanyService;
import com.APIATTENDANCE.application.service.GeoService;
import com.APIATTENDANCE.application.service.PlaceService;
import com.APIATTENDANCE.application.service.TrackService;
import com.APIATTENDANCE.application.service.UserFrequencyService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	PlaceService placeService;
	
	@Autowired
	UserFrequencyService userFrequencyService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	GeoService geoService;
	@Autowired
	TrackService track;
	
	@RequestMapping("/place")
	public ResponseEntity<?> PlaceGetAll(){
		return new ResponseEntity<>(placeService.GetAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/userfre")
	public ResponseEntity<?> UserFrequencyGetAll(){
		return new ResponseEntity<>(userFrequencyService.GetAll(), HttpStatus.OK);
	}

	@RequestMapping("/company")
	public ResponseEntity<?> CompanyGetAll(){
		return new ResponseEntity<>(companyService.GetAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/geo")
	public ResponseEntity<?> GeoGetAll(){
		return new ResponseEntity<>(geoService.GetAll(), HttpStatus.OK);
	}
	
	@PostMapping("/geos")
	public ResponseEntity<?> GetGeoAll(@RequestBody PlaceFormat geo){
		return new ResponseEntity<>(geo , HttpStatus.OK);
	}
	
	@PostMapping("/track")
	public ResponseEntity<?> GetGeoAll(@RequestBody TrackingFomat tracks){

		return new ResponseEntity<>(track.FilterTrackUserTime(tracks) , HttpStatus.OK);
	}
	
	
	@PostMapping("/obj")
	public ResponseEntity<?> testObj(@RequestBody Object obj){
		Map<String, Object> json = new HashMap<>();
		json.put("us_id", 1);
		json.put("timeFrom", "2018-11-18T13:37:18.824");
		json.put("timeTo", "2018-11-22T16:37:18.824");
		RestTemplate restTemplate = new RestTemplate();
		

		
		//List<Object> result = restTemplate.exchange("http://localhost:8081/api/track/filter", HttpMethod.POST, new HttpEntity<>(json), new ParameterizedTypeReference<List<Object>>() {
		//}).getBody();
		//Map<String, Object> rs = (Map<String, Object>) result.get(1);
		
		Map<String, Object> map = (Map<String, Object>) obj;
		System.out.println(map.get("abc"));;
		
		return new ResponseEntity<>("aa" , HttpStatus.OK);
	}
	
	@RequestMapping("/abc")
	public ResponseEntity<?> reaaaa(){
		List<Track> trackz = track.GetAll();
		
		List<Object> obj = new ArrayList<>();
	
		for(Track track : trackz) {
			String[]a = {"us.id","vv"};
			Object[]b = {track.getTrack_id(),track.getTrack_position_time()};
			JsonFormat abc = new JsonFormat(a,b); 
			obj.add(abc.encode());
		}
		
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	
}
