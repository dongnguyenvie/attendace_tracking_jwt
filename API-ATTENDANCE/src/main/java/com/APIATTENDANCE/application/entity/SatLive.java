package com.APIATTENDANCE.application.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sat_live database table.
 * 
 */
@Entity
@Table(name="sat_live")
@NamedQuery(name="SatLive.findAll", query="SELECT s FROM SatLive s")
public class SatLive implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sat_id")
	private Integer sat_id;

	@Column(name="sat_azimuth_degrees")
	private double sat_azimuth_degrees;

	@Column(name="sat_carrier_frequency")
	private Integer sat_carrier_frequency;

	@Column(name="sat_constellation_type")
	private Integer sat_constellation_type;

	@Column(name="sat_dbhz")
	private Integer sat_dbhz;

	@Column(name="sat_elevation_degrees")
	private double sat_elevation_degrees;

	@Column(name="sat_svid")
	private Integer sat_svid;
	
	@ManyToOne
	@JoinColumn(name="track_id")
	private Track track;

	public SatLive() {
	}

	public Integer getSat_id() {
		return sat_id;
	}

	public void setSat_id(Integer sat_id) {
		this.sat_id = sat_id;
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

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}



}