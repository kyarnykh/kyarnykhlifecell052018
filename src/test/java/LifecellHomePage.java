import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LifecellHomePage {

    WebDriver webDriver;

    WebElement chooseCustomerRegion;


    public LifecellHomePage() {
    }

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }


    @DataProvider
    public Object[][] RegionUkr() {
        return new Object[][]{
                {"Вінницька"},
        };
    }


    @Test(dataProvider = "RegionUkr")
    public void verifyRegionUkr(String CurrentRegion) throws InterruptedException {
        webDriver.get("https://www.lifecell.ua/");

        LifecellHomeObjectPage lifecellHomePage = new LifecellHomeObjectPage(webDriver);
        Assert.assertEquals(lifecellHomePage.getCurrentTittle(), "Мобільний зв'язок lifecell - lifecell Україна",
                "Home page is wrong");

        sleep (5000);

        chooseCustomerRegion = webDriver.findElement(By.xpath("//a[contains(text(),'Вінницька')]"));

        chooseCustomerRegion.click();

        lifecellHomePage.clickCustomerServiceButton();

        sleep (5000);

        CustomerServiceCentersObjectPage customerServiceCentersObjectPage = new CustomerServiceCentersObjectPage(webDriver);
        Assert.assertEquals(customerServiceCentersObjectPage.getCurrentTittle(), "Магазини lifecell",
                "Customer service page is wrong");

    }


}
