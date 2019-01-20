package com.APIATTENDANCE.application.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the places database table.
 * 
 */
@Entity
@Table(name="places")
@NamedQuery(name="Place.findAll", query="SELECT p FROM Place p")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Place implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="place_id")
	private Integer place_id;

	@Column(name="place_address")
	private String place_address;

	@Column(name="place_created", insertable=false)
	private Timestamp place_created;

	@Column(name="place_name")
	private String place_name;
	
	/*  GEO */
	@ManyToMany( cascade= {CascadeType.ALL})
	@JoinTable(name="user_relation", joinColumns = @JoinColumn(name="place_id"),inverseJoinColumns = @JoinColumn(name = "user_id"))
	@JsonIgnoreProperties({"place","company","userFrequency"})
	private List<User> user;
	
	@ManyToMany
	@JoinTable(name="user_relation", joinColumns = @JoinColumn(name="place_id"),inverseJoinColumns = @JoinColumn(name = "company_id"))
	@JsonIgnoreProperties({"place","user","userFrequency"})
	private List<Company> company;
	
	@ManyToMany
	@JsonIgnoreProperties({"place","user","place"})
	@JoinTable(name="user_relation", joinColumns = @JoinColumn(name="place_id"),inverseJoinColumns = @JoinColumn(name = "frequency_id"))
	private List<UserFrequency> userFrequency;
	
	@OneToMany(mappedBy="place")
	private List<Geo> geo;
	
	public Place() {
	}

	public Integer getPlace_id() {
		return place_id;
	}

	public void setPlace_id(Integer place_id) {
		this.place_id = place_id;
	}

	public String getPlace_address() {
		return place_address;
	}

	public void setPlace_address(String place_address) {
		this.place_address = place_address;
	}

	public Timestamp getPlace_created() {
		return place_created;
	}

	public void setPlace_created(Timestamp place_created) {
		this.place_created = place_created;
	}

	public String getPlace_name() {
		return place_name;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Company> getCompany() {
		return company;
	}

	public void setCompany(List<Company> company) {
		this.company = company;
	}

	public List<UserFrequency> getUserFrequency() {
		return userFrequency;
	}

	public void setUserFrequency(List<UserFrequency> userFrequency) {
		this.userFrequency = userFrequency;
	}

	public List<Geo> getGeo() {
		return geo;
	}

	public void setGeo(List<Geo> geo) {
		this.geo = geo;
	}

}