package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LifecellCustomerServicePage {

    WebDriver webDriver;

    @FindBy(xpath = "//*[@class='current-region']")
    private WebElement currentRegionCity;

    @FindBy(xpath = "//*[@id='id_region']")
    private WebElement dropdownListRegion;

    @FindBy(xpath = "//*[@id='id_town']")
    private WebElement dropdownListCity;


    public LifecellCustomerServicePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public String getCurrentTittle(){
        return webDriver.getTitle();
    }

    public int selectRegion (int selectRegion){
        Select setRegion = new Select(dropdownListRegion);
        setRegion.selectByIndex(selectRegion);
        return (selectRegion);
    }

    public int selectCity (int selectCity){
        Select setCity = new Select(dropdownListCity);
        setCity.selectByIndex(selectCity);
        return (selectCity);
    }

    public String getCurrentRegionCity(){
        return currentRegionCity.getText();
    }

}
