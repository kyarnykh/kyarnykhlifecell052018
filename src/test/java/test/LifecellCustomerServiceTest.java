package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.LifecellCustomerServicePage;


public class LifecellCustomerServiceTest extends LifecellBaseTest {


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

        LifecellCustomerServicePage lifecellCustomerServicePage = lifecellHomePage.clickCustomerServiceButton();

        Assert.assertEquals(lifecellCustomerServicePage.getCurrentTittle(), "Магазини lifecell",
                "Current page is wrong");

        lifecellCustomerServicePage.selectRegion(selectRegion);
        lifecellCustomerServicePage.selectCity(selectCity);

        Assert.assertEquals(lifecellCustomerServicePage.getCurrentRegionCity(), matchRegionAndCity,
                "Current region and/or city are wrong");
    }

}
