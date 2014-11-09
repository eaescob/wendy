package com.wendy.example.student.model;

import java.util.Collection;

public class StudentList {
	private Collection<Student> students;
	
	public StudentList(Collection<Student> students) {
		this.students = students;
	}
	
	public Collection<Student> getStudentList() {
		return students;
	}
	
	public void setStudentList(Collection<Student> students) {
		this.students = students;
	}
}
