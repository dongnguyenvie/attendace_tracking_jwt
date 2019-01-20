package com.APIATTENDANCE.application.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the blue_geo database table.
 * 
 */
@Entity
@Table(name="blue_geo")
@NamedQuery(name="BlueGeo.findAll", query="SELECT b FROM BlueGeo b")
public class BlueGeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="geo_blue_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer geo_blue_id;

	@Column(name="geo_blue_address")
	private String blue_address;

	@Column(name="geo_blue_level")
	private Integer blue_level;

	@Column(name="geo_blue_name")
	private String blue_name;

	@Column(name="geo_blue_type")
	private Integer blue_type;
	
	@ManyToOne
	@JoinColumn(name="geo_id")
	private Geo geo;

	public BlueGeo() {
	}

	public Integer getGeo_blue_id() {
		return geo_blue_id;
	}

	public void setGeo_blue_id(Integer geo_blue_id) {
		this.geo_blue_id = geo_blue_id;
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

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}



}