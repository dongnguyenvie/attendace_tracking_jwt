package com.APIATTENDANCE.application.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.sql.Timestamp;

import java.util.List;


/**
 * The persistent class for the tracks database table.
 * 
 */
@Entity
@Table(name="tracks")
@JsonIgnoreProperties({"user"})
@NamedQuery(name="Track.findAll", query="SELECT t FROM Track t")
public class Track implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="track_id")
	private Integer track_id;

	
	@Column(name="track_write_time",insertable=false, updatable=false)
	private Timestamp track_write_time;
	
	@Column(name="track_position_time")
	private Timestamp track_position_time;

	
	@ManyToOne
	@JoinColumn(name="us_id")
	private User user;
	
	@OneToOne(cascade = {CascadeType.ALL},mappedBy="track",fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"track"})
	private SenLive sensor_live;
	
	@OneToMany(cascade = {CascadeType.ALL},mappedBy="track",fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"track"})
	private List<SatLive> sat_live;
	
	@OneToMany(cascade = {CascadeType.ALL},mappedBy="track",fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"track"})
	private List<BlueLive> blue_live;
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy="track",fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"track"})
	private List<WifiLive> wifi_live;
	
	@OneToOne(cascade = {CascadeType.ALL},mappedBy="track")
	@JsonIgnoreProperties({"track"})
	private LocationLive location_live;
	
	@OneToOne(cascade = {CascadeType.ALL},mappedBy="track")
	@JsonIgnoreProperties({"track"})
	private CellLive cell_live;

	
	public Track() {
	}


	public Integer getTrack_id() {
		return track_id;
	}


	public void setTrack_id(Integer track_id) {
		this.track_id = track_id;
	}

	
	public Timestamp getTrack_write_time() {
		return track_write_time;
	}


	public void setTrack_write_time(Timestamp track_write_time) {
		this.track_write_time = track_write_time;
	}


	public Timestamp getTrack_position_time() {
		return track_position_time;
	}


	public void setTrack_position_time(Timestamp track_position_time) {
		this.track_position_time = track_position_time;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public SenLive getSensor_live() {
		return sensor_live;
	}


	public void setSensor_live(SenLive sensor_live) {
		this.sensor_live = sensor_live;
	}


	public List<SatLive> getSat_live() {
		return sat_live;
	}


	public void setSat_live(List<SatLive> sat_live) {
		this.sat_live = sat_live;
	}


	public List<BlueLive> getBlue_live() {
		return blue_live;
	}


	public void setBlue_live(List<BlueLive> blue_live) {
		this.blue_live = blue_live;
	}


	public List<WifiLive> getWifi_live() {
		return wifi_live;
	}


	public void setWifi_live(List<WifiLive> wifi_live) {
		this.wifi_live = wifi_live;
	}


	public LocationLive getLocation_live() {
		return location_live;
	}


	public void setLocation_live(LocationLive location_live) {
		this.location_live = location_live;
	}


	public CellLive getCell_live() {
		return cell_live;
	}


	public void setCell_live(CellLive cell_live) {
		this.cell_live = cell_live;
	}

}