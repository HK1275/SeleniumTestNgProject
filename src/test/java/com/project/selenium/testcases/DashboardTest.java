package com.project.selenium.testcases;

import com.project.selenium.base.TestBase;
import com.project.selenium.pages.HomePage;
import com.project.selenium.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;
public class DashboardTest extends TestBase {

	HomePage homepage;
	LoginPage loginPage;

	public DashboardTest() {
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
	}
	@Description("Verify home page loaded after login")
	@Story( "Home page and widgets")
	@Severity(SeverityLevel.CRITICAL)
	@Test(groups = { "HappyPath", "Navigation" })
	public void TC001_CheckIfLogoIsPresent() {
		homepage.waitForPageLoad();
		boolean flag = homepage.isLogoDisplayed();
		Assert.assertTrue(flag);
	}

	@Description("Verify home page loaded and correct widget loaded")
	@Story( "Home page and widgets")
	@Severity(SeverityLevel.CRITICAL)
	@Test(groups = { "HappyPath", "Navigation" })
	public void TC002_IsCorrectDashboard() {
		Assert.assertTrue(homepage.getProjectTitle().equalsIgnoreCase("Test Project"));
	}


	@AfterTest(alwaysRun = true)
	public void tearDown() {
		tearDownMain();
	}

}
