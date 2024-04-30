package com.example.selenium.Page;

import com.example.selenium.Utils.Locators;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
public class HomePage {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;
    private Actions actions;

    @FindBy(how = How.XPATH, using = Locators.SUBSCRIPTION_EMAIL_INPUT)
    private WebElement subscriptionEmailInput;

    @FindBy(how = How.XPATH, using = Locators.SELECT_COUNTRY)
    private WebElement selectCountry;

    @FindBy(how = How.XPATH, using = Locators.SELECT_GENERAL_INTEREST)
    private WebElement selectGeneralInterest;

    @FindBy(how = How.XPATH, using = Locators.SELECT_PRODUCT_INTEREST)
    private WebElement selectProductInterest;

    @FindBy(how = How.XPATH, using = Locators.SUBSCRIBE_BUTTON)
    private WebElement subscribeButton;

    @FindBy(how = How.XPATH, using = "//header//span[contains(text(),'Change')]")
    private WebElement changeDestination;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        actions = new Actions(driver);
    }

    public void scrollToSubscriptionSection() {
        wait.until(ExpectedConditions.visibilityOf(subscriptionEmailInput));
        actions.click(subscriptionEmailInput).perform();
        actions.scrollToElement(subscribeButton).perform();
    }

    public void enterSubscriptionEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(subscriptionEmailInput));
        subscriptionEmailInput.sendKeys(email);
    }

    public void selectCountry(String countryName) {
        selectOption(selectCountry, Locators.COUNTRY_OPTION_XPATH, countryName);
    }

    public void selectGeneralInterest(String generalInterestName) {
        selectOption(selectGeneralInterest, Locators.GENERAL_INTEREST_OPTION_XPATH, generalInterestName);
    }

    public void selectProductInterest(String productInterestName) {
        selectOption(selectProductInterest, Locators.PRODUCT_INTEREST_OPTION_XPATH, productInterestName);
    }

    public void subscribeButton() {
        wait.until(ExpectedConditions.visibilityOf(subscribeButton));
        actions.moveToElement(subscribeButton).click(subscribeButton).perform();
    }

    public void changeDestination() {
        wait.until(ExpectedConditions.visibilityOf(changeDestination));
        actions.moveToElement(changeDestination).click(changeDestination).perform();
        //changeDestination.click();
    }

    private void selectOption(WebElement field, String optionLocator, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(field));
        log.info("1");
        actions.moveToElement(field).click().perform();
        log.info("2");
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(optionLocator, value))));
        log.info("3");
        option.click();
        log.info("4");
    }

}
