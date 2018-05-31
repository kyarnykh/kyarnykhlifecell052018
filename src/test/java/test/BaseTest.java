package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.HomePage;

/**
 * TestPage of BaseTest with main methods
 */
public abstract class BaseTest {

    public WebDriver webDriver;
    HomePage lifecellHomePage;


    /**
     * Method for each Test Class which extend this class
     * Start before each method by Test Classes
     * Initialisation WebDriver
     * Open web site
     * Initialisation page
     */
    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.lifecell.ua");
        lifecellHomePage = new HomePage(webDriver);
    }

    /**
     * Method for each Test Class which extend this class
     * Start after each method by Test Classes
     * Close WebDriver
     */
    @AfterMethod
    public void after() {
        webDriver.close();
    }

}
