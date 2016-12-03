package practice3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static practice2.PokerPlayer.generateRandomString;

public class InsertPage {
    private WebDriver driver;

    private static final String URL_INS = "http://80.92.229.236:81/players/insert";

    public InsertPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() { driver.get(URL_INS); }

    private String loginName =  "dasha" + generateRandomString(5);
    private String email = loginName + "@gmail.com";

    public void fillFields() {
        WebElement loginInput = driver.findElement(By.xpath("/*//*[contains(@name, 'login')]"));
        loginInput.sendKeys(loginName);

        WebElement emailInput = driver.findElement(By.xpath("/*//*[contains(@name, 'email')]"));
        emailInput.sendKeys(email);

        WebElement passInput = driver.findElement(By.xpath("/*//*[contains(@name, 'password')]"));
        String password = "111111";
        passInput.sendKeys(password);

        WebElement confPassInput = driver.findElement(By.xpath("/*//*[contains(@name, 'confirm')]"));
        confPassInput.sendKeys(password);

        WebElement FNameInput = driver.findElement(By.xpath("/*//*[contains(@name, 'fname')]"));
        String fname = "First Name";
        FNameInput.sendKeys(fname);

        WebElement LNameInput = driver.findElement(By.xpath("/*//*[contains(@name, 'lname')]"));
        String lname = "Last Name";
        LNameInput.sendKeys(lname);

        WebElement cityInput = driver.findElement(By.xpath("/*//*[contains(@name, 'city')]"));
        String city = "LA";
        cityInput.sendKeys(city);

        WebElement phoneInput = driver.findElement(By.xpath("/*//*[contains(@name, 'phone')]"));
        String phone = "553535355";
        phoneInput.sendKeys(phone);
    }

    public void setFieldsExceptMandatory() {
        WebElement FNameInput = driver.findElement(By.xpath("/*//*[contains(@name, 'fname')]"));
        String fname = "First Name";
        FNameInput.sendKeys(fname);

        WebElement LNameInput = driver.findElement(By.xpath("/*//*[contains(@name, 'lname')]"));
        String lname = "Last Name";
        LNameInput.sendKeys(lname);

        WebElement cityInput = driver.findElement(By.xpath("/*//*[contains(@name, 'city')]"));
        String city = "LA";
        cityInput.sendKeys(city);

        WebElement phoneInput = driver.findElement(By.xpath("/*//*[contains(@name, 'phone')]"));
        String phone = "553535355";
        phoneInput.sendKeys(phone);
    }

    public void clickOnSave() {
        WebElement saveButton = driver.findElement(By.name("button_save"));
        saveButton.click();
    }

    public String getErrorMessage() {
        WebElement errorMsgElement = driver.findElement(By.xpath("//*[contains(@class, 'errors_container')]"));
        String errorMsg = errorMsgElement.getText();
        return errorMsg;
    }


}
