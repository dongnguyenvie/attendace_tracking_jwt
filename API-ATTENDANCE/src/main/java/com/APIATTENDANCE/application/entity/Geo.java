package com.APIATTENDANCE.application.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the geos database table.
 * 
 */
@Entity
@Table(name="geos")
@JsonIgnoreProperties({"place"})
public class Geo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="geo_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer geo_id;

	@Column(name="geo_time", insertable=false,updatable=false)
	private Timestamp geo_time;
	
	@ManyToOne
	@JoinColumn(name="place_id")
	@JsonIgnoreProperties({"geo","company"})
	private Place place;
	
	@OneToOne(mappedBy="geo", cascade = {CascadeType.ALL})
	@JsonProperty("sensor")
	@JsonIgnoreProperties({"geo"})
	private SenGeo sensor_geo;
	
	@OneToMany(mappedBy="geo", cascade = {CascadeType.ALL})
	@JsonProperty("sat")
	@JsonIgnoreProperties({"geo"})
	private List<SatGeo> sat_geo;
	
	@OneToMany(mappedBy="geo",cascade = {CascadeType.ALL})
	@JsonProperty("bluetooth")
	@JsonIgnoreProperties({"geo"})
	private List<BlueGeo> blue_geo;
	
	@OneToMany(mappedBy="geo",cascade = {CascadeType.ALL})
	@JsonProperty("wifi")
	@JsonIgnoreProperties({"geo"})
	private List<WifiGeo> wifi_geo;
	
	@OneToOne(mappedBy="geo",cascade = {CascadeType.ALL})
	@JsonProperty("location")
	@JsonIgnoreProperties({"geo"})
	private LocationGeo location_geo;
	
	@OneToOne(mappedBy="geo",cascade = {CascadeType.ALL})
	@JsonProperty("cell")
	@JsonIgnoreProperties({"geo"})
	private CellGeo cell_geo;
	
	public Geo() {
	}

	public Integer getGeo_id() {
		return geo_id;
	}

	public Timestamp getGeo_time() {
		return geo_time;
	}

	public void setGeo_time(Timestamp geo_time) {
		this.geo_time = geo_time;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public SenGeo getSensor_geo() {
		return sensor_geo;
	}

	public void setSensor_geo(SenGeo sensor_geo) {
		this.sensor_geo = sensor_geo;
	}

	public List<SatGeo> getSat_geo() {
		return sat_geo;
	}

	public void setSat_geo(List<SatGeo> sat_geo) {
		this.sat_geo = sat_geo;
	}

	public List<BlueGeo> getBlue_geo() {
		return blue_geo;
	}

	public void setBlue_geo(List<BlueGeo> blue_geo) {
		this.blue_geo = blue_geo;
	}

	public List<WifiGeo> getWifi_geo() {
		return wifi_geo;
	}

	public void setWifi_geo(List<WifiGeo> wifi_geo) {
		this.wifi_geo = wifi_geo;
	}

	public LocationGeo getLocation_geo() {
		return location_geo;
	}

	public void setLocation_geo(LocationGeo location_geo) {
		this.location_geo = location_geo;
	}

	public CellGeo getCell_geo() {
		return cell_geo;
	}

	public void setCell_geo(CellGeo cell_geo) {
		this.cell_geo = cell_geo;
	}

	public void setGeo_id(Integer geo_id) {
		this.geo_id = geo_id;
	}



}