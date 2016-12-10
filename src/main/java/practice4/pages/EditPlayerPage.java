package practice4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static practice2.PokerPlayer.generateRandomString;

public class EditPlayerPage {

    private WebDriver driver;

    private String for_email = generateRandomString(5);
    private String new_email = for_email + "@gmail.com";

    public EditPlayerPage(WebDriver driver) {
        this.driver = driver;
    }

    public  void fillEmail(String email) {
        WebElement emailChange = driver.findElement(By.xpath("//*[contains(@name, 'email')]"));
        emailChange.clear();
        emailChange.sendKeys(new_email);
    }

    public  void fillFName(String fname) {
        WebElement FNameChange = driver.findElement(By.xpath("//*[contains(@name, 'fname')]"));
        FNameChange.clear();
        FNameChange.sendKeys(fname);
    }

    public  void fillLName(String lname) {
        WebElement FNameChange = driver.findElement(By.xpath("//*[contains(@name, 'lname')]"));
        FNameChange.clear();
        FNameChange.sendKeys(lname);
    }

    public  void fillCity(String city) {
        WebElement FNameChange = driver.findElement(By.xpath("//*[contains(@name, 'city')]"));
        FNameChange.clear();
        FNameChange.sendKeys(city);
    }

    public  void fillPhone(String phone) {
        WebElement FNameChange = driver.findElement(By.xpath("//*[contains(@name, 'phone')]"));
        FNameChange.clear();
        FNameChange.sendKeys(phone);
    }

}
