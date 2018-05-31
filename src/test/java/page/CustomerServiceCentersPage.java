package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * PageObject of CustomerServiceCentersPage with methods and variables
 */
public class CustomerServiceCentersPage {

    WebDriver webDriver;

    @FindBy(xpath = "//*[@class='current-region']")
    private WebElement currentRegionCity;

    @FindBy(xpath = "//*[@id='id_region']")
    private WebElement dropdownListRegion;

    @FindBy(xpath = "//*[@id='id_town']")
    private WebElement dropdownListCity;


    /**
     * Constructor of CustomerServiceCentersPage class
     * @param webDriver - current webDriver object
     * PageFactory - initialisation WebElements on THIS page and write their location of page in RAM
     */
    public CustomerServiceCentersPage(WebDriver webDriver) {
        this.webDriver = webDriver;
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
        setCity.selectByIndex(selectCity);
        return (selectCity);
    }

    /**
     * Method for return selected Region and City
     * @return text
     */
    public String getCurrentRegionCity(){
        return currentRegionCity.getText();
    }

}
