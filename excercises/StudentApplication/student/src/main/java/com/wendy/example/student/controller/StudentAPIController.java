package com.wendy.example.student.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wendy.example.student.dao.*;
import com.wendy.example.student.dao.impl.*;
import com.wendy.example.student.model.*;
import com.wendy.example.student.view.*;

@RestController
public class StudentAPIController {
	
	private static final StudentDao studentDao = new StudentDaoImpl();
	private final StudentViewAssembler assembler = new StudentViewAssembler();
	
	@RequestMapping( value = "/api/students.json", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<StudentView>> list() {
		Iterable<StudentView> students = studentDao.getAllView();
		return new ResponseEntity<Iterable<StudentView>>(students, HttpStatus.OK);
	}
	
	
	@RequestMapping( value = "/api/students.json", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentView> post(@RequestBody StudentView params, HttpServletRequest request) {
		if (studentDao.findBySsn(params.getSsn()) != null)
			return new ResponseEntity(null, HttpStatus.NOT_MODIFIED);
		
		Student student = assembler.fromResource(params);
		studentDao.merge(student);
		
		return new ResponseEntity<StudentView>(new StudentView(student), HttpStatus.CREATED);
	}
	
	@RequestMapping( value = "/api/students/{ssn}.json", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentView> show(@PathVariable String ssn) {
		Student student = studentDao.findBySsn(ssn);
		
		if (student == null) {
			return new ResponseEntity<StudentView>(HttpStatus.NOT_FOUND);
		}
		
		StudentView view = new StudentView(student);
		
		return new ResponseEntity<StudentView>(view, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/api/students/{ssn}.json",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentView> put(@PathVariable String ssn, @RequestBody StudentView params, HttpServletRequest request) {
		Student student = studentDao.findBySsn(ssn);
		
		if (student == null) {
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}
		
		student = assembler.fromResource(params);
		studentDao.update(ssn, assembler.fromResource(params));
		return new ResponseEntity(null, HttpStatus.NO_CONTENT);	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/api/students/{ssn}.json",
			method = RequestMethod.DELETE)
	public ResponseEntity<StudentView> delete(@PathVariable String ssn) {
		Student student = studentDao.findBySsn(ssn);
		if (student == null) 
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		
		studentDao.remove(student);
		return new ResponseEntity(null, HttpStatus.ACCEPTED);
	}
	

}
