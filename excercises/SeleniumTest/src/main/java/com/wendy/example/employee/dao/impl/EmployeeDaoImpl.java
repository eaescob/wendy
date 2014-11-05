package com.wendy.example.employee.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.wendy.example.employee.dao.EmployeeDao;
import com.wendy.example.employee.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private static Long nextId = 1L;
	private static final List<Employee> EMPLOYEE_LIST = new ArrayList<Employee>();
	private static final Map<Long, Employee> EMPLOYEE_HASH = new HashMap<Long, Employee>();
	
	
	private static final Logger LOG = Logger.getLogger(EmployeeDao.class);
	
	
	static {
		Employee e = new Employee(nextId++, "Emilio", "Escobar", 50000.00);
		Employee e2 = new Employee(nextId++, "Wendy", "Lo", 60000.00);
		addEmployee(e);
		addEmployee(e2);
	}
	
	public static void addEmployee(Employee e) {
		EMPLOYEE_LIST.add(e);
		EMPLOYEE_HASH.put(e.getId(), e);
		LOG.info("Added new employee: " + e.getFirstName());
	}
	
	public static void removeEmployee(Employee e){
		boolean removed = EMPLOYEE_LIST.remove(e);
		LOG.info("Employee found in list? " + removed);
		EMPLOYEE_HASH.remove(e.getId());
	}
	
	public List<Employee> findAll() {
		return EMPLOYEE_LIST;
	}
	
	public void merge(Employee e) {
		
		for(Employee existing : EMPLOYEE_LIST) {
			if (e.equals(existing))
				return;
		}
		
		if (e.getId() == null) {
			e.setId(nextId++);
			addEmployee(e);
		} else {
			Employee existing = EMPLOYEE_HASH.get(e.getId());
			existing.setFirstName(e.getFirstName());
			existing.setLastName(e.getLastName());
			existing.setSalary(e.getSalary());
		}
	}
	
	public Employee findById(Long id) {
		return EMPLOYEE_HASH.get(id);
	}
	
	public void remove(Employee e) {
		Employee persisted = findById(e.getId());
		if (persisted != null)
			removeEmployee(persisted);
	}
	
	public Employee findEmployee(String searchString) {
		for(Employee e: EMPLOYEE_LIST) {
			if (e.getFirstName().contains(searchString) ||
					e.getLastName().contains(searchString) ||
					e.getFormattedSalary().contains(searchString)) {
				return e;
			}		
		}
		
		return null;
	}
	
	
	

}
