package com.automationpractice.pages;

import com.automationpractice.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement txt_email;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement txt_password;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement btn_submit;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailAndPassword(String emailId, String password) {
        waitForElementToBeVisible(txt_email);
        writeText(txt_email,emailId);
        writeText(txt_password, password);
    }

    public void clickOnSignIn() {
        click(btn_submit);
    }
}

