package com.APIATTENDANCE.application.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the user_frequency database table.
 * 
 */
@Entity
@Table(name="user_frequency")
@NamedQuery(name="UserFrequency.findAll", query="SELECT u FROM UserFrequency u")
public class UserFrequency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="us_freq_id")
	private Integer us_freq_id;

	@Column(name="us_freq_active")
	private Boolean us_freq_active;

	@Column(name="us_freq_day_of_week")
	private String us_freq_day_of_week;

	@Column(name="us_freq_end")
	private Time us_freq_end;

	@Column(name="us_freq_start")
	private Time us_freq_start;
	/*Geo */
	@ManyToMany
	@JoinTable(name="user_relation", joinColumns = @JoinColumn(name="frequency_id"),inverseJoinColumns = @JoinColumn(name = "user_id"))
	@JsonIgnoreProperties({"place","company","userFrequency"})
	private List<User> user;

	@ManyToMany(mappedBy="company")
	@JsonIgnoreProperties({"user","company","userFrequency"})
	private List<Place> place;
	
	@ManyToMany(mappedBy="user")
	@JsonIgnoreProperties({"user","place","userFrequency"})
	private List<Company> company;
	
	public UserFrequency() {
	}

	public Integer getUs_freq_id() {
		return us_freq_id;
	}

	public void setUs_freq_id(Integer us_freq_id) {
		this.us_freq_id = us_freq_id;
	}

	public Boolean getUs_freq_active() {
		return us_freq_active;
	}

	public void setUs_freq_active(Boolean us_freq_active) {
		this.us_freq_active = us_freq_active;
	}

	public String getUs_freq_day_of_week() {
		return us_freq_day_of_week;
	}

	public void setUs_freq_day_of_week(String us_freq_day_of_week) {
		this.us_freq_day_of_week = us_freq_day_of_week;
	}

	public Time getUs_freq_end() {
		return us_freq_end;
	}

	public void setUs_freq_end(Time us_freq_end) {
		this.us_freq_end = us_freq_end;
	}

	public Time getUs_freq_start() {
		return us_freq_start;
	}

	public void setUs_freq_start(Time us_freq_start) {
		this.us_freq_start = us_freq_start;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Place> getPlace() {
		return place;
	}

	public void setPlace(List<Place> place) {
		this.place = place;
	}

	public List<Company> getCompany() {
		return company;
	}

	public void setCompany(List<Company> company) {
		this.company = company;
	}


}