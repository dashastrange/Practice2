package practice3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static practice2.PokerPlayer.generateRandomString;

public class EditPlayerPage {

    private WebDriver driver;

    private String for_email = generateRandomString(5);
    private String new_email = for_email + "@gmail.com";

    private String  loginName = generateRandomString(5);
    private String email = loginName + "@gmail.com";
    private String pass = "111111";

    public EditPlayerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void assertFields() {
        /*assertEquals(driver.findElement(By.xpath("/*//*[contains(@name, 'email')]")).getText(), email);
        assertEquals(driver.findElement(By.xpath("/*//*[contains(@name, 'fname')]")).getText(),"First Name");
        assertEquals(driver.findElement(By.xpath("/*//*[contains(@name, 'lname')]")).getText(), "Last Name");
        assertEquals(driver.findElement(By.xpath("/*//*[contains(@name, 'city')]")).getText(), "LA");
        assertEquals(driver.findElement(By.xpath("/*//*[contains(@name, 'phone')]")).getText(), "553535355");*/
        WebElement emailField = driver.findElement(By.xpath("/*//*[contains(@name, 'email')]"));
        String actualValue = emailField.getAttribute("value");
        String expectedValue = email;

        assertValue(actualValue, expectedValue);

        WebElement fnameField = driver.findElement(By.xpath("/*//*[contains(@name, 'fname')]"));
        String actualFNameValue = fnameField.getAttribute("value");
        String fname = "First Name";
        String expectedFNameValue = fname;

        assertValue(actualFNameValue, expectedFNameValue);

        WebElement lnameField = driver.findElement(By.xpath("/*//*[contains(@name, 'lname')]"));
        String actualLNameValue = lnameField.getAttribute("value");
        String lname = "Last Name";
        String expectedLNameValue = lname;

        assertValue(actualLNameValue, expectedLNameValue);

        WebElement cityField = driver.findElement(By.xpath("/*//*[contains(@name, 'city')]"));
        String actualCityValue = cityField.getAttribute("value");
        String city = "LA";
        String expectedCityValue = city;

        assertValue(actualCityValue, expectedCityValue);

        WebElement phoneField = driver.findElement(By.xpath("/*//*[contains(@name, 'phone')]"));
        String actualPhoneValue = phoneField.getAttribute("value");
        String phone = "553535355";
        String expectedPhoneValue = phone;

        assertValue(actualPhoneValue, expectedPhoneValue);
    }

    public static void assertValue(String actualValue, String expectedValue) {
        if (actualValue.equals(expectedValue)) {
            System.out.println("Passed.");
        } else {
            System.err.println("Failed. Expected text is "
                    + expectedValue + ", but Actual text is " + actualValue);
        }

    }

    public void setFields() {
        WebElement emailChange = driver.findElement(By.xpath("//*[contains(@name, 'email')]"));
        emailChange.clear();
        emailChange.sendKeys(new_email);

        WebElement FNameChange = driver.findElement(By.xpath("//*[contains(@name, 'fname')]"));
        FNameChange.clear();
        String new_fname = "F Name";
        FNameChange.sendKeys(new_fname);

        WebElement LNameChange = driver.findElement(By.xpath("//*[contains(@name, 'lname')]"));
        LNameChange.clear();
        String new_lname = "L Name";
        LNameChange.sendKeys(new_lname);

        WebElement cityChange = driver.findElement(By.xpath("//*[contains(@name, 'city')]"));
        cityChange.clear();
        String new_city = "NY";
        cityChange.sendKeys(new_city);

        WebElement phoneChange = driver.findElement(By.xpath("//*[contains(@name, 'phone')]"));
        phoneChange.clear();
        String new_phone = "12345678";
        phoneChange.sendKeys(new_phone);

        WebElement saveAgainButton = driver.findElement(By.name("button_save"));
        saveAgainButton.click();
    }

    //TODO
    public String getErrorMessage() {
        WebElement errorMsgElement = driver.findElement(By.xpath("//ul[@class='errors']/li"));
        String errorMsg = errorMsgElement.getText();
        return errorMsg;
    }

}
