package practice3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static practice2.PokerPlayer.generateRandomString;

public class EditPlayerPage {

    private WebDriver driver;

    private String loginName = "dasha" + generateRandomString(5);
    private String email = loginName + "@gmail.com";
    private String for_email = generateRandomString(5);
    private String new_email = for_email + "@gmail.com";

    public EditPlayerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void assertFields() {
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@name, 'email')]")).getText(), email, "Invalid data");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@name, 'first')]")).getText(), "First Name", "Invalid data");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@name, 'lastname')]")).getText(), "Last Name", "Invalid data");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@name, 'city')]")).getText(), "LA", "Invalid data");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@name, 'phone')]")).getText(), "553535355", "Invalid data");
    }

    public void setFields() {
        WebElement emailChange = driver.findElement(By.xpath("/*//*[contains(@name, 'email')]"));
        emailChange.clear();
        emailChange.sendKeys(new_email);

        WebElement FNameChange = driver.findElement(By.xpath("/*//*[contains(@name, 'fname')]"));
        FNameChange.clear();
        String new_fname = "F Name";
        FNameChange.sendKeys(new_fname);

        WebElement LNameChange = driver.findElement(By.xpath("/*//*[contains(@name, 'lname')]"));
        LNameChange.clear();
        String new_lname = "L Name";
        LNameChange.sendKeys(new_lname);

        WebElement cityChange = driver.findElement(By.xpath("/*//*[contains(@name, 'city')]"));
        cityChange.clear();
        String new_city = "NY";
        cityChange.sendKeys(new_city);

        WebElement phoneChange = driver.findElement(By.xpath("/*//*[contains(@name, 'phone')]"));
        phoneChange.clear();
        String new_phone = "12345678";
        phoneChange.sendKeys(new_phone);

        WebElement saveAgainButton = driver.findElement(By.name("button_save"));
        saveAgainButton.click();

        WebElement editAgainButton = driver.findElement(By.xpath("//tr[last()]/td[1]/a"));
        editAgainButton.click();
    }

}
