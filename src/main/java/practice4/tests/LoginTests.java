package practice4.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import practice4.pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private SoftAssert softAssert;

    @BeforeSuite
    public void beforeSuite() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(driver);
        loginPage.open();
        softAssert = new SoftAssert();
    }

    @DataProvider
    public Object[][] loginPositiveData() {
        return new Object[][] {
                {"admin", "123", "Players"}
        };
    }

    @Test(dataProvider = "loginPositiveData", groups = "high")
    public void positiveLoginTest(String username, String password, String title) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickOnLogin();
        softAssert.assertEquals(driver.getTitle(), title, "Wrong title after login");
        softAssert.assertNotEquals(driver.getCurrentUrl(), LoginPage.URL, "You are still on login page.");
        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] loginNegativeData() {
        return new Object[][] {
                {"admin123", "123123", "Login", "Invalid username or password"},
                {"admin", "123123", "Login", "Invalid username or password"},
                {"admin123", "123", "Login", "Invalid username or password"},
                {"", "", "Login", "Value is required and can't be empty"},
                {"", "123", "Login", "Value is required and can't be empty"},
                {"admin", "", "Login", "Value is required and can't be empty"}
        };
    }

    @Test(dataProvider = "loginNegativeData", groups = "low")
    public void negativeLoginTests(String username, String password, String title, String expectedMsg) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickOnLogin();
        String actualMsg = loginPage.getErrorMessage();
        softAssert.assertEquals(driver.getCurrentUrl(), LoginPage.URL, "You are NOT on login page.");
        softAssert.assertEquals(driver.getTitle(), title, "Wrong title after unsuccessful login");
        softAssert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
        softAssert.assertAll();
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }


}
