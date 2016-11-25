import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginTests {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver(); // Open Firefox
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String URL = "http://80.92.229.236:81"; // Poker URL
        driver.get(URL + "/auth/login"); // Open Poker
        String loginName = generateRandomString(5); //generate random player name
        String actualTitle = driver.getTitle();
        String expectedTitle = "Players";

        WebElement usernameInput = driver.findElement(By.id("username")); // Find username input
        usernameInput.sendKeys("admin"); // Set username

        WebElement passwordInput = driver.findElement(By.id("password")); // Find password input
        passwordInput.sendKeys("123"); // Set password

        WebElement loginButton = driver.findElement(By.id("logIn")); // Find login button
        loginButton.click(); // click on LogIn button

        assertText(actualTitle, expectedTitle); // Make assertions

//TODO Insert player part

        WebElement insertButton = driver.findElement(By.linkText("Insert"));
        insertButton.click();

        WebElement loginInput = driver.findElement(By.xpath("//*[contains(@name, 'login')]"));
        loginInput.sendKeys(loginName);

        WebElement emailInput = driver.findElement(By.xpath("//*[contains(@name, 'email')]"));
        emailInput.sendKeys(loginName + "@gmail.com");

        WebElement passInput = driver.findElement(By.xpath("//*[contains(@name, 'password')]"));
        passInput.sendKeys("111111");

        WebElement confPassInput = driver.findElement(By.xpath("//*[contains(@name, 'confirm')]"));
        confPassInput.sendKeys("111111");

        WebElement FNameInput = driver.findElement(By.xpath("//*[contains(@name, 'fname')]"));
        FNameInput.sendKeys("First Name");

        WebElement LNameInput = driver.findElement(By.xpath("//*[contains(@name, 'lname')]"));
        LNameInput.sendKeys("Last Name");

        WebElement cityInput = driver.findElement(By.xpath("//*[contains(@name, 'city')]"));
        cityInput.sendKeys("LA");

        WebElement phoneInput = driver.findElement(By.xpath("//*[contains(@name, 'phone')]"));
        phoneInput.sendKeys("5553335353");

        WebElement saveButton = driver.findElement(By.name("button_save"));
        saveButton.click();

        assertText(actualTitle, expectedTitle);
        driver.close();
        driver.quit(); // Close Browser

    }

    public static String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static void assertText(String actualValue, String expectedValue) {
        if (actualValue.equals(expectedValue)) {
            System.out.println("Passed.");
        } else {
            System.err.println("Failed. Expected text is "
                    + expectedValue + ", but Actual title is " + actualValue);
        }
    }

}
