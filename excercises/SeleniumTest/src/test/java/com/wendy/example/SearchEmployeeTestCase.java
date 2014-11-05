package com.wendy.example;


import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.wendy.example.employee.dao.*;
import com.wendy.example.employee.dao.impl.*;
import com.wendy.example.employee.model.*;

import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SearchEmployeeTestCase {
	
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	@Parameters
	public static Collection<Object[]> data()  {
		return Arrays.asList(new Object[][] {
				{ "Wendy", "Wendy"}, {"50000", "50000"}, {"Foo", null}
				
		});
	}
	
	
	@Parameter(0)
	public String searchString;
	
	@Parameter(1)
	public String expectedValue;
	
	@Test
	public void testSearchEmployee() throws Exception {
		Employee e = employeeDao.findEmployee(searchString);
		
		if (expectedValue != null)
			assertTrue(e.equals(expectedValue));
		else
			assertNull(e);
	}
}
