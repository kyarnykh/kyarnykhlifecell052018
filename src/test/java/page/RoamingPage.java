package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


    public String getPageTitle() {
        return pageTitle.getText();
    }

    public LegoRoamingPage clickOnLegoRoaming(WebDriver webDriver) {
        legoRoamingButton.click();
        return new LegoRoamingPage(webDriver);
    }
}
