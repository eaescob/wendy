package com.wendy.example.student.view;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wendy.example.student.dao.*;
import com.wendy.example.student.dao.impl.*;
import com.wendy.example.student.model.*;

@RestController
public class StudentAPIController {
	private final StudentDao studentDao = new StudentDaoImpl();
	
	@RequestMapping( value = "/api/list.do", method = RequestMethod.GET)
	public StudentList list() {
		return new StudentList(studentDao.getAll());
	}
	

}
