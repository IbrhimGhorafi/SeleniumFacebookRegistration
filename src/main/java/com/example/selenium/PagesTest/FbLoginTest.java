package com.example.selenium.PagesTest;

import com.example.selenium.Page.FbLoginPage;
import com.example.selenium.Utils.ConfigReader;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

@Slf4j
public class FbLoginTest extends TestBase {

    private static final String CSV_FILE_PATH = "data.csv";

    @Test
    public void fillRegistrationForm() {
        ConfigReader configReader = new ConfigReader();
        List<Map<String, String>> data = configReader.csvToMap(CSV_FILE_PATH);
        if (data != null && !data.isEmpty()) {
            Map<String, String> userData = data.get(0);
            FbLoginPage fbLoginPage = PageFactory.initElements(driver, FbLoginPage.class);
            fbLoginPage.enterFirstName(userData.get("firstName"));
            fbLoginPage.enterLastName(userData.get("lastName"));
            fbLoginPage.enterEmail(userData.get("email"));
            fbLoginPage.enterPassword(userData.get("password"));
            fbLoginPage.selectDayOfBirth(userData.get("dayOfBirth"));
            fbLoginPage.selectMonthOfBirth(userData.get("monthOfBirth"));
            fbLoginPage.selectYearOfBirth(userData.get("yearOfBirth"));
            fbLoginPage.selectGender();
            fbLoginPage.clickSubmitButton();
        } else {
            log.info("No data found in CSV file.");
        }
    }
}
