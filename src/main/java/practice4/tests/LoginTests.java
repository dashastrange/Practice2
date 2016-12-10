package practice4.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import practice4.pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTests {

    private WebDriver driver;
    private LoginPage loginPage;

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
    }

    @DataProvider
    public Object[][] loginPositiveData() {
        return new Object[][] {
                {"admin", "123"}
        };
    }

    @Test(dataProvider = "loginPositiveData")
    public void positiveLoginTest(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickOnLogin();

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

    @Test(dataProvider = "loginNegativeData")
    public void negativeLoginTests(String username, String password, String title, String expectedMsg) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickOnLogin();
        String actualMsg = loginPage.getErrorMessage();
        Assert.assertEquals(driver.getCurrentUrl(), LoginPage.URL, "You are NOT on login page.");
        Assert.assertEquals(driver.getTitle(), title, "Wrong title after unsuccessful login");
        Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }


}
