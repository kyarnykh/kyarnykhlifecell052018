package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.HomePage;

public abstract class BaseTest {

    public WebDriver webDriver;
    HomePage lifecellHomePage;


    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.lifecell.ua");
        lifecellHomePage = new HomePage(webDriver);
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }

}
