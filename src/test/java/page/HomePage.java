package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject of HomePage with methods and variables
 */
public class HomePage {

    WebDriver webDriver;

    @FindBy(xpath = "//div[3]/ul/li[5]")
    private WebElement customerServiceButton;


    /**
     * Constructor of HomePage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Check if Page is loaded
     * @return text of title
     */
    public String getCurrentTittle(){
        return webDriver.getTitle();
    }

    /**
     * Method for click on the button
     * @return next new Page
     */
    public CustomerServiceCentersPage clickCustomerServiceButton() {
        customerServiceButton.click();
        return new CustomerServiceCentersPage(webDriver);
    }


}
