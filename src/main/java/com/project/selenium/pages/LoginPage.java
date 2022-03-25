package com.project.selenium.pages;

import com.project.selenium.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "emailAddress")
    WebElement loginEmailAddress;

    @FindBy(id = "password")
    WebElement loginPassword;

    @FindBy(css = "span.MuiButton-label")
    WebElement loginSubmit;

    public void setUserName(String userName) {
        loginEmailAddress.sendKeys(userName);
    }

    public void setPassword(String password) {
        loginPassword.sendKeys(password);
    }

    public void clickSubmit() {
        loginSubmit.click();
    }

    public void login() {
        login(properties.getProperty("userName"), properties.getProperty("password"));
    }

    public void login(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        clickSubmit();
    }

}
