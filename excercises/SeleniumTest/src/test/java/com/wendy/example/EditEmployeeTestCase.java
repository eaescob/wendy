package com.wendy.example;

public class EditEmployeeTestCase extends SeleniumTestCase {
	public void testEditEmployee() {
        selenium.open("/SeleniumExample/employees/list.do");
        selenium.waitForPageToLoad("30000");
        selenium.click("id=edit1");
        selenium.waitForPageToLoad("30000");
        selenium.type("id=salary", "60000");
        selenium.click("id=btnSave");
        selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("60000.00"));
	}
}
