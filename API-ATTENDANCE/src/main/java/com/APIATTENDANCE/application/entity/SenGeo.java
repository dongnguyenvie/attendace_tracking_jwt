package com.APIATTENDANCE.application.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sen_geo database table.
 * 
 */
@Entity
@Table(name="sen_geo")
@NamedQuery(name="SenGeo.findAll", query="SELECT s FROM SenGeo s")
public class SenGeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="geo_sen_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer geo_sen_id;

	@Column(name="geo_sen_acc_x")
	private double sen_acc_x;

	@Column(name="geo_sen_acc_y")
	private double sen_acc_y;

	@Column(name="geo_sen_acc_z")
	private double sen_acc_z;

	@Column(name="geo_sen_gra_x")
	private double sen_gra_x;

	@Column(name="geo_sen_gra_y")
	private double sen_gra_y;

	@Column(name="geo_sen_gra_z")
	private double sen_gra_z;

	@Column(name="geo_sen_gyr_x")
	private double sen_gyr_x;

	@Column(name="geo_sen_gyr_y")
	private double sen_gyr_y;

	@Column(name="geo_sen_gyr_z")
	private double sen_gyr_z;

	@Column(name="geo_sen_lac_x")
	private double sen_lac_x;

	@Column(name="geo_sen_lac_y")
	private double sen_lac_y;

	@Column(name="geo_sen_lac_z")
	private double sen_lac_z;

	@Column(name="geo_sen_light")
	private double sen_light;

	@Column(name="geo_sen_mag_x")
	private double sen_mag_x;

	@Column(name="geo_sen_mag_y")
	private double sen_mag_y;

	@Column(name="geo_sen_mag_z")
	private double sen_mag_z;

	@Column(name="geo_sen_proximity")
	private double sen_proximity;

	@Column(name="geo_sen_rov_scalar")
	private double sen_rov_scalar;

	@Column(name="geo_sen_rov_x")
	private double sen_rov_x;

	@Column(name="geo_sen_rov_y")
	private double sen_rov_y;

	@Column(name="geo_sen_rov_z")
	private double sen_rov_z;

	@OneToOne
	@JoinColumn(name="geo_id")
	private Geo geo;
	
	public SenGeo() {
	}

	public Integer getGeo_sen_id() {
		return geo_sen_id;
	}

	public void setGeo_sen_id(Integer geo_sen_id) {
		this.geo_sen_id = geo_sen_id;
	}

	public double getSen_acc_x() {
		return sen_acc_x;
	}

	public void setSen_acc_x(double sen_acc_x) {
		this.sen_acc_x = sen_acc_x;
	}

	public double getSen_acc_y() {
		return sen_acc_y;
	}

	public void setSen_acc_y(double sen_acc_y) {
		this.sen_acc_y = sen_acc_y;
	}

	public double getSen_acc_z() {
		return sen_acc_z;
	}

	public void setSen_acc_z(double sen_acc_z) {
		this.sen_acc_z = sen_acc_z;
	}

	public double getSen_gra_x() {
		return sen_gra_x;
	}

	public void setSen_gra_x(double sen_gra_x) {
		this.sen_gra_x = sen_gra_x;
	}

	public double getSen_gra_y() {
		return sen_gra_y;
	}

	public void setSen_gra_y(double sen_gra_y) {
		this.sen_gra_y = sen_gra_y;
	}

	public double getSen_gra_z() {
		return sen_gra_z;
	}

	public void setSen_gra_z(double sen_gra_z) {
		this.sen_gra_z = sen_gra_z;
	}

	public double getSen_gyr_x() {
		return sen_gyr_x;
	}

	public void setSen_gyr_x(double sen_gyr_x) {
		this.sen_gyr_x = sen_gyr_x;
	}

	public double getSen_gyr_y() {
		return sen_gyr_y;
	}

	public void setSen_gyr_y(double sen_gyr_y) {
		this.sen_gyr_y = sen_gyr_y;
	}

	public double getSen_gyr_z() {
		return sen_gyr_z;
	}

	public void setSen_gyr_z(double sen_gyr_z) {
		this.sen_gyr_z = sen_gyr_z;
	}

	public double getSen_lac_x() {
		return sen_lac_x;
	}

	public void setSen_lac_x(double sen_lac_x) {
		this.sen_lac_x = sen_lac_x;
	}

	public double getSen_lac_y() {
		return sen_lac_y;
	}

	public void setSen_lac_y(double sen_lac_y) {
		this.sen_lac_y = sen_lac_y;
	}

	public double getSen_lac_z() {
		return sen_lac_z;
	}

	public void setSen_lac_z(double sen_lac_z) {
		this.sen_lac_z = sen_lac_z;
	}

	public double getSen_light() {
		return sen_light;
	}

	public void setSen_light(double sen_light) {
		this.sen_light = sen_light;
	}

	public double getSen_mag_x() {
		return sen_mag_x;
	}

	public void setSen_mag_x(double sen_mag_x) {
		this.sen_mag_x = sen_mag_x;
	}

	public double getSen_mag_y() {
		return sen_mag_y;
	}

	public void setSen_mag_y(double sen_mag_y) {
		this.sen_mag_y = sen_mag_y;
	}

	public double getSen_mag_z() {
		return sen_mag_z;
	}

	public void setSen_mag_z(double sen_mag_z) {
		this.sen_mag_z = sen_mag_z;
	}

	public double getSen_proximity() {
		return sen_proximity;
	}

	public void setSen_proximity(double sen_proximity) {
		this.sen_proximity = sen_proximity;
	}

	public double getSen_rov_scalar() {
		return sen_rov_scalar;
	}

	public void setSen_rov_scalar(double sen_rov_scalar) {
		this.sen_rov_scalar = sen_rov_scalar;
	}

	public double getSen_rov_x() {
		return sen_rov_x;
	}

	public void setSen_rov_x(double sen_rov_x) {
		this.sen_rov_x = sen_rov_x;
	}

	public double getSen_rov_y() {
		return sen_rov_y;
	}

	public void setSen_rov_y(double sen_rov_y) {
		this.sen_rov_y = sen_rov_y;
	}

	public double getSen_rov_z() {
		return sen_rov_z;
	}

	public void setSen_rov_z(double sen_rov_z) {
		this.sen_rov_z = sen_rov_z;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}




}