package com.wendy.example;

public class DeleteEmployeeTestCase extends SeleniumTestCase {
	public void testDeleteEmployee() {
		selenium.open("/SeleniumExample/employees/list.do");
		selenium.click("id=delete3");
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("Robert"));
	}

}
