package com.wendy.example.student.dao;

import java.util.Collection;

import com.wendy.example.student.model.Student;

public interface StudentDao {
	Student findBySsn(String ssn);
	Collection<Student> getAll();
	void merge(Student student);
	void remove(Student student);
	Student findStudent(String searchString);

}
