import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Serhii on 23-Nov-16.
 */
public class LoginTests {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver(); // Open Firefox
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String URL = "http://80.92.229.236:81"; // Poker URL
        driver.get(URL + "/auth/login"); // Open Poker


        WebElement usernameInput = driver.findElement(By.id("username")); // Find username input
        usernameInput.sendKeys("admin"); // Set username

        WebElement passwordInput = driver.findElement(By.id("password")); // Find password input
        passwordInput.sendKeys("123"); // Set password

        WebElement loginButton = driver.findElement(By.id("logIn")); // Find login button
        loginButton.click(); // click on LogIn button

        String actualTitle = driver.getTitle();
        String expectedTitle = "Players1";

        assertText(actualTitle, expectedTitle); // Make assertions
        driver.quit(); // Close Browser

    }


    public static void assertText(String actualValue, String expectedValue) {
        if(actualValue.equals(expectedValue)) {
            System.out.println("Passed.");
        } else {
            System.err.println("Failed. Expected text is "
                    + expectedValue + ", but Actual title is " + actualValue);
        }
    }

}
