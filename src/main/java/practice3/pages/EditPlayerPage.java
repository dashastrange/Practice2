package practice3.pages;

import org.openqa.selenium.WebDriver;

public class EditPlayerPage {

    private WebDriver driver;
    private InsertPage insertPage;

    public static final String URL = "http://80.92.229.236:81/players";

    public EditPlayerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() { driver.get(URL); }


}
