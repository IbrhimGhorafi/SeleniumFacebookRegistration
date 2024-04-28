package com.example.selenium.Page;

import com.example.selenium.Utils.Locators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class FbLoginPageWithOutUsingAction {

    private WebDriver driver;
    private WebDriverWait wait;

    public FbLoginPageWithOutUsingAction(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(how = How.XPATH, using = Locators.FIRST_NAME_FIELD_XPATH)
    WebElement firstNameField;

    @FindBy(how = How.XPATH, using = Locators.LAST_NAME_FIELD_XPATH)
    WebElement lastNameField;

    @FindBy(how = How.XPATH, using = Locators.EMAIL_FIELD_XPATH)
    WebElement emailField;

    @FindBy(how = How.XPATH, using = Locators.PASSWORD_FIELD_XPATH)
    WebElement passwordField;

    @FindBy(how = How.XPATH, using = Locators.DAY_OF_BIRTH_FIELD_XPATH)
    WebElement dayOfBirthField;

    @FindBy(how = How.XPATH, using = Locators.MONTH_OF_BIRTH_FIELD_XPATH)
    WebElement monthOfBirthField;

    @FindBy(how = How.XPATH, using = Locators.YEAR_OF_BIRTH_FIELD_XPATH)
    WebElement yearOfBirthField;

    @FindBy(how = How.XPATH, using = Locators.GENDER_RADIO_BUTTON_XPATH)
    WebElement genderRadioButton;

    @FindBy(how = How.XPATH, using = Locators.SUBMIT_BUTTON_XPATH)
    WebElement submitButton;

    public void enterFirstName(String firstName) {
        log.info("Entering first name: {}", firstName);
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        log.info("Entering last name: {}", lastName);
        wait.until(ExpectedConditions.visibilityOf(lastNameField));
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        log.info("Entering email: {}", email);
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        log.info("Entering password: {}", password);
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }

    public void selectDayOfBirth(String day) {
        log.info("Selecting day of birth: {}", day);
        wait.until(ExpectedConditions.visibilityOf(dayOfBirthField));
        Select dayDropdown = new Select(dayOfBirthField);
        dayDropdown.selectByVisibleText(day);
    }

    public void selectMonthOfBirth(String month) {
        log.info("Selecting month of birth: {}", month);
        wait.until(ExpectedConditions.visibilityOf(monthOfBirthField));
        Select monthDropdown = new Select(monthOfBirthField);
        monthDropdown.selectByVisibleText(month);
    }

    public void selectYearOfBirth(String year) {
        log.info("Selecting year of birth: {}", year);
        wait.until(ExpectedConditions.visibilityOf(yearOfBirthField));
        Select yearDropdown = new Select(yearOfBirthField);
        yearDropdown.selectByVisibleText(year);
    }

    public void selectGender() {
        log.info("Selecting gender");
        wait.until(ExpectedConditions.visibilityOf(genderRadioButton));
        genderRadioButton.click();
        log.info("Selecting gender is selected");
    }

    public void clickSubmitButton() {
        log.info("Clicking submit button");
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


