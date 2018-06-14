package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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



    /**
     * Constructor of LegoTariffPage class
     * @param webDriver - current webDriver object
     */
    public LegoTariffPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        orderLegoTariffButton.isDisplayed();
        return true;
    }

    public void chooseOffnet(int minOffnet) {
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", sliderOffnet);
        int width = sliderOffnet.getSize().getWidth();
        Actions move = new Actions(webDriver);
        move.moveToElement(sliderOffnet, ((width*minOffnet)/100), 0).click();
        move.build().perform();
    }

    public void chooseData(int gb) {
        int width = sliderGb.getSize().getWidth();
        Actions move = new Actions(webDriver);
        move.moveToElement(sliderGb, ((width*gb)/100), 0).click();
        move.build().perform();
    }

    public void chooseSMS(int sms) {
        int width = sliderSms.getSize().getWidth();
        Actions move = new Actions(webDriver);
        move.moveToElement(sliderSms, ((width*sms)/100), 0).click();
        move.build().perform();
    }

    public void switchSocialNetworks(int onOff) {
        if (onOff == 1) {
            selectorForSocialNetworks.click();
        } else {
            return;
        }
    }

    public String matchDiscountPrice() {
        return getDiscountPrice.getText();
    }

    public String matchMonthlyFeePrice() {
        return getMonthlyFee.getText();
    }
}
