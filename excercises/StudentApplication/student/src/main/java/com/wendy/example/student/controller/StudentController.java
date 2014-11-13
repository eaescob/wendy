package com.wendy.example.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wendy.example.student.dao.*;
import com.wendy.example.student.dao.impl.*;
import com.wendy.example.student.model.*;

@Controller
public class StudentController {
	private static final String FORM_VIEW_KEY = "/students/student";
	private static final String LIST_VIEW_KEY = "/students/list";
	private static final String SEARCH_VIEW_KEY = "/students/search";
	private static final String GRADE_VIEW_KEY = "/students/grade";
	
    private static final String REDIRECT_LIST_VIEW_KEY = 
            "redirect:" + LIST_VIEW_KEY + ".do";
    
    private static final String FORM_MODEL_KEY = "student";
    private static final String LIST_MODEL_KEY = "students";
    private static final String SEARCH_MODEL_KEY = "search";
   // private static final String GRADE_MODEL_KEY = "grade";
    
    private static StudentDao studentDao = new StudentDaoImpl();
    
    /*
     * Show student list page
     */
    @RequestMapping(value = "/students/list.do", method = RequestMethod.GET)
    public ModelMap list() {
    	ModelMap model = new ModelMap(LIST_MODEL_KEY);
    	model.addAttribute("students", studentDao.getAll());
    	return model;
    }
    
    @RequestMapping(value = "/students/addStudent.do", method = RequestMethod.GET)
    public ModelAndView create() {
    	return new ModelAndView(FORM_VIEW_KEY, FORM_MODEL_KEY, new Student());
    }
    
    @RequestMapping(value = "/students/addStudent.do", method = RequestMethod.POST)
    public ModelAndView addStudent(Student student) {
    	
    	if (studentDao.findBySsn(student.getSsn()) != null) 
    		studentDao.update(student.getSsn(), student);
    	else
    		studentDao.merge(student);
    	return new ModelAndView(REDIRECT_LIST_VIEW_KEY, list());
    }
    
    @RequestMapping(value = "/students/deleteStudent.do", method = RequestMethod.GET)
    public ModelAndView deleteStudent(@RequestParam("ssn") String ssn) {
    	Student student = studentDao.findBySsn(ssn);
    	
    	if (student != null)
    		studentDao.remove(student);
    	
    	return new ModelAndView(REDIRECT_LIST_VIEW_KEY, list());
    }
    
    @RequestMapping(value = "/students/showStudent.do", method = RequestMethod.GET)
    public ModelAndView showStudent(@RequestParam("ssn") String ssn) {
    	Student student = studentDao.findBySsn(ssn);
    	return new ModelAndView(FORM_VIEW_KEY, FORM_MODEL_KEY, student);
    }
    
    @RequestMapping(value = "/students/search.do", method = RequestMethod.GET)
    public String search(Model model) {
    	model.addAttribute(SEARCH_MODEL_KEY, new Search());
    	return SEARCH_VIEW_KEY;
    }
    
    @RequestMapping(value = "/students/search.do", method = RequestMethod.POST)
    public ModelAndView search(@ModelAttribute("search") Search searchForm)  {
    	Student student = studentDao.findStudent(searchForm.getSearchString());
    	
    	if (student == null) {
    		return new ModelAndView(SEARCH_VIEW_KEY, SEARCH_MODEL_KEY, new Search());
    	}
    	
    	return new ModelAndView(FORM_VIEW_KEY, FORM_MODEL_KEY, student);
    }
    
    @RequestMapping(value = "/students/addGrade.do", method = RequestMethod.GET)
    public ModelAndView showAddGrade(@RequestParam("ssn") String ssn,
    		@RequestParam("return") String returnUrl) {
    	Student student = studentDao.findBySsn(ssn);
    	
    	ModelAndView model = new ModelAndView(GRADE_VIEW_KEY);
    	model.addObject("student", student);
    	model.addObject("returnUrl", returnUrl);
    	return model;
    }
    
    @RequestMapping(value = "/students/addGrade.do", method = RequestMethod.POST)
    public ModelAndView addGrade(@RequestParam("ssn") String ssn, 
    		@RequestParam("returnUrl") String returnUrl,
    		@RequestParam("score") String score) {
    	Student student = studentDao.findBySsn(ssn);
    	if (student != null) {
    		String[] scores = score.split(",");
    		
    		for (String s : scores) {
    			student.addScore(Integer.valueOf(s));
    		}
    	}
    	
    	if (returnUrl.contains("list")) {
    		return new ModelAndView(REDIRECT_LIST_VIEW_KEY, list());
    	}
    	
    	return  new ModelAndView(FORM_VIEW_KEY, FORM_MODEL_KEY, student);
    	
    }
    
    

}
