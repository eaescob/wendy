package com.wendy.example.student.dao.impl;

import com.wendy.example.student.dao.StudentDao;
import com.wendy.example.student.model.Student;
import com.wendy.example.student.view.StudentView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {
	private static final Map<String, Student> STUDENT_HASH = new HashMap<String, Student>();
	
	static {
		Student student = new Student();
		student.setFirstName("Wendy");
		student.setLastName("Lo");
		student.setAddress1("573 Bonita Ave.");
		student.setState("CA");
		student.setCity("San Marino");
		student.setCountry("US");
		student.setSsn("123-56-7890");
		student.setDepartment("Engineering");
		student.setDegree("Computer Science");
		student.addScore(98);
		student.addScore(86);
		student.addScore(78);
		student.addScore(99);
		student.addScore(92);
		addStudent(student);
	}
	
	public static void addStudent(Student student) {
		STUDENT_HASH.put(student.getSsn(), student);
	}
	
	public static void removeStudent(Student student) {
		STUDENT_HASH.remove(student.getSsn());
	}
	
	public Collection<Student> getAll() {
		return STUDENT_HASH.values();
	}
	
	public void merge(Student student) {
		if (STUDENT_HASH.get(student.getSsn()) != null) {
			//Student already exists
			return;
		}
		
		addStudent(student);
	}
	
	public void update(String ssn, Student data) {
		Student student = STUDENT_HASH.get(ssn);
		
		if (student == null)
			return;
		
		student.copy(data);
		STUDENT_HASH.put(ssn, student);
	}
	
	public Student findBySsn(String ssn) {
		return STUDENT_HASH.get(ssn);
	}
	
	public void remove(Student student) {
		Student s = findBySsn(student.getSsn());
		if (s != null) {
			removeStudent(s);
		}
	}
	
	public Student findStudent(String searchString) {
		Collection<Student> students = getAll();
		
		for(Student student : students) {
			if (student.getFirstName().contains(searchString)) {
				return student;
			} else if (student.getLastName().contains(searchString)) {
				return student;
			} else if (student.getSsn().contains(searchString)) {
				return student;
			}
		}
		
		return null;
	}
	
	public Iterable<StudentView> getAllView() {
		ArrayList<StudentView> allStudents = new ArrayList<StudentView>();
		
		for(Student student : getAll()) {
			allStudents.add(new StudentView(student));
		}
		
		return allStudents;
	}
	
	
}
