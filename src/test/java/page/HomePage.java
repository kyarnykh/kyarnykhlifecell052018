package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver webDriver;

    @FindBy(xpath = "//div[3]/ul/li[5]")
    private WebElement customerServiceButton;


    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getCurrentTittle(){
        return webDriver.getTitle();
    }

    public CustomerServiceCentersPage clickCustomerServiceButton() {
        customerServiceButton.click();
        return new CustomerServiceCentersPage(webDriver);
    }


}
