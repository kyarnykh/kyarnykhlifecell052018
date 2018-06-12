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

    public void chooseOffnet() {
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", sliderOffnet);
        int width = sliderOffnet.getSize().getWidth();
        System.out.println(width);
        Actions move = new Actions(webDriver);
        move.moveToElement(sliderOffnet, ((width*2)/10), 0).click();
        move.build().perform();
    }


}
