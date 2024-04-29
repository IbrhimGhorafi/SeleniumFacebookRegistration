/*package com.example.selenium.PagesTest;

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
        //driver = new EventFiringWebDriver(new ChromeDriver()).register(new WebDriverListener());
        driver=new ChromeDriver();
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
}*/
package com.example.selenium.PagesTest;

import com.example.selenium.Utils.CustomListener;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Listeners(CustomListener.class)
public class TestBase {
    public static RemoteWebDriver driver = null;

    @BeforeSuite
    public RemoteWebDriver initialize() throws Exception {
        ChromeOptions browserOptions = getChromeOptions();

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://fr-fr.facebook.com/reg/");
        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("124");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "your_username");
        sauceOptions.put("accessKey", "your_access_key");
        sauceOptions.put("build", "your_build_id");
        sauceOptions.put("name", "you_name_test");
        browserOptions.setCapability("sauce:options", sauceOptions);
        return browserOptions;
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }
}

