package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * PageObject of SearchPage with methods and variables
 */
public class SearchPage extends BasePage{

    @FindBy(xpath = "//*[@class='form-element']")
    private WebElement searchForm;

    @FindBy(xpath = "//*[@category='all']")
    private WebElement menuAll;

    @FindBy(xpath = "//div/div[2]/div/div/div/div[1]/p[2]")
    private WebElement menuTariffs;

    @FindBy(xpath = "//div/div[2]/div/div/div/div[1]/p[3]")
    private WebElement menuService;

    @FindBy(xpath = "//div/div[2]/div/div/div/div[1]/p[4]")
    private WebElement menuInternetPackages;

    @FindBy(xpath = "//div/div[2]/div/div/div/div[1]/p[5]")
    private WebElement menuOffers;

    @FindBy(xpath = "//div/div[2]/div/div/div/div[1]/p[6]")
    private WebElement menuDevices;

    @FindBy(xpath = "//div/div[2]/div/div/div/div[1]/p[7]")
    private WebElement menuAnnouncements;

    @FindBy(xpath = "//div/div[2]/div/div/div/div[1]/p[8]")
    private WebElement menuGuannouncements;

    @FindBy(xpath = "//div/div[2]/div/div/div/div[1]/p[10]")
    private WebElement menuQuestions;

    @FindBy(xpath = "//div/div[2]/div/div/div/div[1]/p[11]")
    private WebElement menuVacancy;

    @FindBy(xpath = "//div/div[2]/div/div/div/div[1]/p[12]")
    private WebElement menuAboutCompany;


    /**
     * Constructor of LinkedinHomePage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public SearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Check if Page is loaded
     * @return form is loaded
     */
    public boolean isPageLoaded(){
        return searchForm.isDisplayed();
    }

    /**
     * Verify all elements of menu are displayed
     * @return true if one element of all is displayed
     */
    public boolean searchMenuAreDisplayed() {
        menuAll.isDisplayed();
        menuAboutCompany.isDisplayed();
        menuAnnouncements.isDisplayed();
        menuDevices.isDisplayed();
        menuGuannouncements.isDisplayed();
        menuInternetPackages.isDisplayed();
        menuOffers.isDisplayed();
        menuQuestions.isDisplayed();
        menuService.isDisplayed();
        menuTariffs.isDisplayed();
        menuVacancy.isDisplayed();
        return true;
    }
}
