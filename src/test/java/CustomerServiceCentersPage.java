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
                {"Вінницька обл", "Вінниця", "ВІННИЦЬКА ОБЛ, ВІННИЦЯ"},
                {"Вінницька обл", "Гайсин", "ВІННИЦЬКА ОБЛ, ГАЙСИН"},
                {"Вінницька обл", "Козятин", "ВІННИЦЬКА ОБЛ, КОЗЯТИН"},
        };
    }


    @Test (dataProvider = "RegionCity")
    public void verifyRegionAndCityAndAddress(String Region, String City, String RegionCity) throws InterruptedException {
        CustomerServiceCentersObjectPage customerServiceCentersObjectPage = new CustomerServiceCentersObjectPage(webDriver);
        Assert.assertEquals(customerServiceCentersObjectPage.getCurrentTittle(), "Магазини lifecell",
                "Current page is wrong");

        sleep (3000);

        Select dropdownRegion = new Select(webDriver.findElement(By.xpath("//*[@id='id_region']")));
        dropdownRegion.selectByVisibleText(Region);

        sleep (3000);

        Select dropdownCity = new Select(webDriver.findElement(By.xpath("//*[@id='id_town']")));
        dropdownCity.selectByVisibleText(City);

        Assert.assertEquals(customerServiceCentersObjectPage.getCurrentRegionCity(), RegionCity,
                "Current Region and City are wrong");

    }

}
