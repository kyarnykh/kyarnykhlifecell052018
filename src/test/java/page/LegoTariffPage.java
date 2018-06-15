package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * PageObject of LegoTariffPage with methods and variables
 */
public class LegoTariffPage extends BasePage{

    @FindBy(xpath = "//*[@class='lego-cart__order js-order']")
    private WebElement orderLegoTariffButton;

    @FindBy(xpath = "//*[@group='OFFNET']")
    private WebElement sliderOffnet;

    @FindBy(xpath = "//*[@group='DATA']")
    private WebElement sliderGb;

    @FindBy(xpath = "//*[@group='SMS']")
    private WebElement sliderSms;

    @FindBy(xpath = "//*[@group='VK']")
    private WebElement selectorForSocialNetworks;

    @FindBy(xpath = "//*[@class='js-discount']")
    private WebElement getDiscountPrice;

    @FindBy(xpath = "//*[@class='js-total']")
    private WebElement getMonthlyFee;

    @FindBy(xpath = "//*[@tab='ANYNET']")
    private WebElement anynetButton;

    @FindBy(xpath = "//*[@group='ANYNET']")
    private WebElement sliderAnynet;




    /**
     * Constructor of LegoTariffPage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public LegoTariffPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Check webElement is displayed
     * @return - true
     */
    public boolean isPageLoaded() {
        orderLegoTariffButton.isDisplayed();
        return true;
    }

    /**
     * Method for choose amount minutes
     * @param minOffnet - minutes to other networks
     */
    public void chooseOffnet(int minOffnet) {
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", sliderOffnet);
        int width = sliderOffnet.getSize().getWidth();
        Actions move = new Actions(webDriver);
        move.moveToElement(sliderOffnet, ((width*minOffnet)/100), 0).click();
        move.build().perform();
    }

    /**
     * Method for choose amount gigabyte
     * @param gb - gigabyte for internet
     */
    public void chooseData(int gb) {
        int width = sliderGb.getSize().getWidth();
        Actions move = new Actions(webDriver);
        move.moveToElement(sliderGb, ((width*gb)/100), 0).click();
        move.build().perform();
    }

    /**
     * Method for choose amount sms
     * @param sms - sms
     */
    public void chooseSMS(int sms) {
        int width = sliderSms.getSize().getWidth();
        Actions move = new Actions(webDriver);
        move.moveToElement(sliderSms, ((width*sms)/100), 0).click();
        move.build().perform();
    }

    /**
     * Method for activate Social Networks
     * @param onOff - activate / NOT activate
     */
    public void switchSocialNetworks(int onOff) {
        if (onOff == 1) {
            selectorForSocialNetworks.click();
        } else {
            return;
        }
    }

    /**
     * Method for get price of discount
     * @return - amount of discount
     */
    public String getPriceOfDiscount() {
        return getDiscountPrice.getText();
    }

    /**
     * Method for get price of monthly fee
     * @return - amount of monthly fee
     */
    public String getPriceOfMonthlyFee() {
        return getMonthlyFee.getText();
    }

    /**
     * Method for scroll and click on Anynet tab
     */
    public void clickOnAnynetButton() {
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", anynetButton);
        anynetButton.click();
    }

    /**
     * Method for choose amount minutes
     * @param minAnynet - minutes to any networks
     */
    public void chooseAnynet(int minAnynet) {
        int width = sliderAnynet.getSize().getWidth();
        Actions move = new Actions(webDriver);
        move.moveToElement(sliderAnynet, ((width*minAnynet)/100), 0).click();
        move.build().perform();
    }
}
