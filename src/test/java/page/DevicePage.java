package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


/**
 * PageObject of DevicePage with methods and variables
 */
public class DevicePage extends BasePage {

    @FindBy(xpath = "//*[@class='order-button']")
    private WebElement orderButton;

    @FindBy(xpath = "//*[@id='id_msisdn']")
    private WebElement fieldNumber;

    @FindBy(xpath = "//*[@id='id_customer_name']")
    private WebElement fieldName;

    @FindBy(xpath = "//*[@id='id_email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//*[@id='id_region']")
    private WebElement dropdownListRegion;

    @FindBy(xpath = "//*[@id='id_city_chosen']")
    private WebElement dropdownListCity;

    @FindBy(xpath = "//*[@id='id_city_chosen']/div/div/input")
    private WebElement fieldCity;

    @FindBy(xpath = "//*[@class='active-result highlighted']")
    private WebElement chooseCity;

    @FindBy(xpath = "//*[@class='button js-next-step']")
    private WebElement nextButton;

    @FindBy(xpath = "//*[@id='id_street']")
    private WebElement fieldNameOfStreet;

    @FindBy(xpath = "//*[@id='id_build']")
    private WebElement fieldNumberHouse;

    @FindBy(xpath = "//*[@id='id_apartment']")
    private WebElement fieldNumberApartment;

    @FindBy(xpath = "//*[@id='id_notes']")
    private WebElement fieldComment;

    @FindBy(xpath = "//*[@class='button js-send-order']")
    private WebElement sendOrderButton;


    /**
     * Constructor of BasePage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public DevicePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Check if Page is loaded
     * @return true if order button is displayed
     */
    public boolean isPageLoaded() {
        orderButton.isDisplayed();
        return true;
    }

    /**
     * Method for click on button for buy
     */
    public void clickOnBuyButton() {
        orderButton.click();
    }

    /**
     * Method for fill all fields on step 1
     * @param userMobileNumber - mobile number
     * @param userName - user name
     * @param userEmail - user email
     * @param userRegion - choose region
     * @param userCity - choose city
     */
    public void fillFieldOfStep1(String userMobileNumber, String userName, String userEmail, String userRegion, String userCity) {
        fieldNumber.sendKeys(userMobileNumber);
        fieldName.sendKeys(userName);
        fieldEmail.sendKeys(userEmail);
        Select setRegion = new Select(dropdownListRegion);
        waitUntilElementIsClickable(dropdownListRegion, 10);
        setRegion.selectByVisibleText(userRegion);
        dropdownListCity.click();
        fieldCity.sendKeys(userCity);
        chooseCity.click();
        waitUntilElementIsClickable(nextButton, 5);
        nextButton.click();
    }

    /**
     * Method for fill all fields on step 2
     * @param nameOfStreet - street's name
     * @param numberHouse - number house
     * @param numberApartment - number apartment
     * @param userComment - comments by user
     * @return next new Page
     */
    public PayPage fillFieldOfStep2(String nameOfStreet, String numberHouse, String numberApartment, String userComment) {
        fieldNameOfStreet.sendKeys(nameOfStreet);
        fieldNumberHouse.sendKeys(numberHouse);
        fieldNumberApartment.sendKeys(numberApartment);
        fieldComment.sendKeys(userComment);
        waitUntilElementIsClickable(sendOrderButton, 5);
        sendOrderButton.click();
        return new PayPage (webDriver);
    }

}
