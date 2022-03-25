package com.project.selenium.testcases;

import com.project.selenium.base.TestBase;
import com.project.selenium.pages.DataInputWidgetPage;
import com.project.selenium.pages.HomePage;
import com.project.selenium.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;

public class WidgetsTest extends TestBase {

	HomePage homepage;
	LoginPage loginPage;
	DataInputWidgetPage dataInputWidgetPage;

	public WidgetsTest() {
		super();
	}

	/*
	 * @BeforeTest
	 */

	@BeforeTest(alwaysRun = true)
	public void setUp() throws InterruptedException {
		initializaton();
		loginPage = new LoginPage(driver);
		loginPage.login();
		homepage = new HomePage(driver);
		homepage.waitForPageLoad();
		dataInputWidgetPage = new DataInputWidgetPage(driver);
		dataInputWidgetPage.waitForPageLoad();
	}

	@Description("Add value to Material Model under tab - Singular ")
	@Story( "Widget tests")
	@Severity(SeverityLevel.CRITICAL)
	@Test(groups = { "Functional" })
	public void TC101_AddSingularMaterialModel() {
		dataInputWidgetPage.submitValueForSingular(1,"15");
		String addedValue= dataInputWidgetPage.getLatestValueFromSingularTab(1);
		String alertText = dataInputWidgetPage.getSuccessMessageText();

		Assert.assertTrue( alertText.equalsIgnoreCase("Successfully added a new data entry"));
		// verify new value reflected
		Assert.assertTrue(addedValue.equalsIgnoreCase("15"));
	}

	@Description("Cancel submit on submit form to Material Model under tab - Singular ")
	@Story( "Widget tests")
	@Severity(SeverityLevel.CRITICAL)
	@Test(groups = { "Functional" })
	public void TC102_AddSingularMaterialModel_CancelSubmit() {
		// get current value
		String existingValue = dataInputWidgetPage.getLatestValueFromSingularTab(1);
		// Add values to form and click cancel submit
		dataInputWidgetPage.submitValueForSingularAndCancelSubmit(1,"1945");
		String newValue = dataInputWidgetPage.getLatestValueFromSingularTab(1);
		// verify value not changed, cancel submit works
		Assert.assertTrue(existingValue.equalsIgnoreCase(newValue));
	}

	@Description("Add empty value submit to Material Model under tab - Singular ")
	@Story( "Widget tests")
	@Severity(SeverityLevel.CRITICAL)
	@Test(groups = { "Negative", "fieldValidation" })
	public void TC103_AddSingularMaterialModel_emptyValue() {
		dataInputWidgetPage.submitValueForSingular(1,"");
		String alertText = dataInputWidgetPage.getFieldValidationMessageText();

		Assert.assertTrue( alertText.equalsIgnoreCase("Failed to add a new data entry"));
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		tearDownMain();
	}

}
