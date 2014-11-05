package com.wendy.example.employee.dao;

import java.util.List;

import com.wendy.example.employee.model.Employee;

public interface EmployeeDao {
	Employee findById(Long id);
	List<Employee> findAll();
	void merge(Employee e);
	void remove(Employee e);
	Employee findEmployee(String searchString);

}
