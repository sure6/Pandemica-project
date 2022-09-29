package com.csci927.pandemicavaccine.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vaccine")
public class VaccineDetails {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long userId;
	@Column(name = "vaccine_name", nullable = false)
	private String vaccineName;
	@Column(name="date")
	private String date;
	@Column(name="time")
	private String time;
	@Column(name="location")
	private String location;
	@Column(name="status")
	private String status;
	
	public VaccineDetails() {
		
	}
	
	
	public VaccineDetails(String vaccineName, String date, String time, String location, String status) {
		super();
		this.vaccineName = vaccineName;
		this.date = date;
		this.time = time;
		this.location = location;
		this.status = status;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
