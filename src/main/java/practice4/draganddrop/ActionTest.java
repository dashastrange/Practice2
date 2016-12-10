package practice4.draganddrop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Serhii on 07-Dec-16.
 */
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
        /*todo
        1. Open page.
        2. Perform drag and drop.
        2. Check text and class attribute.
         */
        actionPage.open();
        actionPage.switchToFrame();
        actionPage.dragAndDrop();
        softAssert.assertTrue(actionPage.isDropped(), "Drag and drop failed.");
        softAssert.assertEquals(actionPage.getTargetText(), "Dropped!", "Wrong text in target.");
        //actionPage.switchToMainPage();
        softAssert.assertAll();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
