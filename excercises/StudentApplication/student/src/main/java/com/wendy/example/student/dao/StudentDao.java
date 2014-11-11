package com.wendy.example.student.dao;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.wendy.example.student.model.Student;
import com.wendy.example.student.view.StudentView;

@Component
public interface StudentDao {
	Student findBySsn(String ssn);
	Collection<Student> getAll();
	void merge(Student student);
	void remove(Student student);
	void update(String ssn, Student data);
	Student findStudent(String searchString);
	Iterable<StudentView> getAllView();

}
