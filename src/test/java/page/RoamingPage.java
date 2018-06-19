package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject of RoamingPage with methods and variables
 */
public class RoamingPage extends BasePage{

    @FindBy(xpath = "//*[@class='page-title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//a[@href='/uk/mobilnij-zvyazok/roaming/rouming-pazl/']")
    private WebElement legoRoamingButton;


    /**
     * Constructor of RoamingPage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public RoamingPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Method for return title
     * @return - current title
     */
    public String getPageTitle() {
        return pageTitle.getText();
    }

    /**
     * Method for click on Lego Roaming
     * @param webDriver - current WebDriver
     * @return - new next Page
     */
    public LegoRoamingPage clickOnLegoRoaming(WebDriver webDriver) {
        legoRoamingButton.click();
        return new LegoRoamingPage(webDriver);
    }
}
