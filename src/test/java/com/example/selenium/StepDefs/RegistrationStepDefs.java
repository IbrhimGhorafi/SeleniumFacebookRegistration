package com.example.selenium.StepDefs;

import com.example.selenium.Page.FbLoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;
@Slf4j
public class RegistrationStepDefs  {

    private WebDriver driver;

    @Given("User is on Facebook registration page")
    public void userIsOnFacebookRegistrationPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ch\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://fr-fr.facebook.com/reg/");
    }

    @When("User enters registration details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_enters_registration_details(String firstName, String lastName, String email, String password, String dayOfBirth, String monthOfBirth, String yearOfBirth, String gender) {
        FbLoginPage fbLoginPage = PageFactory.initElements(driver, FbLoginPage.class);
        fbLoginPage.enterFirstName(firstName);
        fbLoginPage.enterLastName(lastName);
        fbLoginPage.enterEmail(email);
        fbLoginPage.enterPassword(password);
        fbLoginPage.selectDayOfBirth(dayOfBirth);
        fbLoginPage.selectMonthOfBirth(monthOfBirth);
        fbLoginPage.selectYearOfBirth(yearOfBirth);
        fbLoginPage.selectGender();
    }


    @When("User clicks the submit button")
    public void userClicksTheSubmitButton() {
        FbLoginPage fbLoginPage = PageFactory.initElements(driver, FbLoginPage.class);
        fbLoginPage.clickSubmitButton();
    }

    @Then("User should be registered successfully")
    public void userShouldBeRegisteredSuccessfully() {
        driver.quit();
    }
}
