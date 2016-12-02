package practice3.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import practice3.pages.InsertPage;
import practice3.pages.LoginPage;
import practice3.pages.PlayersPage;

import java.util.concurrent.TimeUnit;

public class CRUDUserTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private PlayersPage playersPage;
    private InsertPage insertPage;

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.open();
        loginPage.login("admin", "123");
        playersPage = new PlayersPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        playersPage.open();
    }

    @Test
    public void createPlayerTest() {
        playersPage.clickOnInsert();
        InsertPage insertPage = new InsertPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        insertPage.open();
        insertPage.fillFields();
        insertPage.clickOnSave();
    }

    @AfterTest
    public void afterTest() {
        //close browser
        driver.quit();
    }
}
