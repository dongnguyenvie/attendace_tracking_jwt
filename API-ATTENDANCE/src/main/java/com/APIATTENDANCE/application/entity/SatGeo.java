package com.APIATTENDANCE.application.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the sat_geo database table.
 * 
 */
@Entity
@Table(name="sat_geo")
@NamedQuery(name="SatGeo.findAll", query="SELECT s FROM SatGeo s")
public class SatGeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="geo_sat_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer geo_sat_id;

	@Column(name="geo_sat_azimuth_degrees")
	private double sat_azimuth_degrees;

	@Column(name="geo_sat_carrier_frequency")
	private Integer sat_carrier_frequency;

	@Column(name="geo_sat_constellation_type")
	private Integer sat_constellation_type;

	@Column(name="geo_sat_dbhz")
	private Integer sat_dbhz;

	@Column(name="geo_sat_elevation_degrees")
	private double sat_elevation_degrees;

	@Column(name="geo_sat_svid")
	private Integer sat_svid;

	@ManyToOne
	@JoinColumn(name="geo_id")
	private Geo geo;
	
	public SatGeo() {
	}

	public Integer getGeo_sat_id() {
		return geo_sat_id;
	}

	public void setGeo_sat_id(Integer geo_sat_id) {
		this.geo_sat_id = geo_sat_id;
	}

	public double getSat_azimuth_degrees() {
		return sat_azimuth_degrees;
	}

	public void setSat_azimuth_degrees(double sat_azimuth_degrees) {
		this.sat_azimuth_degrees = sat_azimuth_degrees;
	}

	public Integer getSat_carrier_frequency() {
		return sat_carrier_frequency;
	}

	public void setSat_carrier_frequency(Integer sat_carrier_frequency) {
		this.sat_carrier_frequency = sat_carrier_frequency;
	}

	public Integer getSat_constellation_type() {
		return sat_constellation_type;
	}

	public void setSat_constellation_type(Integer sat_constellation_type) {
		this.sat_constellation_type = sat_constellation_type;
	}

	public Integer getSat_dbhz() {
		return sat_dbhz;
	}

	public void setSat_dbhz(Integer sat_dbhz) {
		this.sat_dbhz = sat_dbhz;
	}

	public double getSat_elevation_degrees() {
		return sat_elevation_degrees;
	}

	public void setSat_elevation_degrees(double sat_elevation_degrees) {
		this.sat_elevation_degrees = sat_elevation_degrees;
	}

	public Integer getSat_svid() {
		return sat_svid;
	}

	public void setSat_svid(Integer sat_svid) {
		this.sat_svid = sat_svid;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}

}