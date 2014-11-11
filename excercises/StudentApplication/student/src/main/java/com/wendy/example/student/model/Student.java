package com.wendy.example.student.model;

import com.wendy.example.StudentAverage;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
	private static final long serialVersionUID = 123456789L;
	
	private String firstName;
	private String lastName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	
	private String ssn;
	
	private String department;
	private String degree;
	private StudentAverage studentAverage;
	
	public Student() {
		this(null, null);
	}
	
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentAverage = new StudentAverage();	
	}
	


	public List<Integer> getScores() {
		return studentAverage.getGrades();
	}
	
	public String getGpa() {
		return studentAverage.getAverage();
	}
	
	public void addScore(int score) {
		studentAverage.addGrade(score);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result
				+ ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	public void copy(Student data) {
		if (data.getFirstName() != null) setFirstName(data.getFirstName());
		if (data.getLastName() !=  null) setLastName(data.getLastName());
		if (data.getAddress1() != null) setAddress1(data.getAddress1());
		if (data.getAddress2() != null) setAddress2(data.getAddress2());
		if (data.getCity() != null) setCity(data.getCity());
		if (data.getState() != null) setState(data.getState());
		if (data.getCountry() != null) setCountry(data.getCountry());
		if (data.getDepartment() != null) setDepartment(data.getDepartment());
		if (data.getDegree() != null) setDegree(data.getDegree());
		
		if (data.getScores() != null) {
			for (int score : data.getScores()) {
				addScore(score);
			}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (degree == null) {
			if (other.degree != null)
				return false;
		} else if (!degree.equals(other.degree))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		
		if (studentAverage == null) {
			if (other.studentAverage != null)
				return false;
		} else if (!getGpa().equals(other.getGpa()))
			return false;
		
		return true;
	}
}
