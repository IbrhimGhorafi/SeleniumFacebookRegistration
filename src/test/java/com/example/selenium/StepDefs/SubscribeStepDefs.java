package com.example.selenium.StepDefs;

import com.example.selenium.Page.ChooseCountryAndCurrencyForShoppingPopup;
import com.example.selenium.Page.CookiesPopup;
import com.example.selenium.Page.HomePage;
import com.example.selenium.Utils.WebDriverListener;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SubscribeStepDefs {
    private WebDriver driver;
    private HomePage homePage;
    private ChooseCountryAndCurrencyForShoppingPopup chooseCountryAndCurrencyForShoppingPopup;
    private CookiesPopup cookiesPopup;


//    @Before
//    public void setup() throws Exception {
//        ChromeOptions browserOptions = getChromeOptions();
//
//        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//        driver = new RemoteWebDriver(url, browserOptions);
//
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        homePage = PageFactory.initElements(driver, HomePage.class);
//        chooseCountryAndCurrencyForShoppingPopup = PageFactory
//                .initElements(driver, ChooseCountryAndCurrencyForShoppingPopup.class);
//        cookiesPopup = PageFactory.initElements(driver, CookiesPopup.class);
//    }

    @Before
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ch\\chromedriver-win64\\chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver()).register(new WebDriverListener());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage = PageFactory.initElements(driver, HomePage.class);
        chooseCountryAndCurrencyForShoppingPopup = PageFactory
                .initElements(driver, ChooseCountryAndCurrencyForShoppingPopup.class);
        cookiesPopup = PageFactory.initElements(driver, CookiesPopup.class);

    }

    @Given("the user is on the Fortnums and Mason homepage")
    public void theUserIsOnTheFortnumsAndMasonHomepage() {
        driver.get("https://www-preprod3.fortnums.net/");
        Locale locale = Locale.getDefault();
        String lang = locale.getDisplayLanguage();
        String country = locale.getDisplayCountry();
        log.info("Lang: {} Country: {}", lang, country);
        cookiesPopup.acceptAllCookies();
        homePage.changeDestination();
    }

    @And("the user select the Non EU country switcher {} and {}")
    public void theUserSelectTheNonEUCountrySwitcherCountry(String countryName, String currency) {
        log.info("the user select the Non EU country switcher {} and {}", countryName, currency);
        chooseCountryAndCurrencyForShoppingPopup.clickCountryDropdown();
        chooseCountryAndCurrencyForShoppingPopup.enterCountryInput(countryName);
        chooseCountryAndCurrencyForShoppingPopup.selectCountry(countryName);
        chooseCountryAndCurrencyForShoppingPopup.clickCurrencyDropdown();
        chooseCountryAndCurrencyForShoppingPopup.selectCurrency(currency);
        chooseCountryAndCurrencyForShoppingPopup.clickStartShoppingButton();
    }

    @And("the user has accessed the sign-up bloc")
    public void theUserHasAccessedTheSignUpBloc() {
        log.info("the user has accessed the sign-up bloc");
        homePage.scrollToSubscriptionSection();
    }

    @When("the user inserts a valid email {} and attempts to subscribe")
    public void theUserInsertsAValidEmailAndAttemptsToSubscribe(String email) {
        log.info("the user inserts a valid email and attempts to subscribe");
        homePage.enterSubscriptionEmail(email);
    }

    @And("the user selects the country where they live {}")
    public void theUserSelectsTheCountryWhereTheyLiveCountry(String countryName) {
        log.info("the user selects the country where they live {}", countryName);
        homePage.selectCountry(countryName);
    }

    @And("the user selects the most exciting topic from the world of Fortnums {}")
    public void theUserSelectsTheMostExcitingTopicFromTheWorldOfFortnumsFortnumTopic(String topicName) {
        log.info("the user selects the most exciting topic from the world of Fortnums {}", topicName);
        homePage.selectGeneralInterest(topicName);
    }

    @And("the user selects the Fortnums product {} they would take to a desert island")
    public void theUserSelectsTheFortnumsProductProductTheyWouldTakeToADesertIsland(String productName) {
        log.info("the user selects the Fortnums product {} they would take to a desert island", productName);
        homePage.selectProductInterest(productName);
    }

    @And("the user attemps to subscribe")
    public void theUserAttempsToSubscribe() {
        homePage.subscribeButton();
    }

    @Then("the user is successfully subscribed")
    public void theUserIsSuccessfullySubscribed() {
        log.info("I am in last method : theUserIsSuccessfullySubscribed");
        String message = homePage.messageOfSuccessSubscribe();
        Assert.assertEquals(message, "Thank you for your subscription.");

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
        sauceOptions.put("name", "facebook_login_registration_test");
        browserOptions.setCapability("sauce:options", sauceOptions);
        return browserOptions;
    }
}
