package com.APIATTENDANCE.application.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the location_geo database table.
 * 
 */
@Entity
@Table(name="location_geo")
@NamedQuery(name="LocationGeo.findAll", query="SELECT l FROM LocationGeo l")
public class LocationGeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="geo_loc_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer geo_loc_id;

	@Column(name="geo_loc_accuracy")
	private double loc_accuracy;

	@Column(name="geo_loc_altitude")
	private double loc_altitude;

	@Column(name="geo_loc_bearing")
	private double loc_bearing;

	@Column(name="geo_loc_latitude")
	private double loc_latitude;

	@Column(name="geo_loc_longitude")
	private double loc_longitude;

	@Column(name="geo_loc_provider")
	private Integer loc_provider;

	@Column(name="geo_loc_speed")
	private double loc_speed;
	
	@OneToOne
	@JoinColumn(name="geo_id")
	private Geo geo;

	public LocationGeo() {
	}

	public Integer getGeo_loc_id() {
		return geo_loc_id;
	}

	public void setGeo_loc_id(Integer geo_loc_id) {
		this.geo_loc_id = geo_loc_id;
	}

	public double getLoc_accuracy() {
		return loc_accuracy;
	}

	public void setLoc_accuracy(double loc_accuracy) {
		this.loc_accuracy = loc_accuracy;
	}

	public double getLoc_altitude() {
		return loc_altitude;
	}

	public void setLoc_altitude(double loc_altitude) {
		this.loc_altitude = loc_altitude;
	}

	public double getLoc_bearing() {
		return loc_bearing;
	}

	public void setLoc_bearing(double loc_bearing) {
		this.loc_bearing = loc_bearing;
	}

	public double getLoc_latitude() {
		return loc_latitude;
	}

	public void setLoc_latitude(double loc_latitude) {
		this.loc_latitude = loc_latitude;
	}

	public double getLoc_longitude() {
		return loc_longitude;
	}

	public void setLoc_longitude(double loc_longitude) {
		this.loc_longitude = loc_longitude;
	}

	public Integer getLoc_provider() {
		return loc_provider;
	}

	public void setLoc_provider(Integer loc_provider) {
		this.loc_provider = loc_provider;
	}

	public double getLoc_speed() {
		return loc_speed;
	}

	public void setLoc_speed(double loc_speed) {
		this.loc_speed = loc_speed;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}



}