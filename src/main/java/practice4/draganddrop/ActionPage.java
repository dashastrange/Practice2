package practice4.draganddrop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActionPage {

    @FindBy(xpath = "//*[@id = 'sortable']/li[1]")
    public WebElement sourceElement;

    @FindBy(xpath = "//*[@id='drop']")
    public WebElement targetElement;

    private WebDriver driver;
    private final static String URL = "file:///G:/Idea%20Community%20Projects/drag_and_drop2/index.html";

    ActionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(URL);
    }

    void dragAndDrop() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement, targetElement)
                .perform();
    }

    void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    void switchToMainPage() {
        driver.switchTo().defaultContent();
    }
}
