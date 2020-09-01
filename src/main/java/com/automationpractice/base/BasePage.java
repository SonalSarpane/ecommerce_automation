package com.automationpractice.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(this.driver, 20);
    }

    protected void waitForElementToBeVisible(WebElement element) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            } catch (Exception e) {
                System.out.println("Element is not visible, hence retrying" +attempts);
            }
            attempts++;
        }
    }

    protected void writeText(WebElement element,String value) {
        element.sendKeys(value);
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected void click(WebElement element) {
        element.click();
    }
}
