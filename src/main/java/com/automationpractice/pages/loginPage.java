package com.automationpractice.pages;

import com.automationpractice.base.basePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage {

    @FindBy(xpath = "//div/a[@class='login']")
    private WebElement btn_signIn;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement txt_email;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement txt_password;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement btn_submit;

    public loginPage(WebDriver driver) {
        super(driver);
    }
}

