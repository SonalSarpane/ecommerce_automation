package com.automationpractice.pages;

import com.automationpractice.base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(className = "login")
    private WebElement btn_singIn;

    @FindBy(xpath = "//a[@class='account']/span")
    private WebElement lbl_userAccount;
    
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickOnSignIn() {
        btn_singIn.click();
        return new LoginPage(driver);
    }

    public String getUserName() {
        waitForElementToBeVisible(lbl_userAccount);
        return getText(lbl_userAccount);
    }

}
