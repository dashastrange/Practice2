package practice3.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import practice3.pages.EditPlayerPage;
import practice3.pages.InsertPage;
import practice3.pages.LoginPage;
import practice3.pages.PlayersPage;

import java.util.concurrent.TimeUnit;

public class CRUDUserTests {

    private WebDriver driver;
    private PlayersPage playersPage;

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.open();
        loginPage.login("admin", "123");
        playersPage = new PlayersPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        playersPage.open();
    }

    /**
     * 1. Click Insert
     * 2. Wait for Player - Insert page to open
     * 3. Verify that we are on the Players - Insert page now
     * 4. Filll fields with data
     * 5. Click Save
     */
    @Test
    public void createPlayerTest() {
        playersPage.clickOnInsert();
        InsertPage insertPage = new InsertPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        insertPage.open();
        Assert.assertEquals(driver.getTitle(), "Players - Insert", "Wrong title");
        insertPage.fillFields();
        insertPage.clickOnSave();
    }

    /**
     * 1. Enter login substring in Login field
     * 2. Click Search
     * 3. Click Edit icon
     * 4. Wait for Player - Edit page to load
     * 5. Verify players data is on the fields
     */
    @Test
    public void searchAndOpenForEditTest() {
        playersPage.searchPlayer();
        playersPage.clickOnSearch();
        playersPage.clickOnEdit();
        EditPlayerPage editPlayerPage = new EditPlayerPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        editPlayerPage.assertFields();
    }

    /**
     * 1. Enter login substring in Login field
     * 2. Click Search
     * 3. Click Edit icon
     * 4. Wait for Player - Edit page to load
     * 5. Fill fields with data
     */
    @Test
    public void editFields() {
        playersPage.searchPlayer();
        playersPage.clickOnSearch();
        playersPage.clickOnEdit();
        EditPlayerPage editPlayerPage = new EditPlayerPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        editPlayerPage.setFields();
    }

    /**
     * 1. Enter login substring in Login field
     * 2. Click Search
     * 3. Click on Delete icon
     * 4. Wait for alert pop up to display
     * 5. Click OK
     */
    @Test
    public void deletePlayer() {
        playersPage.searchPlayer();
        playersPage.clickOnSearch();
        playersPage.clickOnDelete();
        WebDriverWait wait = new WebDriverWait(driver, 15, 100);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    /**
     * 1. Click Insert
     * 2. Enter data in the First Name field
     * 3. Enter data in the Last Name field
     * 4. Enter data in the City field
     * 5. Enter data in the Phone field
     * 6. Click Save
     * 7. Verify that right error messages displays
     */
    @Test
    public void createPlayerWithoutMandatoryFields() {
        playersPage.clickOnInsert();
        InsertPage insertPage = new InsertPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        insertPage.open();
        Assert.assertEquals(driver.getTitle(), "Players - Insert", "Wrong title");
        insertPage.setFieldsExceptMandatory();
        insertPage.clickOnSave();
        String expectedMsg = "Following errors have been occured:\n" +
                "Username: Value is required and can't be empty\n" +
                "E-mail: Value is required and can't be empty\n" +
                "Password: Value is required and can't be empty\n" +
                "Confirm Password: Value is required and can't be empty";
        String actualMsg = insertPage.getErrorMessage();
        Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
