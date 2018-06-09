package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * PageObject of CustomerServiceCentersPage with methods and variables
 */
public class CustomerServiceCentersPage extends BasePage {

    @FindBy(xpath = "//*[@class='current-region']")
    private WebElement currentRegionCity;

    @FindBy(xpath = "//*[@id='id_region']")
    private WebElement dropdownListRegion;

    @FindBy(xpath = "//*[@id='id_town']")
    private WebElement dropdownListCity;


    /**
     * Constructor of BasePage class
     * @param webDriver - extends from BasePage
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public CustomerServiceCentersPage(WebDriver webDriver) {
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
     * Method for find and choose Region
     * @param selectRegion - Region number in dropdown list
     * @return selected Region
     */
    public int selectRegion (int selectRegion){
        Select setRegion = new Select(dropdownListRegion);
        waitUntilElementIsClickable(dropdownListRegion, 10);
        setRegion.selectByIndex(selectRegion);
        return (selectRegion);
    }

    /**
     * Method for find and choose City
     * @param selectCity - City number in dropdown list
     * @return selected City
     */
    public int selectCity (int selectCity){
        Select setCity = new Select(dropdownListCity);
        waitUntilElementIsClickable(dropdownListCity, 10);
        setCity.selectByIndex(selectCity);
        return (selectCity);
    }

    /**
     * Method for return selected Region and City
     * @return text
     */
    public String getCurrentRegionAndCity(){
        return currentRegionCity.getText();
    }

}
