package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LifecellHomePage {

    WebDriver webDriver;

    @FindBy(xpath = "//div[3]/ul/li[5]")
    private WebElement customerServiceButton;


    public LifecellHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getCurrentTittle(){
        return webDriver.getTitle();
    }

    public LifecellCustomerServicePage clickCustomerServiceButton() {
        customerServiceButton.click();
        return new LifecellCustomerServicePage(webDriver);
    }


}
