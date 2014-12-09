package com.wendy.example.student;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;

import com.wendy.example.student.dao.*;
import com.wendy.example.student.dao.impl.*;
import com.wendy.example.student.model.*;



public class Stepdefs {
	private static final StudentDao studentDao = new StudentDaoImpl();
	private Student student;
	
	@Given("^I have a student to add")
	public void add_new_student() {
		student = new Student();
	}
	
	@When("^I add the following data for new student:$")
	public void add_new_student_data(List<TempStudent> list) {
		
		TempStudent data = list.get(0);
		student.setFirstName(data.firstname);
		student.setLastName(data.lastname);
		student.setSsn(data.ssn);
		student.setAddress1(data.addr1);
		student.setState(data.state);
		student.setCountry(data.country);
		student.setDepartment(data.department);
		student.setDegree(data.degree);
		
		studentDao.merge(student);
	}
	
	@Then("^Student \"([^\"]*)\" is added to database$")
	public void check_added_to_db(String firstName) {
		Student s = studentDao.findStudent(firstName);
		
		assertEquals(firstName, s.getFirstName());
	}
	
	
	public class TempStudent {
		public String firstname;
		public String lastname;
		public String ssn;
		public String addr1;
		public String state;
		public String country;
		public String department;
		public String degree;
	}
	
}
