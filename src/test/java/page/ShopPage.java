package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject of ShopPage with methods and variables
 */
public class ShopPage extends BasePage{

    @FindBy(xpath = "//a[@href='/uk/pristroyi/3g-zte-mf83m-ufi/']")
    private WebElement deviceButton;


    /**
     * Constructor of BasePage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public ShopPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Check if Page is loaded
     * @return current title
     */
    public String isPageLoaded() {
        return webDriver.getTitle();
    }

    /**
     * Click on the device
     * @param webDriver - current webDriver
     * @return next new Page
     */
    public DevicePage clickOnDevice(WebDriver webDriver) {
        deviceButton.click();
        return new DevicePage(webDriver);
    }
}
