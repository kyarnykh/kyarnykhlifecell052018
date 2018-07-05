package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.HomePage;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * TestPage of BaseTest with main methods
 */
public abstract class BaseTest {

    public WebDriver webDriver;
    HomePage homePage;


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
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.lifecell.ua");
        homePage = new HomePage(webDriver);
        Assert.assertEquals(homePage.getCurrentTittle(), "Мобільний зв'язок lifecell - lifecell Україна",
                "Home page is wrong");
    }

    /**
     * Method for each Test Class which extend this class
     * Close WebDriver
     */
    @AfterMethod
    public void after() {
        webDriver.close();
    }

    public void WebDriverSleep (int timeOutInMillis) throws InterruptedException {
        System.out.println("WebDriver starts to sleep for "+timeOutInMillis+" millis");
        sleep (timeOutInMillis);
    }

}
