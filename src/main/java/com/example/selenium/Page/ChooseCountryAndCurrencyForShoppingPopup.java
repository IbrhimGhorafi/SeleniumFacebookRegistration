package com.example.selenium.Page;

import com.example.selenium.Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ChooseCountryAndCurrencyForShoppingPopup {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;
    private Actions actions;

    @FindBy(how = How.XPATH, using = Locators.COUNTRY_DROPDOWN)
    WebElement countryDropdown;

    @FindBy(how = How.XPATH, using = Locators.COUNTRY_INPUT)
    WebElement countryInput;

    @FindBy(how = How.XPATH, using = Locators.CURRENCY_DROPDOWN)
    WebElement dropdownCurrency;

    @FindBy(how = How.XPATH, using = Locators.START_SHOPPING_BUTTON)
    WebElement startShoppingButton;

    public ChooseCountryAndCurrencyForShoppingPopup(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        actions = new Actions(driver);
    }

    public void clickCountryDropdown() {
        wait.until(ExpectedConditions.visibilityOf(countryDropdown));
        actions.moveToElement(countryDropdown).perform();
        actions.click(countryDropdown).perform();
    }

    public void enterCountryInput(String country) {
        wait.until(ExpectedConditions.visibilityOf(countryInput));
        countryInput.sendKeys(country);
    }

    public void selectCountry(String country) {
        String xpath = String.format(Locators.COUNTRY_DROPDOWN_ITEM, country);
        WebElement countryElement = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(countryElement));
        countryElement.click();
    }

    public void clickCurrencyDropdown() {
        wait.until(ExpectedConditions.visibilityOf(dropdownCurrency));
        actions.moveToElement(dropdownCurrency).perform();
        actions.click(dropdownCurrency).perform();
    }

    public void selectCurrency(String currency) {
        String xpath = String.format(Locators.CURRENCY_ITEM, currency);
        WebElement currencyElement = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(currencyElement));
        currencyElement.click();
    }

    public void clickStartShoppingButton() {
        wait.until(ExpectedConditions.visibilityOf(startShoppingButton));
        actions.moveToElement(startShoppingButton).perform();
        actions.click(startShoppingButton).perform();
    }
}
