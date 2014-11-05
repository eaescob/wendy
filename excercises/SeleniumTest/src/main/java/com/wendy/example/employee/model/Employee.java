package com.wendy.example.employee.model;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private double salary;
	private String formattedSalary;
	private String firstName;
	private String lastName;
	private Long id;
	
	public Employee() {}
	
	public Employee(Long id, String firstName, String lastName, double salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		
		if (salary > 0) {
			this.salary = salary;
			this.formattedSalary = String.format("%02.2f", salary);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}
	
	public String getFormattedSalary() {
		return formattedSalary;
	}

	public void setSalary(double salary) {
		if (salary > 0) {
			this.salary = salary;
			this.formattedSalary = String.format("%02.2f", salary);
		}
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
	
	@Override
	public int  hashCode() {
		int prime = 17;
		int result = 1;
		result = prime * (firstName != null ? firstName.hashCode() : 0) + (lastName != null ? lastName.hashCode() : 0) + (int)salary;
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) 
			return true;
		
		if (o == null)
			return false;
		
		if (o instanceof Employee) {
			Employee e = (Employee) o;
			
			if (getId() == e.getId()) 
				return true;
			
			if (getFirstName().equals(e.getFirstName()) &&
					getLastName().equals(e.getLastName()) &&
					getSalary() == e.getSalary())
				return true;
		} else if (o instanceof String) {
			String s = (String)o;
			if (getFirstName().contains(s) ||
					getLastName().contains(s) ||
					getFormattedSalary().contains(s))
				return true;
		}
		return false;
		
	}
	
}
