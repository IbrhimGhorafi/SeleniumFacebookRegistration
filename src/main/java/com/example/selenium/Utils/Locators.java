package com.example.selenium.Utils;

public class Locators {
    public static final String FIRST_NAME_FIELD_XPATH = "//input[@name='firstname']";
    public static final String LAST_NAME_FIELD_XPATH = "//input[@name='lastname']";
    public static final String EMAIL_FIELD_XPATH = "//input[@name='reg_email__']";
    public static final String EMAIL_CONFIRMATION_FIELD_XPATH = "//input[@name='reg_email_confirmation__']";
    public static final String PASSWORD_FIELD_XPATH = "//input[@name='reg_passwd__']";
    public static final String DAY_OF_BIRTH_FIELD_XPATH = "//select[@id='day']";
    public static final String DAY_OPTION_XPATH = "//option[contains(text(),'%s')]";
    public static final String MONTH_OF_BIRTH_FIELD_XPATH = "//select[@id='month']";
    public static final String MONTH_OPTION_XPATH = "//option[contains(text(),'%s')]";
    public static final String YEAR_OF_BIRTH_FIELD_XPATH = "//select[@id='year']";
    public static final String YEAR_OPTION_XPATH = "//option[contains(text(),'%s')]";
    public static final String GENDER_RADIO_BUTTON_XPATH = "//span[@data-name='gender_wrapper']//span[1]//input[@name='sex']";
    public static final String SUBMIT_BUTTON_XPATH = "//div[contains(@class,'_1lch')]//button[@name='websubmit']";
    public static final String ACCEPT_ALL_COOKIES = "button[data-testid='uc-accept-all-button']";
    public static final String REFUSE_ALL_COOKIES = "button[data-testid='uc-deny-all-button']";
    public static final String COUNTRY_DROPDOWN = "//span[contains(@class,'country-container ')]//span[contains(@class,'p-dropdown-trigger-icon')]";
    public static final String COUNTRY_INPUT = "//input[contains(@class,'p-inputtext p-component')]";
    public static final String CURRENCY_DROPDOWN = "//div[contains(@class,'currency-container')]//span[contains(@class,'p-dropdown-trigger-icon')]";
    public static final String START_SHOPPING_BUTTON = "//div[contains(@id,'pr_id_4_content')]//button[text()='Start Shopping']";
    public static final String COUNTRY_DROPDOWN_ITEM = "//li[contains(@class,'p-dropdown-item')][text()='%s']";
    public static final String CURRENCY_ITEM = "//div[contains(@class,'currency-switcher-panel')]//li[contains(@aria-label,'%s')]";
    public static final String SUBSCRIPTION_EMAIL_INPUT = "//input[contains(@id,'subscription-email')]";
    public static final String SELECT_COUNTRY = "//select[contains(@name,'country')]";
    public static final String SELECT_GENERAL_INTEREST = "//select[contains(@name,'general_interest')]";
    public static final String SELECT_PRODUCT_INTEREST = "//select[contains(@name,'product_interest')]";
    public static final String SUBSCRIBE_BUTTON = "//button[contains(@aria-label,'Sign Up')]";
    public static final String COUNTRY_OPTION_XPATH = SELECT_COUNTRY + "//option[text()='%s']";
    public static final String GENERAL_INTEREST_OPTION_XPATH = SELECT_GENERAL_INTEREST + "//option[text()='%s']";
    public static final String PRODUCT_INTEREST_OPTION_XPATH = SELECT_PRODUCT_INTEREST + "//option[text()='%s']";
}