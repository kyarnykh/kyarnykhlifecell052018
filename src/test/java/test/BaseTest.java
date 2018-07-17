package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.HomePage;

import java.util.concurrent.TimeUnit;


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
    @Parameters("browser")
    @BeforeMethod
    public void before(@Optional("firefox") String browser) {
        if(browser.equals("firefox")) {
            webDriver = new FirefoxDriver();
        }
        else if(browser.equals("chrome")) {
            webDriver = new ChromeDriver();
        }

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
        if(webDriver != null)
        webDriver.close();
    }

    /**
     * Method waiting for each JQuery scripts when will be ended
     */
    public void waitForJQueryEnds() {
        while ((Boolean) ((JavascriptExecutor) webDriver).executeScript("return jQuery.active!=0")) {
        }
    }

}
