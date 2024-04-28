package com.example.selenium.PagesTest;

import com.example.selenium.Utils.CustomListener;
import com.example.selenium.Utils.WebDriverListener;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

@Listeners(CustomListener.class)
public class TestBase {
    public static WebDriver driver = null;

    @BeforeSuite
    public WebDriver initialize() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ch\\chromedriver-win64\\chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver()).register(new WebDriverListener());
        //driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://fr-fr.facebook.com/reg/");
        return driver;
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
