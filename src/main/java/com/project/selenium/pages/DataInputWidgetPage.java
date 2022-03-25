package com.project.selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.project.selenium.utilities.TestUtils.waitForElementToBeVisible;

public class DataInputWidgetPage {
    private WebDriver driver;

    public DataInputWidgetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//widget-data-input//span[ text() = 'Singular' ]")
    WebElement singularTab;

    @FindAll(@FindBy(xpath = "//widget-data-input//tbody/tr"))
    List<WebElement> rows;


    @FindBy(xpath = "//div[@id='form-dialog-title']//parent::div[1]//input[@id='value']")
    WebElement valueField;

    @FindBy(xpath = "//div[@id='form-dialog-title']//parent::div[1]//span[ text() = 'Submit' ]")
    WebElement addFormSubmit;

    @FindBy(xpath = "//div[@id='form-dialog-title']//parent::div[1]//span[ text() = 'Cancel' ]")
    WebElement addFormCancel;

    @FindBy(tagName = "widget-data-input")
    WebElement dataInputWidget;

    @FindBy(xpath = "//div[contains(@class,'MuiAlert-message') and contains(text(),'Successfully')]")
    WebElement successAlert;

    @FindBy(xpath = "//div[contains(@class, 'MuiAlert-message') and contains(text(),'Failed')]")
    WebElement fieldValidationAlert;

    @Step("Widget Page - Wait for page load")
    public void waitForPageLoad() {
        if (!dataInputWidget.isEnabled())
            waitForElementToBeVisible(driver, dataInputWidget);
    }

    @Step("Widget Page - Submit Value to Singular tab and verify new value appears [first row]")
    public void submitValueForSingular(int rowNumber, String value) {
        singularTab.click();
        //addButtons.get(rowNumber).click();
        rows.get(rowNumber).findElement(By.xpath("//td[6]")).click();

        valueField.sendKeys(value);
        addFormSubmit.click();
    }

    @Step("Get success message text")
    public String getSuccessMessageText() {
        waitForElementToBeVisible(driver, successAlert);
        return successAlert.getText();
    }

    @Step("Get Field validation message text")
    public String getFieldValidationMessageText() {
        waitForElementToBeVisible(driver, fieldValidationAlert);
        return fieldValidationAlert.getText();
    }

    @Step("Widget Page - Cancel submit on form singular tab to add values [first row]")
    public void submitValueForSingularAndCancelSubmit(int rowNumber, String value) {
        singularTab.click();
        //addButtons.get(rowNumber).click();
        rows.get(rowNumber).findElement(By.xpath("//td[6]")).click();

        valueField.sendKeys(value);
        addFormCancel.click();
    }

    @Step("Widget Page - Get Singular tab value from first row")
    public String getLatestValueFromSingularTab(int rowNumber) {
        singularTab.click();
        return rows.get(rowNumber).findElement(By.xpath("//td[5]")).getText();
    }
}
