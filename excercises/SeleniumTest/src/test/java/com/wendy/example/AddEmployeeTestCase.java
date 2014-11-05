package com.wendy.example;

import org.junit.Test;

public class AddEmployeeTestCase extends SeleniumTestCase {
	@Test
	public void testAddEmployee() throws Exception {
        selenium.open("/SeleniumExample/employees/list.do");
        selenium.click("id=addemployee");
        selenium.waitForPageToLoad("30000");
        selenium.type("id=firstName", "Robert");
        selenium.type("id=lastName", "Beltran");
        selenium.type("id=salary", "20000");
        selenium.click("id=btnSave");
        selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Robert"));
	}

}
