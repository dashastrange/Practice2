package practice4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static practice2.PokerPlayer.generateRandomString;

public class EditPlayerPage {

    @FindBy(xpath = "//*[contains(@name, 'email')]")
    private WebElement emailChange;

    @FindBy(xpath = "//*[contains(@name, 'fname')]")
    private WebElement fNameChange;

    @FindBy(xpath = "//*[contains(@name, 'lname')]")
    private WebElement lNameChange;

    @FindBy(xpath = "//*[contains(@name, 'city')]")
    private WebElement cityChange;

    @FindBy(xpath = "//*[contains(@name, 'phone')]")
    private WebElement phoneChange;

    private WebDriver driver;

    private String for_email = generateRandomString(5);
    private String new_email = for_email + "@gmail.com";

    public EditPlayerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void fillEmail(String email) {
        emailChange.clear();
        emailChange.sendKeys(new_email);
    }

    public  void fillFName(String fname) {
        fNameChange.clear();
        fNameChange.sendKeys(fname);
    }

    public  void fillLName(String lname) {
        lNameChange.clear();
        lNameChange.sendKeys(lname);
    }

    public  void fillCity(String city) {
        cityChange.clear();
        cityChange.sendKeys(city);
    }

    public  void fillPhone(String phone) {
        phoneChange.clear();
        phoneChange.sendKeys(phone);
    }

}
