package practice4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InsertPage {

    private WebDriver driver;

    private static final String URL_INS = "http://80.92.229.236:81/players/insert";

    public InsertPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() { driver.get(URL_INS); }

    public void fillLogin(String loginName) {
        WebElement loginInput = driver.findElement(By.xpath("/*//*[contains(@name, 'login')]"));
        loginInput.sendKeys(loginName);
    }

    public void fillEmail(String email) {
        WebElement emailInput = driver.findElement(By.xpath("/*//*[contains(@name, 'email')]"));
        emailInput.sendKeys(email);
    }

    public void fillPass(String pass) {
        WebElement passInput = driver.findElement(By.xpath("/*//*[contains(@name, 'password')]"));
        passInput.sendKeys(pass);
    }

    public void fillConfPass(String conf_pass) {
        WebElement confPassInput = driver.findElement(By.xpath("/*//*[contains(@name, 'confirm')]"));
        confPassInput.sendKeys(conf_pass);
    }

    public void fillFName(String fname) {
        WebElement FNameInput = driver.findElement(By.xpath("/*//*[contains(@name, 'fname')]"));
        FNameInput.sendKeys(fname);
    }

    public void fillLName(String lname) {
        WebElement LNameInput = driver.findElement(By.xpath("/*//*[contains(@name, 'lname')]"));
        LNameInput.sendKeys(lname);
    }

    public void fillCity(String city) {
        WebElement cityInput = driver.findElement(By.xpath("/*//*[contains(@name, 'city')]"));
        cityInput.sendKeys(city);
    }

    public void fillPhone(String phone) {
        WebElement phoneInput = driver.findElement(By.xpath("/*//*[contains(@name, 'phone')]"));
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
