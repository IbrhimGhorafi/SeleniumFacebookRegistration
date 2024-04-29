package com.example.selenium.StepDefs;

import com.example.selenium.Page.FbLoginPage;
import com.example.selenium.PagesTest.TestBase;
import com.example.selenium.Utils.CustomListener;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Listeners({CustomListener.class})
@Slf4j
public class RegistrationStepDefs extends TestBase {

    private WebDriver driver;
    FbLoginPage fbLoginPage = null;


    @Before
    public void setup() throws Exception {
        ChromeOptions browserOptions = getChromeOptions();

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        fbLoginPage = PageFactory.initElements(driver, FbLoginPage.class);
    }

    @Given("User is on Facebook registration page")
    public void userIsOnFacebookRegistrationPage() {
        driver.get("https://fr-fr.facebook.com/reg/");
    }

    @When("User enters registration details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_enters_registration_details(String firstName, String lastName, String email, String password, String dayOfBirth, String monthOfBirth, String yearOfBirth, String gender) {
        log.warn("Hello from test methode " + firstName + " " + lastName);
        fbLoginPage.enterFirstName(firstName);
        fbLoginPage.enterLastName(lastName);
        fbLoginPage.enterEmail(email);
        //fbLoginPage.enterEmailConfirmation(email);
        fbLoginPage.enterPassword(password);
        fbLoginPage.selectDayOfBirth(dayOfBirth);
        fbLoginPage.selectMonthOfBirth(monthOfBirth);
        fbLoginPage.selectYearOfBirth(yearOfBirth);
        fbLoginPage.selectGender();
//        fbLoginPage.clickSubmitButton();
    }

    @When("User clicks the submit button")
    public void userClicksTheSubmitButton() {
        //FbLoginPage fbLoginPage = new FbLoginPage(driver);
        fbLoginPage.clickSubmitButton();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("User should be registered successfully")
    public void userShouldBeRegisteredSuccessfully() {
        log.info("User should be registered successfully");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
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
}
