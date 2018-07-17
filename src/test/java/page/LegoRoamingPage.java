package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * PageObject of LegoRoamingPage with methods and variables
 */
public class LegoRoamingPage extends BasePage {

    @FindBy(xpath = "//*[@class='form-element__input js-lego-roaming-search-input ui-autocomplete-input']")
    private WebElement fieldCountry;

    @FindBy(xpath = "//*[@class='ui-menu-item']")
    private WebElement dropdownListCountries;

    @FindBy(xpath = "//*[@group='DAYS']")
    private WebElement sliderDays;

    @FindBy(xpath = "//*[@group='DATA']")
    private WebElement sliderGb;

    @FindBy(xpath = "//*[@group='VOICE']")
    private WebElement sliderMinutes;

    @FindBy(xpath = "//*[@group='SMS']")
    private WebElement sliderSms;

    @FindBy(xpath = "//*[@class='lego-cart__order js-order']")
    private WebElement orderButton;

    @FindBy(xpath = "//*[@class='js-total']")
    private WebElement getPrice;


    /**
     * Constructor of LegoRoamingPage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public LegoRoamingPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method for return title
     * @return - current title
     */
    public String getCurrentTitle() {
        return webDriver.getTitle();
    }

    /**
     * Method for scroll and insert country
     * @param country - country of stay
     */
    public void insertCountry(String country) {
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", fieldCountry);
        fieldCountry.sendKeys(country);
        dropdownListCountries.click();
    }

    /**
     * Method for choose quantity days
     * @param days - quantity days
     */
    public void chooseDays(int days) {
        int width = sliderDays.getSize().getWidth();
        Actions move = new Actions(webDriver);
        move.moveToElement(sliderDays, ((width*days)/100), 0).click();
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
     * Method for choose amount minutes
     * @param minutes - amount minutes
     */
    public void chooseMinutes(int minutes) {
        int width = sliderMinutes.getSize().getWidth();
        Actions move = new Actions(webDriver);
        move.moveToElement(sliderMinutes, ((width*minutes)/100), 0).click();
        move.build().perform();
    }

    /**
     * Method for choose amount sms
     * @param sms - amount sms
     */
    public void chooseSms(int sms) {
        int width = sliderSms.getSize().getWidth();
        Actions move = new Actions(webDriver);
        move.moveToElement(sliderSms, ((width*sms)/100), 0).click();
        move.build().perform();
    }

    /**
     * Method for check order button
     * @return - true
     */
    public boolean checkOrderButton() {
        return orderButton.isEnabled();
    }

    /**
     * Method for get price
     * @return - actual price
     */
    public String getActualPrice() {
        return getPrice.getText();
    }

}
