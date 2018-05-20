import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
                {"ВІННИЦЬКА ОБЛ"},
        };
    }


    @Test(dataProvider = "RegionUkr")
    public void verifyRegionUkr(String CurrentRegion) throws InterruptedException {

        webDriver.get("https://www.lifecell.ua/");
        LifecellHomeObjectPage lifecellHomePage = new LifecellHomeObjectPage(webDriver);

        sleep (5000);

//        lifecellHomePage.clickRegionButton();

        sleep (2000);

        lifecellHomePage.clickCustomerServiceButton();

        CustomerServiceCentersObjectPage customerServiceCentersObjectPage = new CustomerServiceCentersObjectPage(webDriver);
        Assert.assertEquals(customerServiceCentersObjectPage.getCurrentTittle(), "Магазини lifecell",
                "Current page is wrong");

        sleep (2000);

        Assert.assertEquals(customerServiceCentersObjectPage.getCurrentRegion(), CurrentRegion,
                "Current region is wrong");
    }





}
