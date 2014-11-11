package com.wendy.example;

import java.util.*;

public class StudentAverage {
	private List<Integer> grades;
	
	public StudentAverage() {
		this.grades = new ArrayList<Integer>();
	}
	
	public void addGrade(int score) {
		grades.add(score);
	}
	
	public List<Integer> getGrades() {
		return grades;
	}
	
	public String getAverage() {
		double average =  grades.size() > 0 ? getSum()/grades.size() : 0;
		return String.format("%.2f", average);
	}
	
	private int getSum() {
		int sum = 0;
		for (int grade : grades) {
			sum += grade;
		}
		
		return sum;
	}
	
	public int getMinimum() {
		int smallest = grades.get(0);
		for( int x = 1; x< grades.size(); x++) {
			if (grades.get(x) < smallest) {
				smallest = grades.get(x);
			}
		}
		
		return smallest;
	}
}
