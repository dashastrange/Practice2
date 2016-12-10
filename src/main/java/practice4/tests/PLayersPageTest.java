package practice4.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import practice3.pages.LoginPage1;
import practice4.pages.PlayersPage;

import java.util.concurrent.TimeUnit;

public class PLayersPageTest {
    private WebDriver driver;
    private PlayersPage playersPage;

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        LoginPage1 loginPage = new LoginPage1(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.open();
        loginPage.login("admin", "123");
        playersPage = new PlayersPage(driver);
        playersPage.open();
    }

    @BeforeMethod
    public void beforeMethod() {
        playersPage.clickOnReset();
    }

    /**
     * 1. Fill login field in search panel
     * 2. Click Reset
     * 3. Verify that all fields became blank
     */
    @Test
    public void resetSearch() {
        playersPage.fillFieldsForReset();
        playersPage.clickOnReset();
        playersPage.assertIsFieldsEmpty();
    }

    /**
     * 1. Fill Email field in search panel
     * 2. Click Search
     * 3. Verify that list of players not empty
     */
    @Test
    public void searchByEmailTest() {
        playersPage.fillFieldsForSearchEmail();
        playersPage.clickOnSearch();
        playersPage.assertIsPlayerListNotEmpty();
    }

    /**
     * 1. Fill City field in search panel
     * 2. Click Search
     * 3. Verify that list of players not empty
     */
    @Test
    public void searchByCity() {
        playersPage.fillFieldsForSearchCity();
        playersPage.clickOnSearch();
        playersPage.assertIsPlayerListNotEmpty();
    }

    /**
     * 1. Fill RegDate (from) field in search panel
     * 2. Click Search
     * 3. Verify that list of players not empty
     */
    @Test
    public void searchByRegDateFrom(){
        playersPage.fillFieldsForRegDateFrom();
        playersPage.clickOnSearch();
        playersPage.assertIsPlayerListNotEmpty();
    }

    /**
     * 1. Fill RegDate (till) field in search panel
     * 2. Click Search
     * 3. Verify that list of players not empty
     */
    @Test
    public void searchByRegDateTo() {
        playersPage.fillFieldsForRegDateTo();
        playersPage.clickOnSearch();
        playersPage.assertIsPlayerListNotEmpty();
    }

    /**
     * 1. Fill First Name field in search panel
     * 2. Click Search
     * 3. Verify that list of players not empty
     */
    @Test
    public void searchByFNme(){
        playersPage.fillFieldsForSearchFName();
        playersPage.clickOnSearch();
        playersPage.assertIsPlayerListNotEmpty();
    }

    /**
     * 1. Fill Last Name field in search panel
     * 2. Click Search
     * 3. Verify that list of players not empty
     */
    @Test
    public void searchByLName() {
        playersPage.fillFieldsForSearchLName();
        playersPage.clickOnSearch();
        playersPage.assertIsPlayerListNotEmpty();
    }

    /**
     * 1. Fill Last Login field in search panel
     * 2. Click Search
     * 3. Verify that list of players not empty
     */
    @Test
    public void searchByLastLogin() {
        playersPage.fillFieldsForSearchLastLogin();
        playersPage.clickOnSearch();
        playersPage.assertIsPlayerListNotEmpty();
    }

    /**
     * 1. Fill MAC Address field in search panel
     * 2. Click Search
     * 3. Verify that list of players not empty
     */
    @Test
    public void searchByMacAddr(){
        playersPage.fillFieldsForSearchByMac();
        playersPage.clickOnSearch();
        playersPage.assertIsPlayerListNotEmpty();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
