package com.example.selenium.Utils;

import com.example.selenium.PagesTest.TestBase;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class CustomListener implements ITestListener {

    private WebDriver driver;
    private String screenshotName;

    @Override
    public void onTestStart(ITestResult result) {
        log.info("[TestNG Listener] Test Started: {}", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("[TestNG Listener] Test Passed: {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("[TestNG Listener] Test Failed: {}", result.getName());
        Object testClass = result.getInstance();
        driver = ((TestBase) testClass).getDriver();
        if (driver instanceof TakesScreenshot) {
            screenshotName = takeScreenshot(result.getName());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("[TestNG Listener] Test Skipped: {}", result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("[TestNG Listener] Test Started: {}", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("[TestNG Listener] Test Finished: {}", context.getName());
        if (screenshotName != null) {
            log.info("Screenshot saved: {}", screenshotName);
        }
    }

    private String takeScreenshot(String testName) {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String screenshotName = "" + testName + "_" + timestamp + ".png";
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
            FileUtils.saveBytesToFile(screenshotBytes, screenshotName);
            return screenshotName;
        } catch (Exception e) {
            log.error("[TestNG Listener] Failed to take screenshot: {}", e.getMessage());
            return null;
        }
    }
}
