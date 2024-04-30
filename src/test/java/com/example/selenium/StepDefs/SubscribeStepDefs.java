package com.example.selenium.StepDefs;

import com.example.selenium.Page.ChooseCountryAndCurrencyForShoppingPopup;
import com.example.selenium.Page.CookiesPopup;
import com.example.selenium.Page.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;
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


    @Before
    public void setup() throws Exception {
        ChromeOptions browserOptions = getChromeOptions();

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);

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

    @When("the user inserts a valid email and attempts to subscribe")
    public void theUserInsertsAValidEmailAndAttemptsToSubscribe() {
        log.info("the user inserts a valid email and attempts to subscribe");
        homePage.enterSubscriptionEmail("gugrafraprounnei-8471@yopmail.com");
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
        String alertMessage = driver.switchTo().alert().getText();
        log.info("message of alert {}", alertMessage);
        Assert.assertEquals(alertMessage, "Thank you for your subscription.");
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
        sauceOptions.put("username", "oauth-ibrahim.ghorafi-5876c");
        sauceOptions.put("accessKey", "a4b582b8-2a4b-4234-87f2-fe65fec55de0");
        sauceOptions.put("build", "your_build_id");
        sauceOptions.put("name", "facebook_login_registration_test");
        browserOptions.setCapability("sauce:options", sauceOptions);
        return browserOptions;
    }
}
