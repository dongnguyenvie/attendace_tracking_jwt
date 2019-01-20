package com.APIATTENDANCE.application.entity;

import java.io.Serializable;
import javax.persistence.*;



import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The persistent class for the cell_geo database table.
 * 
 */
@Entity
@Table(name="cell_geo")

public class CellGeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="geo_cell_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer geo_cell_id;
	
	@Column(name="geo_cell_level")
	private Integer cell_level;

	@Column(name="geo_cell_mnc")
	private Integer cell_mnc;

	@Column(name="geo_cell_psc")
	private Integer cell_psc;

	@Column(name="geo_cell_real_id")
	private Integer cell_real_id;

	@Column(name="geo_cell_type")
	private String cell_type;
	
	@OneToOne
	@JoinColumn(name="geo_id")
	private Geo geo;

	public CellGeo() {
	}

	public Integer getGeo_cell_id() {
		return geo_cell_id;
	}

	public void setGeo_cell_id(Integer geo_cell_id) {
		this.geo_cell_id = geo_cell_id;
	}

	public Integer getCell_level() {
		return cell_level;
	}

	public void setCell_level(Integer cell_level) {
		this.cell_level = cell_level;
	}

	public Integer getCell_mnc() {
		return cell_mnc;
	}

	public void setCell_mnc(Integer cell_mnc) {
		this.cell_mnc = cell_mnc;
	}

	public Integer getCell_psc() {
		return cell_psc;
	}

	public void setCell_psc(Integer cell_psc) {
		this.cell_psc = cell_psc;
	}

	public Integer getCell_real_id() {
		return cell_real_id;
	}

	public void setCell_real_id(Integer cell_real_id) {
		this.cell_real_id = cell_real_id;
	}

	public String getCell_type() {
		return cell_type;
	}

	public void setCell_type(String cell_type) {
		this.cell_type = cell_type;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}




}