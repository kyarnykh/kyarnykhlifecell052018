package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import page.LifecellHomePage;

public abstract class LifecellBaseTest {

    public WebDriver webDriver;
    LifecellHomePage lifecellHomePage;


    @BeforeClass
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.lifecell.ua");
        lifecellHomePage = new LifecellHomePage(webDriver);
    }

    @AfterClass
    public void after() {
        webDriver.close();
    }

}
