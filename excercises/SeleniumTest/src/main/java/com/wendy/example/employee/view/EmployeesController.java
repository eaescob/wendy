package com.wendy.example.employee.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wendy.example.employee.dao.*;
import com.wendy.example.employee.dao.impl.*;
import com.wendy.example.employee.model.*;

@Controller
public class EmployeesController {
	private final static String FORM_VIEW_KEY = "/employees/employee";
	private final static String LIST_VIEW_KEY = "/employees/list";
	private final static String SEARCH_VIEW_KEY = "/employees/search";
    private static final String REDIRECT_LIST_VIEW_KEY = 
            "redirect:" + LIST_VIEW_KEY + ".do";
    private static final String FORM_MODEL_KEY = "employee";
    private static final String LIST_MODEL_KEY = "employees";
    private static final String SEARCH_MODEL_KEY = "search";
    
    private static EmployeeDao employeeDao = new EmployeeDaoImpl();
    
    /**
     * Show the add employee page
     */
    @RequestMapping(value = "/employees/createEmployee.do", method = RequestMethod.GET)
    public ModelAndView create() {
    	return new ModelAndView(FORM_VIEW_KEY, FORM_MODEL_KEY, new Employee());
    }
    
    @RequestMapping(value = "/employees/showEmployee.do", method = RequestMethod.GET)
    public ModelAndView info(@RequestParam("id") Long id) {
    	Employee e = employeeDao.findById(id);
    	return new ModelAndView(FORM_VIEW_KEY, FORM_MODEL_KEY, e);
    }
    
    @RequestMapping(value = "/employees/addEmployee.do", method = RequestMethod.POST)
    public ModelAndView save(Employee e) {
    	employeeDao.merge(e);
    	return new ModelAndView(REDIRECT_LIST_VIEW_KEY, list());
    }
    
    @RequestMapping(value = "/employees/deleteEmployee.do", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam("id") Long id) {
    	Employee e = new Employee();
    	e.setId(id);
    	employeeDao.remove(e);
    	return new ModelAndView(REDIRECT_LIST_VIEW_KEY, list());
    }
    
	@RequestMapping(value = "/employees/list.do")
    public ModelMap list() {
    	ModelMap model =  new ModelMap(LIST_MODEL_KEY);
    	model.addAttribute("employees", employeeDao.findAll());
    	return model;
    	
    }
	
	@RequestMapping(value = "/employees/search.do", method = RequestMethod.POST)
	public ModelAndView search(@ModelAttribute("search") Search searchForm) {
		Employee e = employeeDao.findEmployee(searchForm.getSearchString());
		
		if (e==null) {
			return new ModelAndView(SEARCH_VIEW_KEY);
		}
		
		return new ModelAndView(FORM_VIEW_KEY, FORM_MODEL_KEY, e);
	}
	
	@RequestMapping(value = "/employees/search.do", method = RequestMethod.GET)
	public String search(Model model) {
		model.addAttribute(SEARCH_MODEL_KEY, new Search());
		return SEARCH_VIEW_KEY;
		
	}
    

}
