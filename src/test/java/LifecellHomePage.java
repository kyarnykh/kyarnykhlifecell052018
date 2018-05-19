import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    public class LifecellHomePage {

        WebDriver webDriver;

        private WebElement customerServiceButton;


        public LifecellHomePage (WebDriver webDriver) {
            this.webDriver = webDriver;
            initElements(webDriver);
        }

        private void initElements(WebDriver webDriver) {
            customerServiceButton = webDriver.findElement(By.xpath("//div[3]/ul/li[5]"));
        }

        public void clickCustomerServiceButton() {
            customerServiceButton.click();
        }

}
