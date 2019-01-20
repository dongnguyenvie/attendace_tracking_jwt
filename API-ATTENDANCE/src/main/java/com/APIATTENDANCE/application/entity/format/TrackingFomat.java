package com.APIATTENDANCE.application.entity.format;


import java.sql.Timestamp;
import java.util.List;

import com.APIATTENDANCE.application.entity.BlueLive;
import com.APIATTENDANCE.application.entity.CellLive;
import com.APIATTENDANCE.application.entity.LocationLive;
import com.APIATTENDANCE.application.entity.SatLive;
import com.APIATTENDANCE.application.entity.SenLive;
import com.APIATTENDANCE.application.entity.WifiLive;

public class TrackingFomat {
	private Integer us_id;
	private Timestamp position_time;
	private SenLive sensor;
	private CellLive cell;
	private LocationLive location;
	private List<WifiLive> wifi;
	private List<SatLive> sat;
	private List<BlueLive> bluetooth;
	private Timestamp timeFrom;
	private Timestamp timeTo;

	public TrackingFomat() {}

	public Integer getUs_id() {
		return us_id;
	}

	public void setUs_id(Integer us_id) {
		this.us_id = us_id;
	}

	public Timestamp getPosition_time() {
		return position_time;
	}

	public void setPosition_time(Timestamp position_time) {
		this.position_time = position_time;
	}

	public SenLive getSensor() {
		return sensor;
	}

	public void setSensor(SenLive sensor) {
		this.sensor = sensor;
	}

	public CellLive getCell() {
		return cell;
	}

	public void setCell(CellLive cell) {
		this.cell = cell;
	}

	public LocationLive getLocation() {
		return location;
	}

	public void setLocation(LocationLive location) {
		this.location = location;
	}

	public List<WifiLive> getWifi() {
		return wifi;
	}

	public void setWifi(List<WifiLive> wifi) {
		this.wifi = wifi;
	}

	public List<SatLive> getSat() {
		return sat;
	}

	public void setSat(List<SatLive> sat) {
		this.sat = sat;
	}

	public List<BlueLive> getBluetooth() {
		return bluetooth;
	}

	public void setBluetooth(List<BlueLive> bluetooth) {
		this.bluetooth = bluetooth;
	}

	public Timestamp getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(Timestamp timeFrom) {
		this.timeFrom = timeFrom;
	}

	public Timestamp getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(Timestamp timeTo) {
		this.timeTo = timeTo;
	}

	
	
}
