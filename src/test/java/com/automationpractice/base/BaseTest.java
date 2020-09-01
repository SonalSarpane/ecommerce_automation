package com.automationpractice.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

public class BaseTest {

    private static WebDriver driver;
    private static Properties prop;

    public static WebDriver getDriver() {
        return driver;
    }

    public static Properties getProp() {
        return prop;
    }

    private void loadProperties() {
        prop = new Properties();
        try {
            FileInputStream fin = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
            try {
                prop.load(fin);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public WebDriver initialization() {
        loadProperties();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        WebDriverManager.chromedriver().setup();
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("automation.url"));
        return driver;
    }

    public void tearDown() {
        driver.close();
    }
}
