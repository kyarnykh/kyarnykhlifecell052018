package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject of TariffsPlanPage with methods and variables
 */
public class TariffsPlanPage extends BasePage {

    @FindBy(xpath = "//a[@href='/uk/mobilnij-zvyazok/taryfy/zroby_sam/']")
    private WebElement legoTariffButton;

    @FindBy(xpath = "//*[@class='page-title']")
    private WebElement pageTitle;

    /**
     * Constructor of TariffsPlanPage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public TariffsPlanPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Methods for received current title
     * @return - page tittle
     */
    public String getPageTitle() {
        return pageTitle.getText();
    }

    /**
     * Methods for click on Lego tariff button
     * @param webDriver - current webDriver
     * @return - new next Page
     */
    public LegoTariffPage clickOnLegoTariff(WebDriver webDriver) {
        legoTariffButton.click();
        return new LegoTariffPage(webDriver);
    }
}
