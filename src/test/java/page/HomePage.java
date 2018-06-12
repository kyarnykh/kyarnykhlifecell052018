package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject of HomePage with methods and variables
 */
public class HomePage extends BasePage {

    @FindBy(xpath = "//div[3]/ul/li[5]")
    private WebElement customerServiceCentersButton;

    @FindBy(xpath = "//*[@type='button']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@type='text']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id='search_form']")
    private WebElement searchForm;

    @FindBy(xpath = "//a[@href='/uk/pristroyi/']")
    private WebElement shopButton;

    @FindBy(xpath = "//div[3]/div[2]/div/div[1]/ul/li[1]")
    private WebElement mainMenu;

    @FindBy(xpath = "//a[.='Тарифні плани']")
    private WebElement tariffsPlanButton;



    /**
     * Constructor of HomePage class
     * @param webDriver - extends from BasePage
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public HomePage(WebDriver webDriver) {
        super(webDriver);
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
    public CustomerServiceCentersPage clickCustomerServiceCentersButton() {
        customerServiceCentersButton.click();
        return new CustomerServiceCentersPage(webDriver);
    }

    /**
     * Method for search some information by users
     * @param searchTerm - text for searching
     * @return - next new Page
     */
    public SearchPage search (String searchTerm){
        searchButton.click();
        searchField.sendKeys(searchTerm);
        searchForm.submit();
        return new SearchPage(webDriver);
    }

    /**
     * Click on the shop buttone
     * @param webDriver - current webDriver
     * @return next new Page
     */
    public ShopPage clickOnShopButton(WebDriver webDriver) {
        shopButton.click();
        return new ShopPage(webDriver);
    }

    public TariffsPlanPage clickOnTariffsPlanButton(WebDriver webDriver) {
        new Actions(webDriver).moveToElement(mainMenu).perform();
        waitUntilElementIsClickable(tariffsPlanButton, 5);
        tariffsPlanButton.click();
        return new TariffsPlanPage(webDriver);
    }
}
