package com.APIATTENDANCE.application.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APIATTENDANCE.application.entity.Geo;
import com.APIATTENDANCE.application.entity.Place;
import com.APIATTENDANCE.application.entity.format.JsonFormat;
import com.APIATTENDANCE.application.entity.format.PlaceFormat;
import com.APIATTENDANCE.application.repository.GeoRepository;
import com.APIATTENDANCE.application.repository.PlaceRepository;


@Service
public class PlaceService {
	
	@Autowired
	PlaceRepository placeServer;

	@Autowired
	GeoRepository geoServer;
	
	@PersistenceContext
	EntityManager em;
	
	private Map<String, Object> status;
	
	public Object GetAll(){
		List<Place> lstPlace = placeServer.findAll();
		List<Object> jsonPlace = new ArrayList<>();
		String[] key = {"place_id","place_address","place_created","place_name"};
		for(int i = 0; i < lstPlace.size(); i++) {
			Object[] value = {lstPlace.get(i).getPlace_id(),lstPlace.get(i).getPlace_address(),lstPlace.get(i).getPlace_created(),lstPlace.get(i).getPlace_name()};
			jsonPlace.add(new JsonFormat(key, value).encode());
		}
		return jsonPlace;
	}
	
	public Object GetInfoByID(int id){
		Place lstPlace = placeServer.getOne(id);
		String[] key = {"place_id","place_address","place_created","place_name"};
	
		Object[] value = {lstPlace.getPlace_id(),lstPlace.getPlace_address(),lstPlace.getPlace_created(),lstPlace.getPlace_name()};
		
		Object jsonPlace = new JsonFormat(key, value).encode();
		
		return jsonPlace;
	}
	
	public Map<String, Object> AddAndUpdate(Place place){
		try {
			placeServer.save(place);
			return JsonFormat.message(true, "Success");
		} catch (Exception e) {
			return JsonFormat.message(false, e.getMessage());
		}
	}
	
	public Object DeleteById(Place place){
		try {
			placeServer.deleteById(place.getPlace_id());
			return JsonFormat.message(true, "success");
		} catch (Exception e) {
			return JsonFormat.message(false, "place_id not exits");
		}
		
	}
	
	
	
	public Map<String, Object> AddGeoRelationship(PlaceFormat lstGeo){
		status = new HashMap<>();
		Geo geo ;
		try {
			Place place = placeServer.getOne(lstGeo.getPlace_id());
			if(place == null) {
				status = JsonFormat.message(false, "false");
				return status;
			}

			for(Geo geoF : lstGeo.getGeo_array()) {
				geo = new Geo();
				geo.setPlace(place);
				geo = geoServer.save(geo);
				//set geo
				if(geoF.getWifi_geo() !=null) {
					for(int i =0; i< geoF.getWifi_geo().size();i++) {
						geoF.getWifi_geo().get(i).setGeo(geo);
					}
					geo.setWifi_geo(geoF.getWifi_geo());
				}
				if(geoF.getSat_geo() !=null) {
					for(int i =0; i< geoF.getSat_geo().size();i++) {
						geoF.getSat_geo().get(i).setGeo(geo);
					}
					geo.setSat_geo(geoF.getSat_geo());
				}
				if(geoF.getBlue_geo() != null) {
					for(int i =0; i< geoF.getBlue_geo().size();i++) {
						geoF.getBlue_geo().get(i).setGeo(geo);
					}
					geo.setBlue_geo(geoF.getBlue_geo());
				}
				if(geoF.getCell_geo() !=null) {
					geoF.getCell_geo().setGeo(geo);
					geo.setCell_geo(geoF.getCell_geo());
				}
				if(geoF.getLocation_geo() !=null) {
					geoF.getLocation_geo().setGeo(geo);
					geo.setLocation_geo(geoF.getLocation_geo());
				}
				if(geoF.getSensor_geo() !=null) {
					geoF.getSensor_geo().setGeo(geo);
					geo.setSensor_geo(geoF.getSensor_geo());
				}
				
				//update geo
				geo = geoServer.save(geo);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return JsonFormat.message(true, "success");
	}
	
	public Object GetGeoAndRelationship(PlaceFormat geoF) {
		Place place;
		try {
			place = placeServer.getOne(geoF.getPlace_id());
			place.setUser(null);
			place.setUserFrequency(null);
			geoF.setPlace_address(place.getPlace_address());
			geoF.setPlace_name(place.getPlace_name());
			geoF.setGeo_array(place.getGeo());
		} catch (Exception e) {
			return JsonFormat.message(false, "place not exits");
		}
		return geoF;
	}
	
	public Map<String, Object> DeleteAllRelationship(PlaceFormat placeF){
		try {
			Place place = placeServer.getOne(placeF.getPlace_id());
			 if(place == null) {
				return JsonFormat.message(false, "not found place");
			 }
			 if(place.getGeo() !=null) {
				for(Geo geo : place.getGeo()) {
					geoServer.delete(geo);
				}
			 }
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return JsonFormat.message(true, "success");
	}
}
