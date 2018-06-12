package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TariffsPlanPage extends BasePage {

    @FindBy(xpath = "//a[@href='/uk/mobilnij-zvyazok/taryfy/zroby_sam/']")
    private WebElement legoTariffButton;

    /**
     * Constructor of TariffsPlanPage class
     * @param webDriver - current webDriver object
     */
    public TariffsPlanPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    public String getCurrentTitle() {
        return webDriver.getTitle();
    }

    public LegoTariffPage clickOnLegoTariff(WebDriver webDriver) {
        legoTariffButton.click();
        return new LegoTariffPage(webDriver);
    }
}
