package practice4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PlayersPage {
    private static final String URL_PLAYERS = "http://80.92.229.236:81/players";

    private WebDriver driver;

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

    public void assertIsFieldsEmpty() {
        Assert.assertFalse(driver.findElements(By.xpath("//tr[not(@id='r_title')]")).size() == 0, "Players list is empty.");
    }

    public void assertIsPlayerListNotEmpty() {
        Assert.assertTrue(driver.findElements(By.xpath("//tr[not(@id='r_title')]")).size() > 0, "Players list is not empty.");
    }

    public void fillFieldsForReset() {
        WebElement loginField = driver.findElement(By.xpath("//*[contains(@name, 'login') and not(@class)]"));
        loginField.sendKeys("lllooogggiiinnn");
    }

    public void fillFieldsForSearchEmail() {
        WebElement loginField = driver.findElement(By.xpath("//*[contains(@name, 'email')]"));
        loginField.sendKeys("test@gmail.com");
    }

    public void fillFieldsForSearchCity() {
        WebElement loginField = driver.findElement(By.xpath("//*[contains(@name, 'city')]"));
        loginField.sendKeys("LA");
    }

    public void fillFieldsForRegDateFrom() {
        WebElement loginField = driver.findElement(By.xpath("//*[contains(@name, 'date_from')]"));
        loginField.sendKeys("4-01-2014");
    }

    public void fillFieldsForRegDateTo() {
        WebElement loginField = driver.findElement(By.xpath("//*[contains(@name, 'date_to')]"));
        loginField.sendKeys("4-11-2014");
    }

    public void fillFieldsForSearchFName() {
        WebElement loginField = driver.findElement(By.xpath("//*[contains(@name, 'firstname')]"));
        loginField.sendKeys("First Name");
    }

    public void fillFieldsForSearchLName() {
        WebElement loginField = driver.findElement(By.xpath("//*[contains(@name, 'lastname')]"));
        loginField.sendKeys("Last Name");
    }

    public void fillFieldsForSearchLastLogin() {
        WebElement loginField = driver.findElement(By.xpath("//*[contains(@name, 'last_login')]"));
        loginField.sendKeys("10-31-2012");
    }

    public void fillFieldsForSearchByMac() {
        WebElement loginField = driver.findElement(By.xpath("//*[contains(@name, 'mac')]"));
        loginField.sendKeys("00:00:00:00");
    }


    public void searchPlayer() {
        WebElement searchInput = driver.findElement(By.xpath("//*[contains(@name, 'login') and not(@class)]"));
        searchInput.sendKeys("dasha");
    }

    public void clickOnInsert() {
        WebElement insert = driver.findElement(By.linkText("Insert"));
        insert.click();
    }

    public void clickOnSearch() {
        WebElement searchButton = driver.findElement(By.name("search"));
        searchButton.click();
    }

    public void clickOnEdit() {
        WebElement editButton = driver.findElement(By.xpath("//tr[last()]/td[1]/a"));
        editButton.click();
    }

    public void clickOnDelete() {
        WebElement editButton = driver.findElement(By.xpath("//tr[last()]/td[last()]/a"));
        editButton.click();
    }
}
