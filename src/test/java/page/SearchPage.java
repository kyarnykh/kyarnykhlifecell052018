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

    @FindBy(xpath = "//*[@class='search-result-group tabs']")
    private WebElement searchMenu;

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
     * @return true if element of menu is displayed
     */
    public String getNameOfAll() {
        waitUntilElementIsClickable(menuAll, 5);
        return menuAll.getText();
    }

    public String getNameOfAboutCompany() {
        waitUntilElementIsClickable(menuAboutCompany, 5);
        return menuAboutCompany.getText();
    }

    public String getNameOfAnnouncements() {
        waitUntilElementIsClickable(menuAnnouncements, 5);
        return menuAnnouncements.getText();
    }

    public String getNameOfDevices() {
        waitUntilElementIsClickable(menuDevices, 5);
        return menuDevices.getText();
    }

    public String getNameOfGuannouncements() {
        waitUntilElementIsClickable(menuGuannouncements, 5);
        return menuGuannouncements.getText();
    }

    public String getNameOfInternetPackages() {
        waitUntilElementIsClickable(menuInternetPackages, 5);
        return menuInternetPackages.getText();
    }

    public String getNameOfOffers() {
        waitUntilElementIsClickable(menuOffers, 5);
        return menuOffers.getText();
    }

    public String getNameOfQuestions() {
        waitUntilElementIsClickable(menuQuestions, 5);
        return menuQuestions.getText();
    }

    public String getNameOfService() {
        waitUntilElementIsClickable(menuService, 5);
        return menuService.getText();
    }

    public String getNameOfTariffs() {
        waitUntilElementIsClickable(menuTariffs, 5);
        return menuTariffs.getText();
    }

    public String getNameOfVacancy() {
        waitUntilElementIsClickable(menuVacancy, 5);
        return menuVacancy.getText();
    }


}
