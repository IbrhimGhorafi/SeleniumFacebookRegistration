package com.example.selenium.Utils;

public class Locators {
    public static final String FIRST_NAME_FIELD_XPATH = "//input[@name='firstname']";
    public static final String LAST_NAME_FIELD_XPATH = "//input[@name='lastname']";
    public static final String EMAIL_FIELD_XPATH = "//input[@name='reg_email__']";
    public static final String PASSWORD_FIELD_XPATH = "//input[@name='reg_passwd__']";
    public static final String DAY_OF_BIRTH_FIELD_XPATH = "//select[@id='day']";
    public static final String DAY_OPTION_XPATH = "//option[contains(text(),'%s')]";
    public static final String MONTH_OF_BIRTH_FIELD_XPATH = "//select[@id='month']";
    public static final String MONTH_OPTION_XPATH = "//option[contains(text(),'%s')]";
    public static final String YEAR_OF_BIRTH_FIELD_XPATH = "//select[@id='year']";
    public static final String YEAR_OPTION_XPATH = "//option[contains(text(),'%s')]";
    public static final String GENDER_RADIO_BUTTON_XPATH = "//span[@data-name='gender_wrapper']//span[1]//input[@name='sex']";
    public static final String SUBMIT_BUTTON_XPATH = "//div[contains(@class,'_1lch')]//button[@name='websubmit']";

}