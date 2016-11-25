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
        String email = loginName + "@gmal.com";

        WebElement usernameInput = driver.findElement(By.id("username")); // Find username input
        usernameInput.sendKeys("admin"); // Set username

        WebElement passwordInput = driver.findElement(By.id("password")); // Find password input
        passwordInput.sendKeys("123"); // Set password

        WebElement loginButton = driver.findElement(By.id("logIn")); // Find login button
        loginButton.click(); // click on LogIn button

//TODO Insert player part

        WebElement insertButton = driver.findElement(By.linkText("Insert"));
        insertButton.click();

        WebElement loginInput = driver.findElement(By.xpath("//*[contains(@name, 'login')]"));
        loginInput.sendKeys(loginName);

        WebElement emailInput = driver.findElement(By.xpath("//*[contains(@name, 'email')]"));
        emailInput.sendKeys(email);

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

        String actualTitle = driver.getTitle();
        String expectedTitle = "Players";

        assertText(actualTitle, expectedTitle);

//TODO  Find and assert
        WebElement searchInput = driver.findElement(By.xpath("//*[contains(@name, 'login') and not(@class)]"));
        searchInput.sendKeys(loginName);

        WebElement searchButton = driver.findElement(By.name("search"));
        searchButton.click();

        WebElement editButton = driver.findElement(By.xpath("//tr[last()]/td[1]/a"));
        //.//tr[.//a[text()=' " + loginName + " ']]//img[@title='Edit']
        editButton.click();

        WebElement emailField = driver.findElement(By.xpath("//*[contains(@name, 'email')]"));
        String actualValue = emailField.getAttribute("value");
        String expectedValue = email;
        assertValue(actualValue, expectedValue);

        WebElement fnameField = driver.findElement(By.xpath("//*[contains(@name, 'fname')]"));
        String actualFNameValue = fnameField.getAttribute("value");
        String expectedFNameValue = "First Name";
        assertValue(actualFNameValue, expectedFNameValue);

        WebElement lnameField = driver.findElement(By.xpath("//*[contains(@name, 'lname')]"));
        String actualLNameValue = lnameField.getAttribute("value");
        String expectedLNameValue = "Last Name";
        assertValue(actualLNameValue, expectedLNameValue);

        WebElement cityField = driver.findElement(By.xpath("//*[contains(@name, 'city')]"));
        String actualCityValue = cityField.getAttribute("value");
        String expectedCityValue = "LA";
        assertValue(actualCityValue, expectedCityValue);

        WebElement phoneField = driver.findElement(By.xpath("//*[contains(@name, 'phone')]"));
        String actualPhoneValue = phoneField.getAttribute("value");
        String expectedPhoneValue = "5553335353";
        assertValue(actualPhoneValue, expectedPhoneValue);

        //TODO Change and save
        String for_email = generateRandomString(5),
               new_email = for_email + "@gmail.com",
               new_fname = "F Name",
               new_lname = "L Nmae",
               new_city = "NY",
               new_phone = "12345678";


        WebElement emailChange = driver.findElement(By.xpath("//*[contains(@name, 'email')]"));
        emailChange.clear();
        emailChange.sendKeys(new_email);

        WebElement FNameChange = driver.findElement(By.xpath("//*[contains(@name, 'fname')]"));
        FNameChange.clear();
        FNameChange.sendKeys(new_fname);

        WebElement LNameChange = driver.findElement(By.xpath("//*[contains(@name, 'lname')]"));
        LNameChange.clear();
        LNameChange.sendKeys(new_lname);

        WebElement cityChange = driver.findElement(By.xpath("//*[contains(@name, 'city')]"));
        cityChange.clear();
        cityChange.sendKeys(new_city);

        WebElement phoneChange = driver.findElement(By.xpath("//*[contains(@name, 'phone')]"));
        phoneChange.clear();
        phoneChange.sendKeys(new_phone);

        WebElement saveAgainButton = driver.findElement(By.name("button_save"));
        saveAgainButton.click();

        WebElement editAgainButton = driver.findElement(By.xpath("//tr[last()]/td[1]/a"));
        editAgainButton.click();

        //TODO Changes is saved last time
        WebElement email_assert_Field = driver.findElement(By.xpath("//*[contains(@name, 'email')]"));
        String actualValue2 = email_assert_Field.getAttribute("value");
        String expectedValue2 = new_email;
        assertValue(actualValue2, expectedValue2);

        WebElement fname_assert_Field = driver.findElement(By.xpath("//*[contains(@name, 'fname')]"));
        String actualFNameValue2 = fname_assert_Field.getAttribute("value");
        String expectedFNameValue2 = new_fname;
        assertValue(actualFNameValue2, expectedFNameValue2);

        WebElement lname_assert_Field = driver.findElement(By.xpath("//*[contains(@name, 'lname')]"));
        String actualLNameValue2 = lname_assert_Field.getAttribute("value");
        String expectedLNameValue2 = new_lname;
        assertValue(actualLNameValue2, expectedLNameValue2);

        WebElement city_assert_Field = driver.findElement(By.xpath("//*[contains(@name, 'city')]"));
        String actualCityValue2 = city_assert_Field.getAttribute("value");
        String expectedCityValue2 = new_city;
        assertValue(actualCityValue2, expectedCityValue2);

        WebElement phone_assert_Field = driver.findElement(By.xpath("//*[contains(@name, 'phone')]"));
        String actualPhoneValue2 = phone_assert_Field.getAttribute("value");
        String expectedPhoneValue2 = new_phone;
        assertValue(actualPhoneValue2, expectedPhoneValue2);

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

    public static void assertValue(String actualValue, String expectedValue) {
        if (actualValue.equals(expectedValue)) {
            System.out.println("Passed.");
        } else {
            System.err.println("Failed. Expected text is "
                    + expectedValue + ", but Actual text is " + actualValue);
        }
    }

}
