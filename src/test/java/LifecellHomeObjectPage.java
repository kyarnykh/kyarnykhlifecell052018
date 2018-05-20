import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LifecellHomeObjectPage {

    WebDriver webDriver;

    private WebElement customerServiceButton;
//    private WebElement homeRegion;



    public LifecellHomeObjectPage (WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements(webDriver);
    }

    private void initElements(WebDriver webDriver) {
        customerServiceButton = webDriver.findElement(By.xpath("//div[3]/ul/li[5]"));
//        homeRegion = webDriver.findElement(By.xpath("//div[3]/ul/li[1]/a"));

    }

    public void clickCustomerServiceButton() {
        customerServiceButton.click();
    }

//    public void clickRegionButton() {
//        homeRegion.click();
//    }

}
