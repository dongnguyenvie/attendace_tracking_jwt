package com.APIATTENDANCE.application.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the blue_live database table.
 * 
 */
@Entity
@Table(name="blue_live")
@NamedQuery(name="BlueLive.findAll", query="SELECT b FROM BlueLive b")
public class BlueLive implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="blue_id")
	private Integer blue_id;

	@Column(name="blue_address")
	private String blue_address;

	@Column(name="blue_level")
	private Integer blue_level;

	@Column(name="blue_name")
	private String blue_name;

	@Column(name="blue_type")
	private Integer blue_type;
	
	@ManyToOne
	@JoinColumn(name="track_id")
	private Track track;

	public BlueLive() {
	}

	public Integer getBlue_id() {
		return blue_id;
	}

	public void setBlue_id(Integer blue_id) {
		this.blue_id = blue_id;
	}
	
	public String getBlue_address() {
		return blue_address;
	}

	public void setBlue_address(String blue_address) {
		this.blue_address = blue_address;
	}

	public Integer getBlue_level() {
		return blue_level;
	}

	public void setBlue_level(Integer blue_level) {
		this.blue_level = blue_level;
	}

	public String getBlue_name() {
		return blue_name;
	}

	public void setBlue_name(String blue_name) {
		this.blue_name = blue_name;
	}

	public Integer getBlue_type() {
		return blue_type;
	}

	public void setBlue_type(Integer blue_type) {
		this.blue_type = blue_type;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}



}