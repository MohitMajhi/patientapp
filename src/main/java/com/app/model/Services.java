package com.app.model;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;

@Entity
public class Services {
	@Id
	private long id; 
	private String service_name;  
	private float fees;
	private int patientId;
	
	public Services() {
		super();
	}
	
	
	public Services(long id, String service_name, float fees ,int patientId) {
		super();
		this.id = id;
		this.service_name = service_name;
		this.fees = fees;
		this.patientId=patientId;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	
}
