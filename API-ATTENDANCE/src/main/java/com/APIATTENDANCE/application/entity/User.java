package com.APIATTENDANCE.application.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler","authorities","roles" })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private Integer us_id;

	@Column(name = "us_avatar")
	private String us_avatar;

	@Column(name = "us_created", insertable = false, updatable = false)
	private Timestamp us_created;

	@Column(name = "us_email", unique = true)
	private String us_email;

	@Column(name = "us_facebook_url")
	private String us_facebook_url;

	@Column(name = "us_firstname")
	private String us_firstname;

	@Column(name = "us_lastname")
	private String us_lastname;

	@Column(name = "us_male")
	private Boolean us_male;

	@Column(name = "us_password")
	private String us_password;

	@Column(name = "us_phone", unique = true)
	private String us_phone;

	@Column(name = "us_token")
	private Integer us_token;

	@Column(name = "us_username")
	private String us_username;
	
	private String role;

	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties({ "user" })
	@OrderBy("track_position_time ASC")
	private List<Track> track;

	/* GEO */
	@ManyToMany(mappedBy = "user")
	@JsonIgnoreProperties({ "user" })
	private List<Company> company;

	@ManyToMany(mappedBy = "user")
	@JsonIgnoreProperties({ "user" })
	private List<Place> place;

	@ManyToMany(mappedBy = "user")
	@JsonIgnoreProperties({ "user" })
	private List<UserFrequency> userFrequency;

	public User() {
	}

	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	public Integer getUs_id() {
		return us_id;
	}

	public void setUs_id(Integer us_id) {
		this.us_id = us_id;
	}

	public String getUs_avatar() {
		return us_avatar;
	}

	public void setUs_avatar(String us_avatar) {
		this.us_avatar = us_avatar;
	}

	public Timestamp getUs_created() {
		return us_created;
	}

	public void setUs_created(Timestamp us_created) {
		this.us_created = us_created;
	}

	public String getUs_email() {
		return us_email;
	}

	public void setUs_email(String us_email) {
		this.us_email = us_email;
	}

	public String getUs_facebook_url() {
		return us_facebook_url;
	}

	public void setUs_facebook_url(String us_facebook_url) {
		this.us_facebook_url = us_facebook_url;
	}

	public String getUs_firstname() {
		return us_firstname;
	}

	public void setUs_firstname(String us_firstname) {
		this.us_firstname = us_firstname;
	}

	public String getUs_lastname() {
		return us_lastname;
	}

	public void setUs_lastname(String us_lastname) {
		this.us_lastname = us_lastname;
	}

	public Boolean getUs_male() {
		return us_male;
	}

	public void setUs_male(Boolean us_male) {
		this.us_male = us_male;
	}

	public String getUs_password() {
		return us_password;
	}

	public void setUs_password(String us_password) {
		this.us_password = us_password;
	}

	public String getUs_phone() {
		return us_phone;
	}

	public void setUs_phone(String us_phone) {
		this.us_phone = us_phone;
	}

	public Integer getUs_token() {
		return us_token;
	}

	public void setUs_token(Integer us_token) {
		this.us_token = us_token;
	}

	public String getUs_username() {
		return us_username;
	}

	public void setUs_username(String us_username) {
		this.us_username = us_username;
	}

	public List<Track> getTrack() {
		return track;
	}

	public void setTrack(List<Track> track) {
		this.track = track;
	}

	public List<Company> getCompany() {
		return company;
	}

	public void setCompany(List<Company> company) {
		this.company = company;
	}

	public List<Place> getPlace() {
		return place;
	}

	public void setPlace(List<Place> place) {
		this.place = place;
	}

	public List<UserFrequency> getUserFrequency() {
		return userFrequency;
	}

	public void setUserFrequency(List<UserFrequency> userFrequency) {
		this.userFrequency = userFrequency;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}