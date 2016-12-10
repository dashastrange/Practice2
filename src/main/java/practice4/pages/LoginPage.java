package practice4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public static final String URL = "http://80.92.229.236:81/auth/login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickOnLogin();
    }

    public void setUsername(String username) {
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void setPassword(String password) {
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickOnLogin() {
        WebElement loginButton = driver.findElement(By.id("logIn"));
        loginButton.click();
    }

    public String getErrorMessage() {
        WebElement errorMsgElement = driver.findElement(By.xpath("//ul[@class='errors']/li"));
        String errorMsg = errorMsgElement.getText();
        return errorMsg;
    }

    public String getErrorMessageUsername() {
        WebElement errorMsgElement = driver.findElement(By.xpath("//dd[@id='username-element']/ul/li"));
        String errorMsg = errorMsgElement.getText();
        return errorMsg;
    }

    public String getErrorMessagePassword() {
        WebElement errorMsgElement = driver.findElement(By.xpath("//dd[@id='password-element']/ul/li"));
        String errorMsg = errorMsgElement.getText();
        return errorMsg;
    }

}