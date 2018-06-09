package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject of PayPage with methods and variables
 */
public class PayPage extends BasePage{

    @FindBy(xpath = "//*[@id='buttonPay']")
    private WebElement deviceButton;


    /**
     * Constructor of BasePage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public PayPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Check Page is loaded
     * @return current url
     */
    public String isPageLoaded() {
        waitUntilElementIsClickable(deviceButton, 15);
        return webDriver.getCurrentUrl();
    }

}
