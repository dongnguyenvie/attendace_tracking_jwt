package com.APIATTENDANCE.application.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wifi_live database table.
 * 
 */
@Entity
@Table(name="wifi_live")
@NamedQuery(name="WifiLive.findAll", query="SELECT w FROM WifiLive w")
public class WifiLive implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="wifi_id")
	private Integer wifi_id;

	@Column(name="wifi_bssid")
	private String wifi_bssid;

	@Column(name="wifi_capabilities")
	private String wifi_capabilities;

	@Column(name="wifi_channel_width")
	private Integer wifi_channel_width;

	@Column(name="wifi_frequency")
	private Integer wifi_frequency;

	@Column(name="wifi_level")
	private Integer wifi_level;

	@Column(name="wifi_ssid")
	private String wifi_ssid;
	
	@ManyToOne
	@JoinColumn(name="track_id")
	private Track track;

	public WifiLive() {
	}

	public Integer getWifi_id() {
		return wifi_id;
	}

	public void setWifi_id(Integer wifi_id) {
		this.wifi_id = wifi_id;
	}

	public String getWifi_bssid() {
		return wifi_bssid;
	}

	public void setWifi_bssid(String wifi_bssid) {
		this.wifi_bssid = wifi_bssid;
	}

	public String getWifi_capabilities() {
		return wifi_capabilities;
	}

	public void setWifi_capabilities(String wifi_capabilities) {
		this.wifi_capabilities = wifi_capabilities;
	}

	public Integer getWifi_channel_width() {
		return wifi_channel_width;
	}

	public void setWifi_channel_width(Integer wifi_channel_width) {
		this.wifi_channel_width = wifi_channel_width;
	}

	public Integer getWifi_frequency() {
		return wifi_frequency;
	}

	public void setWifi_frequency(Integer wifi_frequency) {
		this.wifi_frequency = wifi_frequency;
	}

	public Integer getWifi_level() {
		return wifi_level;
	}

	public void setWifi_level(Integer wifi_level) {
		this.wifi_level = wifi_level;
	}

	public String getWifi_ssid() {
		return wifi_ssid;
	}

	public void setWifi_ssid(String wifi_ssid) {
		this.wifi_ssid = wifi_ssid;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}


}