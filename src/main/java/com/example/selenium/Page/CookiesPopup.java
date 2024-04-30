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

public class CookiesPopup {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;
    private Actions actions;

    @FindBy(how = How.ID, using = "usercentrics-root")
    private WebElement userCentricRoot;


    public CookiesPopup(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        actions = new Actions(driver);
    }


    public void acceptAllCookies() {
        WebElement acceptAllCookiesButton = userCentricRoot.getShadowRoot().findElement(By.cssSelector(Locators.ACCEPT_ALL_COOKIES));
        wait.until(ExpectedConditions.visibilityOf(acceptAllCookiesButton));
        actions.click(acceptAllCookiesButton).perform();
    }

    public void refuseAllCookies() {
        WebElement refuseAllCookiesButton = userCentricRoot.getShadowRoot().findElement(By.cssSelector(Locators.REFUSE_ALL_COOKIES));
        wait.until(ExpectedConditions.visibilityOf(refuseAllCookiesButton));
        actions.click(refuseAllCookiesButton).perform();
    }


}

