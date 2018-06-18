package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
     * PageObject of BasePage with the main methods
     */
public abstract class BasePage {
    protected WebDriver webDriver;


    /**
         * Constructor of BasePage class
         * @param webDriver - current webDriver object
         */
    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    /**
         * Method for wait some webElement
         * @param webElement - current webDriver object
         * @param timeOutInSeconds - time for wait
         * @return
         */
    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

}

