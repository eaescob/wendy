package com.wendy.example.student.view;

import java.util.List;

import com.fasterxml.jackson.annotation.*;
import com.wendy.example.student.model.*;

public class StudentView {
	private String ssn;
	
	@JsonProperty(value = "firstname")
	private String firstName;
	
	@JsonProperty("lastname")
	private String lastName;
	
	@JsonProperty("address1")
	private String address1;
	
	@JsonProperty("address2")
	private String address2;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("department")
	private String department;
	
	@JsonProperty("degree")
	private String degree;
	
	@JsonProperty("gpa")
	private String gpa;
	
	@JsonProperty("scores")
	private List<Integer> scores;
	
	public StudentView() {
		
	}
	
	public StudentView(Student student) {
		setSsn(student.getSsn());
		setFirstName(student.getFirstName());
		setLastName(student.getLastName());
		setAddress1(student.getAddress1());
		setAddress2(student.getAddress2());
		setState(student.getState());
		setCity(student.getCity());
		setCountry(student.getCountry());
		setDepartment(student.getDepartment());
		setDegree(student.getDegree());
		setGpa(student.getGpa());	
		setScores(student.getScores());
		
	}

	public List<Integer> getScores() {
		return scores;
	}

	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}

	@JsonProperty("ssn")
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	@JsonIgnore public String getSsn() {
		return ssn;
	}
	
	@JsonProperty(value = "firstname")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty(value = "firstname")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty(value = "lastname")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty(value = "lastname")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty(value = "address1")
	public String getAddress1() {
		return address1;
	}

	@JsonProperty(value = "address1")
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@JsonProperty(value = "address2")
	public String getAddress2() {
		return address2;
	}

	@JsonProperty(value = "address2")
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	
	
	@Override
	@JsonIgnore
	public String toString() {
		return String.format("SSN: %s Name: %s %s", getSsn(), getFirstName(), getLastName());
	}

}
