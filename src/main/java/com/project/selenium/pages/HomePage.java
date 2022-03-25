package com.project.selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static com.project.selenium.utilities.TestUtils.waitForElementToBeVisible;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "companylogo")
    WebElement logo;

    @FindBy(xpath = "//h1[@class='title']")
    WebElement projectTitle;

    @FindBy(tagName = "widget-data-input")
    WebElement dataInputWidget;

    @Step("Check is Log displayed on Home page")
    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }
    @Step("Waiting for page load - Home Page")
    public void waitForPageLoad() {
        if (!dataInputWidget.isEnabled())
            waitForElementToBeVisible(driver, dataInputWidget);
    }

    @Step("Get project Title - Home Page")
    public String getProjectTitle() {
        return projectTitle.getText();
    }

}
