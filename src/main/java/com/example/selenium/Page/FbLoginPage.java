package com.example.selenium.Page;

import com.example.selenium.Utils.Locators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class FbLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    @FindBy(how = How.XPATH, using = Locators.FIRST_NAME_FIELD_XPATH)
    private WebElement firstNameField;

    @FindBy(how = How.XPATH, using = Locators.LAST_NAME_FIELD_XPATH)
    private WebElement lastNameField;

    @FindBy(how = How.XPATH, using = Locators.EMAIL_FIELD_XPATH)
    private WebElement emailField;

    @FindBy(how = How.XPATH, using = Locators.PASSWORD_FIELD_XPATH)
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = Locators.DAY_OF_BIRTH_FIELD_XPATH)
    private WebElement dayOfBirthField;

    @FindBy(how = How.XPATH, using = Locators.MONTH_OF_BIRTH_FIELD_XPATH)
    private WebElement monthOfBirthField;

    @FindBy(how = How.XPATH, using = Locators.YEAR_OF_BIRTH_FIELD_XPATH)
    private WebElement yearOfBirthField;

    @FindBy(how = How.XPATH, using = Locators.GENDER_RADIO_BUTTON_XPATH)
    private WebElement genderRadioButton;

    @FindBy(how = How.XPATH, using = Locators.SUBMIT_BUTTON_XPATH)
    private WebElement submitButton;

    public FbLoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);
    }

    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(lastNameField));
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }

    public void selectDayOfBirth(String day) {
        selectOption(dayOfBirthField, Locators.DAY_OPTION_XPATH, day);
    }

    public void selectMonthOfBirth(String month) {
        selectOption(monthOfBirthField, Locators.MONTH_OPTION_XPATH, month);
    }

    public void selectYearOfBirth(String year) {
        selectOption(yearOfBirthField, Locators.YEAR_OPTION_XPATH, year);
    }

    private void selectOption(WebElement field, String optionLocator, String value) {
        wait.until(ExpectedConditions.visibilityOf(field));
        actions.moveToElement(field).click().perform();
        WebElement option = driver.findElement(By.xpath(String.format(optionLocator, value)));
        option.click();
    }

    public void selectGender() {
        wait.until(ExpectedConditions.visibilityOf(genderRadioButton));
        genderRadioButton.click();
    }

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
