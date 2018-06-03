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
        waitUntilElementIsClickable(searchForm, 30);
        return searchForm.isDisplayed();
    }


}
