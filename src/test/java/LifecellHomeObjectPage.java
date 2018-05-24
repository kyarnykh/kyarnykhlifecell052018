import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LifecellHomeObjectPage {

    WebDriver webDriver;
    Actions actions = new Actions(webDriver);

    private WebElement customerServiceButton;
    private WebElement selectLanguage;


    public LifecellHomeObjectPage (WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements(webDriver);
    }

    private void initElements(WebDriver webDriver) {
        selectLanguage = webDriver.findElement(By.xpath("//*[@class='header__languageIndicator paymentForm__languageIndicator']"));
        customerServiceButton = webDriver.findElement(By.xpath("//div[3]/ul/li[5]"));
    }

    public String getCurrentTittle(){
        return webDriver.getTitle();
    }

    public void setActions(){
        actions.moveToElement(selectLanguage).build().perform();
    }

    public void clickCustomerServiceButton() {
        customerServiceButton.click();
    }


}
