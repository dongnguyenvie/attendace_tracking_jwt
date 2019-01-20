package com.APIATTENDANCE.application.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APIATTENDANCE.application.entity.Geo;

import com.APIATTENDANCE.application.repository.GeoRepository;
import com.APIATTENDANCE.application.repository.PlaceRepository;

@Service
public class GeoService {

	@Autowired
	GeoRepository geoServer;
	@Autowired
	PlaceRepository placeServer;
	

	
	private Map<String, Object> status;
	
	public List<Geo> GetAll(){
		return geoServer.findAll();
	}
	
}
