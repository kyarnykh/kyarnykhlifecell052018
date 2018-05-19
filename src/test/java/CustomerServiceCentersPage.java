import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;


public class CustomerServiceCentersPage {

    WebDriver webDriver;

    public CustomerServiceCentersPage() {
    }

    @BeforeClass
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.lifecell.ua/uk/tsentry-obslugovuvannya-abonentiv/");
    }

    @AfterClass
    public void after() {
        webDriver.close();
    }


    @DataProvider
    public Object[][] RegionCity() {
        return new Object[][]{
                {1, 1, "ВІННИЦЬКА ОБЛ, ВІННИЦЯ"},
                {1, 2, "ВІННИЦЬКА ОБЛ, ГАЙСИН"},
                {1, 3, "ВІННИЦЬКА ОБЛ, КОЗЯТИН"},
        };
    }


    @Test (dataProvider = "RegionCity")
    public void verifyRegionAndCity(int Region, int City, String RegionCity) throws InterruptedException {
        CustomerServiceCentersObjectPage customerServiceCentersObjectPage = new CustomerServiceCentersObjectPage(webDriver);
        Assert.assertEquals(customerServiceCentersObjectPage.getCurrentTittle(), "Магазини lifecell",
                "Current page is wrong");

        sleep (2000);

        Select dropdownRegion = new Select(webDriver.findElement(By.xpath("//*[@id='id_region']")));
        dropdownRegion.selectByIndex(Region);

        sleep (1000);

        Select dropdownCity = new Select(webDriver.findElement(By.xpath("//*[@id='id_town']")));
        dropdownCity.selectByIndex(City);

        Assert.assertEquals(customerServiceCentersObjectPage.getCurrentRegionCity(), RegionCity,
                "Current Region and City are wrong");

    }

}
