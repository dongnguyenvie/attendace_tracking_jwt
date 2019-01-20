package com.APIATTENDANCE.application.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the companies database table.
 * 
 */
@Entity
@Table(name="companies")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="com_id")
	private Integer com_id;
	
	@Column(name="com_address")
	private String com_address;

	@Temporal(TemporalType.DATE)
	@Column(name="com_created", insertable=false, updatable= false)
	private Date com_created;

	@Column(name="com_description")
	private String com_description;

	@Column(name="com_email")
	private String com_email;

	@Column(name="com_facebook_url")
	private String com_facebook_url;

	@Column(name="com_fax")
	private String com_fax;

	@Column(name="com_hotline")
	private String com_hotline;

	@Column(name="com_logo")
	private String com_logo;

	@Column(name="com_name")
	private String com_name;

	@Column(name="com_phone")
	private String com_phone;

	@Column(name="com_province")
	private Integer com_province;

	@Column(name="com_recruitment_info")
	private String com_recruitment_info;

	@Column(name="com_website")
	private String com_website;

	/*  GEO */
	@ManyToMany(fetch= FetchType.LAZY)
	@JoinTable(name="user_relation", joinColumns = @JoinColumn(name="company_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	@JsonIgnoreProperties({"company","userFrequency","place"})
	private List<User> user;
	
	@ManyToMany
	@JoinTable(name="user_relation", joinColumns = @JoinColumn(name="company_id"), inverseJoinColumns = @JoinColumn(name = "frequency_id"))
	@JsonIgnoreProperties({"company","user","place"})
	private List<UserFrequency> userFrequency;
	
	@ManyToMany(mappedBy="company")
	@JsonIgnoreProperties({"company","user","userFrequency"})
	private List<Place> place;
	
	public Company() {
	}

	public Integer getCom_id() {
		return com_id;
	}

	public void setCom_id(Integer com_id) {
		this.com_id = com_id;
	}

	public String getCom_address() {
		return com_address;
	}

	public void setCom_address(String com_address) {
		this.com_address = com_address;
	}

	public Date getCom_created() {
		return com_created;
	}

	public void setCom_created(Date com_created) {
		this.com_created = com_created;
	}

	public String getCom_description() {
		return com_description;
	}

	public void setCom_description(String com_description) {
		this.com_description = com_description;
	}

	public String getCom_email() {
		return com_email;
	}

	public void setCom_email(String com_email) {
		this.com_email = com_email;
	}

	public String getCom_facebook_url() {
		return com_facebook_url;
	}

	public void setCom_facebook_url(String com_facebook_url) {
		this.com_facebook_url = com_facebook_url;
	}

	public String getCom_fax() {
		return com_fax;
	}

	public void setCom_fax(String com_fax) {
		this.com_fax = com_fax;
	}

	public String getCom_hotline() {
		return com_hotline;
	}

	public void setCom_hotline(String com_hotline) {
		this.com_hotline = com_hotline;
	}

	public String getCom_logo() {
		return com_logo;
	}

	public void setCom_logo(String com_logo) {
		this.com_logo = com_logo;
	}

	public String getCom_name() {
		return com_name;
	}

	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}

	public String getCom_phone() {
		return com_phone;
	}

	public void setCom_phone(String com_phone) {
		this.com_phone = com_phone;
	}

	public Integer getCom_province() {
		return com_province;
	}

	public void setCom_province(Integer com_province) {
		this.com_province = com_province;
	}

	public String getCom_recruitment_info() {
		return com_recruitment_info;
	}

	public void setCom_recruitment_info(String com_recruitment_info) {
		this.com_recruitment_info = com_recruitment_info;
	}

	public String getCom_website() {
		return com_website;
	}

	public void setCom_website(String com_website) {
		this.com_website = com_website;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<UserFrequency> getUserFrequency() {
		return userFrequency;
	}

	public void setUserFrequency(List<UserFrequency> userFrequency) {
		this.userFrequency = userFrequency;
	}

	public List<Place> getPlace() {
		return place;
	}

	public void setPlace(List<Place> place) {
		this.place = place;
	}



}