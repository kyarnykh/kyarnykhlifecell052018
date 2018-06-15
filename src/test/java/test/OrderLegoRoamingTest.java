package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LegoRoamingPage;
import page.RoamingPage;


public class OrderLegoRoamingTest extends BaseTest {

    public OrderLegoRoamingTest() {
    }

    /**
     * Test data for choose Lego bundles and check discount and monthly prices
     * @return:
     * Minutes:
    -50 = 0 min,
    -25 = 50 min,
    0 = 100 min,
    25 = 200 min,
    50 = 400 min.
     * DATA:
    -50 = 0 GB,
    -25 = 1 GB,
    0 = 4 GB,
    25 = 8 GB,
    50 = 10 GB.
     * SMS:
    -50 = 0 SMS,
    -25 = 50 SMS,
    25 = 100 SMS,
    50 = 250 SMS.
     * Social Networks:
    0 = OFF,
    1 = ON.
     */
    @DataProvider
    public Object[][] DataForOrderLegoRoaming() {
        return new Object[][]{
                {"Франція", 0, 0, 0, 0, "380"},
        };
    }

    @Test(dataProvider = "DataForOrderLegoRoaming")
    public void verifyPriceOfLegoRoaming(String country, int days, int gb, int minutes, int sms, String priceOfLegoRoaming) {
        RoamingPage roamingPage = homePage.clickOnRoamingButton(webDriver);
        Assert.assertEquals(roamingPage.getPageTitle(), "РОУМІНГ",
                "Roaming page is not loaded");

        LegoRoamingPage legoRoamingPage = roamingPage.clickOnLegoRoaming(webDriver);
        Assert.assertEquals(legoRoamingPage.getCurrentTitle(), "Послуга «Роумінг Пазл»",
                "Roaming page is not loaded");

        legoRoamingPage.insertCountry(country);
        legoRoamingPage.chooseDays(days);
        legoRoamingPage.chooseData(gb);
        legoRoamingPage.chooseMinutes(minutes);
        legoRoamingPage.chooseSms(sms);

        Assert.assertTrue(legoRoamingPage.orderButtonIsClickable(), "Order button is not clickable");
        Assert.assertEquals(legoRoamingPage.getPriceOfLegoRoaming(), priceOfLegoRoaming,
                "Price by Lego Roaming is incorrect");
    }


}
