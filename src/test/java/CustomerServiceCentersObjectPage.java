import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerServiceCentersObjectPage {

    WebDriver webDriver;

    private WebElement currentRegionCity;
    private WebElement currentRegion;



    public CustomerServiceCentersObjectPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements(webDriver);
    }

    private void initElements(WebDriver webDriver) {
        currentRegionCity = webDriver.findElement(By.xpath("//*[@class='current-region']"));
        currentRegion = webDriver.findElement(By.xpath("//*[@id='id_region']"));
    }

    public String getCurrentTittle(){
        return webDriver.getTitle();
    }

    public String getCurrentRegionCity(){
        return currentRegionCity.getText();
    }

    public String getCurrentRegion(){
        return currentRegion.getAttribute("selected");
    }

}
