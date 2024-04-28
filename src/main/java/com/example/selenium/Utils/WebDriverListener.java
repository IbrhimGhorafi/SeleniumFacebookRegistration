package com.example.selenium.Utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

@Slf4j
public class WebDriverListener extends AbstractWebDriverEventListener {

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        log.info("[WebDriver Listener] Trying to find Element By : " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        log.info("[WebDriver Listener] Found Element By : " + by.toString());
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        log.warn("[WebDriver Listener] Trying to click on: " + element.toString());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        log.warn("[WebDriver Listener] Clicked on: " + element.toString());
    }

    @Override
    public void onException(Throwable error, WebDriver driver) {
        log.error("[WebDriver Listener] Exception occurred: " + error);
    }
}
