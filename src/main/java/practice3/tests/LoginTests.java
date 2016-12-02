package practice3.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import practice3.pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTests {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver(); //initialize/create object/open firefox
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(driver);
        loginPage.open(); //open poker URL
    }

    @Test
    public void positiveTest() {
        loginPage.setUsername("admin");
        loginPage.setPassword("123");
        loginPage.clickOnLogin();
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after login");
        Assert.assertNotEquals(driver.getCurrentUrl(), LoginPage.URL, "You are still on login page.");
    }

    @Test
    public void negativeTestWrongPasssord() {
        loginPage.login("admin", "123123");
        loginPage.clickOnLogin();
        String expectedMsg = "Invalid username or password";
        String actualMsg = loginPage.getErrorMessage();
        Assert.assertEquals(driver.getCurrentUrl(), LoginPage.URL, "You are NOT on login page.");
        Assert.assertEquals(driver.getTitle(), "Login", "Wrong title after unsuccessful login");
        Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
    }


    @Test
    public void negativeTestWrongLogin() {
        loginPage.login("admin123", "123");
        loginPage.clickOnLogin();
        String expectedMsg = "Invalid username or password";
        String actualMsg = loginPage.getErrorMessage();
        Assert.assertEquals(driver.getCurrentUrl(), LoginPage.URL, "You are NOT on login page.");
        Assert.assertEquals(driver.getTitle(), "Login", "Wrong title after unsuccessful login");
        Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
    }

    @Test
    public void negativeTestEmptyFields() {
        loginPage.login("admin123", "123");
        loginPage.clickOnLogin();
        String expectedMsg = "Value is required and can't be empty";
        String actualMsg = loginPage.getErrorMessage();
        Assert.assertEquals(driver.getCurrentUrl(), LoginPage.URL, "You are NOT on login page.");
        Assert.assertEquals(driver.getTitle(), "Login", "Wrong title after unsuccessful login");
        Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
    }

    @Test
    public void negativeTestEmptyLoginField() {
        loginPage.login("", "123");
        loginPage.clickOnLogin();
        String expectedMsg = "Value is required and can't be empty";
        String actualMsg = loginPage.getErrorMessageUsername();
        Assert.assertEquals(driver.getCurrentUrl(), LoginPage.URL, "You are NOT on login page.");
        Assert.assertEquals(driver.getTitle(), "Login", "Wrong title after unsuccessful login");
        Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
    }

    @Test
    public void negativeTestEmptyPassField() {
        loginPage.login("admin", "");
        loginPage.clickOnLogin();
        String expectedMsg = "Value is required and can't be empty";
        String actualMsg = loginPage.getErrorMessagePassword();
        Assert.assertEquals(driver.getCurrentUrl(), LoginPage.URL, "You are NOT on login page.");
        Assert.assertEquals(driver.getTitle(), "Login", "Wrong title after unsuccessful login");
        Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
    }

    @AfterTest
    public void afterTest() {
        //close browser
        driver.quit();
    }


}
