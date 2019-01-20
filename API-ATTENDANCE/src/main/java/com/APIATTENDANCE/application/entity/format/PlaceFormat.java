package com.APIATTENDANCE.application.entity.format;

import java.util.List;


import com.APIATTENDANCE.application.entity.Geo;

public class PlaceFormat {
	private Integer place_id;
	private String place_name;
	private String place_address;
	List<Geo> geo_array;
	
	public PlaceFormat() {}

	public Integer getPlace_id() {
		return place_id;
	}

	public void setPlace_id(Integer place_id) {
		this.place_id = place_id;
	}

	public String getPlace_name() {
		return place_name;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}

	public String getPlace_address() {
		return place_address;
	}

	public void setPlace_address(String place_address) {
		this.place_address = place_address;
	}

	public List<Geo> getGeo_array() {
		return geo_array;
	}

	public void setGeo_array(List<Geo> geo_array) {
		this.geo_array = geo_array;
	}


}
