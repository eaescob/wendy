package com.wendy.example;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static org.junit.Assert.assertEquals;

public class Stepdefs {
	private StudentAverage studentAverage;
	
	
	@Given("^I have a student with a bunch of grades$")
	public void i_have_a_student() {
		studentAverage = new StudentAverage();
	}
	
	@When("I add score (.+)$")
	public void add_score(String scoreString) {
		String[] scores = scoreString.split(",");
		for(String score: scores) {
			studentAverage.addGrade(Integer.valueOf(score));
		}
	}
	
	@Then("^the average score is (.+)$")
	public void get_average(String expected) {
		assertEquals(expected, studentAverage.getAverage());
	}
	
	@Then("^the minimum score is (\\d+)$")
	public void get_minimum(int expected) {
		assertEquals(expected, studentAverage.getMinimum());
	}
	
	
}
