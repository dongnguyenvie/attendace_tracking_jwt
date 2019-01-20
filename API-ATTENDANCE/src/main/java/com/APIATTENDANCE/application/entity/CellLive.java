package com.APIATTENDANCE.application.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cell_live database table.
 * 
 */
@Entity
@Table(name="cell_live")
@NamedQuery(name="CellLive.findAll", query="SELECT c FROM CellLive c")
public class CellLive implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cell_id")
	private Integer cell_id;

	@Column(name="cell_level")
	private Integer cell_level;

	@Column(name="cell_mnc")
	private Integer cell_mnc;

	@Column(name="cell_psc")
	private Integer cell_psc;

	@Column(name="cell_real_id")
	private Integer cell_real_id;

	@Column(name="cell_type")
	private String cell_type;

	@OneToOne()
	@JoinColumn(name="track_id")
	private Track track;

	public CellLive() {
	}

	public Integer getCell_id() {
		return cell_id;
	}

	public void setCell_id(Integer cell_id) {
		this.cell_id = cell_id;
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

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

}