package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.CustomerServiceCentersPage;


/**
 * TestPage of CustomerServiceCentersTest with methods, variables and test data
 */
public class CustomerServiceCentersTest extends BaseTest {


    /**
     * Test data for choose Region and City and check their
     * @return Region and City numbers in dropdown list and text for checking
     */
    @DataProvider
    public Object[][] RegionCity() {
        return new Object[][]{
                {1, 1, "ВІННИЦЬКА ОБЛ, ВІННИЦЯ"},
                {1, 2, "ВІННИЦЬКА ОБЛ, ГАЙСИН"},
                {1, 3, "ВІННИЦЬКА ОБЛ, КОЗЯТИН"},
        };
    }


    /**
     * Check conformity expected dropdown lists with Regions and Cities with actual
     * @param selectRegion - Region number in dropdown list
     * @param selectCity - City number in dropdown list
     * @param matchRegionAndCity - text for checking selected Region and City with expected
     */
    @Test (dataProvider = "RegionCity")
    public void verifyRegionAndCityForm(int selectRegion, int selectCity, String matchRegionAndCity) {
        Assert.assertEquals(homePage.getCurrentTittle(), "Мобільний зв'язок lifecell - lifecell Україна",
                "Home page is wrong");

        CustomerServiceCentersPage customerServiceCentersPage = homePage.clickCustomerServiceCentersButton();
        Assert.assertEquals(customerServiceCentersPage.getCurrentTittle(), "Магазини lifecell",
                "Customer service centers page is wrong");

        customerServiceCentersPage.selectRegion(selectRegion);
        customerServiceCentersPage.selectCity(selectCity);

        Assert.assertEquals(customerServiceCentersPage.getCurrentRegionAndCity(), matchRegionAndCity,
                "Current region and/or city are wrong");
    }

}
