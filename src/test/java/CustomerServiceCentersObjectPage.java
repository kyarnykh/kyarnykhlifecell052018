import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerServiceCentersObjectPage {

    WebDriver webDriver;

    private WebElement currentRegionCity;


    public CustomerServiceCentersObjectPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements(webDriver);
    }

    private void initElements(WebDriver webDriver) {
        currentRegionCity = webDriver.findElement(By.xpath("//*[@class='current-region']"));
    }

    public String getCurrentTittle(){
        return webDriver.getTitle();
    }

    public String getCurrentRegionCity(){
        return currentRegionCity.getText();
    }

}