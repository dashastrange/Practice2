package practice3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static practice2.PokerPlayer.generateRandomString;

public class PlayersPage {
    public static final String URL_PLAYERS = "http://80.92.229.236:81/players";
    private String  loginName = generateRandomString(5);
    private String email = loginName + "@gmail.com";

    private WebDriver driver;
    private InsertPage insertPage;

    public PlayersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL_PLAYERS);
    }

    public void clickOnReset() {
        WebElement resetButton = driver.findElement(By.name("reset"));
        resetButton.click();
    }

    public void assertIsFieldsEmpty () {
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@name, 'login') and not(@class)]")).getText(), "", "Field is not empty");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@name, 'email')]")).getText(), "", "Field is not empty");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@name, 'city')]")).getText(), "", "Field is not empty");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@name, 'date_from')]")).getText(), "", "Field is not empty");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@name, 'date_to')]")).getText(), "", "Field is not empty");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@name, 'ip_address')]")).getText(), "", "Field is not empty");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@name, 'mac_address')]")).getText(), "", "Field is not empty");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@name, 'first')]")).getText(), "", "Field is not empty");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@name, 'lastname')]")).getText(), "", "Field is not empty");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@name, 'last_login')]")).getText(), "", "Field is not empty");
    }

    public void fillFieldsForReset() {
        WebElement loginField = driver.findElement(By.xpath("//*[contains(@name, 'login') and not(@class)]"));
        loginField.sendKeys("lllooogggiiinnn");
    }

    public void searchPlayer() {
        WebElement searchInput = driver.findElement(By.xpath("/*//*[contains(@name, 'login') and not(@class)]"));
        searchInput.sendKeys(loginName);
    }

    public void clickOnInsert() {
        WebElement insert = driver.findElement(By.linkText("Insert"));
        insert.click();
    }

    public void clickOnSearch() {
        WebElement searchButton = driver.findElement(By.name("search"));
        searchButton.click();
    }
}
