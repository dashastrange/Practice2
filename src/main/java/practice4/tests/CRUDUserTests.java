package practice4.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import practice4.pages.EditPlayerPage;
import practice4.pages.InsertPage;
import practice4.pages.LoginPage;
import practice4.pages.PlayersPage;

import java.util.concurrent.TimeUnit;

import static practice2.PokerPlayer.generateRandomString;

public class CRUDUserTests {

    private WebDriver driver;

    private String loginName =  "dasha" + generateRandomString(5);
    private String email = loginName + "@gmail.com";

    @BeforeSuite
    public void beforeTest() {
        driver = new FirefoxDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.open();
        loginPage.login("admin", "123");
    }

    @DataProvider
    public Object[][] createData() {
        return new Object[][] {
                {loginName, email, "111111", "111111", "First Name", "Last name", "LA", "553535355"}
        };
    }

    @Test(dataProvider = "createData", groups = "high")
    public void createPlayerTest(String login, String email, String pass, String conf_pass, String fname, String lname, String city, String phone) {
        PlayersPage playersPage = new PlayersPage(driver);
        playersPage.clickOnInsert();
        InsertPage insertPage = new InsertPage(driver);
        insertPage.open();
        Assert.assertEquals(driver.getTitle(), "Players - Insert", "Wrong title");
        insertPage.fillLogin(login);
        insertPage.fillEmail(email);
        insertPage.fillPass(pass);
        insertPage.fillConfPass(conf_pass);
        insertPage.fillFName(fname);
        insertPage.fillLName(lname);
        insertPage.fillCity(city);
        insertPage.fillPhone(phone);
        insertPage.clickOnSave();
    }

    @DataProvider
    public Object[][] editData() {
        return new Object[][] {
                {email,  "F Name", "L name", "NY", "12345678"}
        };
    }

    @Test(dataProvider = "editData", groups = "medium")
    public void editFields(String email, String fname, String lname, String city, String phone) {
        PlayersPage playersPage = new PlayersPage(driver);
        playersPage.open();
        playersPage.clickOnReset();
        playersPage.searchPlayer();
        playersPage.clickOnSearch();
        playersPage.clickOnEdit();
        EditPlayerPage editPlayerPage = new EditPlayerPage(driver);
        editPlayerPage.fillEmail(email);
        editPlayerPage.fillFName(fname);
        editPlayerPage.fillLName(lname);
        editPlayerPage.fillCity(city);
        editPlayerPage.fillPhone(phone);
    }

    @Test(groups = "high")
    public void deletePlayer() {
        PlayersPage playersPage = new PlayersPage(driver);
        playersPage.open();
        playersPage.searchPlayer();
        playersPage.clickOnSearch();
        playersPage.clickOnDelete();
        WebDriverWait wait = new WebDriverWait(driver, 5, 100);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @DataProvider
    public Object[][] createWithoutMandatoryData() {
        return new Object[][]{
                {"First Name", "Last name", "LA", "553535355", "Following errors have been occured:\n" +
                        "Username: Value is required and can't be empty\n" +
                        "E-mail: Value is required and can't be empty\n" +
                        "Password: Value is required and can't be empty\n" +
                        "Confirm Password: Value is required and can't be empty"}
        };
    }

    @Test(dataProvider = "createWithoutMandatoryData", groups = "medium")
    public void createPlayerWithoutMandatoryFields(String fname, String lname, String city, String phone, String expectedMsg) {
        PlayersPage playersPage = new PlayersPage(driver);
        playersPage.clickOnInsert();
        InsertPage insertPage = new InsertPage(driver);
        insertPage.open();
        Assert.assertEquals(driver.getTitle(), "Players - Insert", "Wrong title");
        insertPage.fillFName(fname);
        insertPage.fillLName(lname);
        insertPage.fillCity(city);
        insertPage.fillPhone(phone);
        insertPage.clickOnSave();
        String actualMsg = insertPage.getErrorMessage();
        Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
    }

    @AfterSuite
    public void afterTest() {
        driver.quit();
    }
}
