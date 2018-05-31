package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.CustomerServiceCentersPage;


public class CustomerServiceCentersTest extends BaseTest {


    @DataProvider
    public Object[][] RegionCity() {
        return new Object[][]{
                {1, 1, "ВІННИЦЬКА ОБЛ, ВІННИЦЯ"},
                {1, 2, "ВІННИЦЬКА ОБЛ, ГАЙСИН"},
                {1, 3, "ВІННИЦЬКА ОБЛ, КОЗЯТИН"},
        };
    }


    @Test (dataProvider = "RegionCity")
    public void verifyRegionAndCity(int selectRegion, int selectCity, String matchRegionAndCity) {

        CustomerServiceCentersPage customerServiceCentersPage = lifecellHomePage.clickCustomerServiceButton();

        Assert.assertEquals(customerServiceCentersPage.getCurrentTittle(), "Магазини lifecell",
                "Current page is wrong");

        customerServiceCentersPage.selectRegion(selectRegion);
        customerServiceCentersPage.selectCity(selectCity);

        Assert.assertEquals(customerServiceCentersPage.getCurrentRegionCity(), matchRegionAndCity,
                "Current region and/or city are wrong");
    }

}
