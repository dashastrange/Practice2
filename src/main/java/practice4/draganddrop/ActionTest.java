package practice4.draganddrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class ActionTest {

    private WebDriver driver;
    private ActionPage actionPage;
    private SoftAssert softAssert;

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actionPage = new ActionPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void dragAndDropTest() {
        actionPage.open();
        actionPage.dragAndDrop();
        softAssert.assertEquals(driver.switchTo().alert().getText(), "Are you sure that you want to delete?", "Wrong alert message");
        actionPage.dismissAlert();
        softAssert.assertFalse(driver.findElements(By.xpath("//*[@id='sortable']")).size() == 7, "Element deleted");
        actionPage.dragAndDrop();
        actionPage.acceptAlert();
        softAssert.assertFalse(driver.findElements(By.xpath("//*[@id='sortable']")).size() == 6, "Element not deleted");
        softAssert.assertAll();
        actionPage.switchToMainPage();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
