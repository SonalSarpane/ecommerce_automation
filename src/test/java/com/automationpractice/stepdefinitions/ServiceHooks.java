package com.automationpractice.stepdefinitions;

import com.automationpractice.base.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ServiceHooks {

    private BaseTest baseTest;

    @Before
    public void init() {
        baseTest = new BaseTest();
        baseTest.initialization();
    }

   @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                System.out.println(scenario.getName() + "is failed");
                final byte[] screenshot = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                System.out.println(scenario.getName() + "is passed");
                scenario.embed(((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        baseTest.tearDown();
    }
}
