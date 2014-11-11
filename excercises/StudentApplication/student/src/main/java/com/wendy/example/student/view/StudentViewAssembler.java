package com.wendy.example.student.view;

import com.wendy.example.student.model.Student;

public class StudentViewAssembler {

	public StudentViewAssembler() {
		
	}
	
	public StudentView toResource(Student student) {
		return new StudentView(student);
	}
	
	public Student fromResource(StudentView view) {
		Student student = new Student();
		student.setSsn(view.getSsn());
		student.setFirstName(view.getFirstName());
		student.setLastName(view.getLastName());
		student.setAddress1(view.getAddress1());
		student.setAddress2(view.getAddress2());
		student.setCity(view.getCity());
		student.setState(view.getState());
		student.setDepartment(view.getDepartment());
		student.setDegree(view.getDegree());
		
		if (view.getScores() != null) {
			for(int score : view.getScores()) {
				student.addScore(score);
			}
		}
		
		return student;
	}
}
