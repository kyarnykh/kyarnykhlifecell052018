package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LegoRoamingPage;
import page.RoamingPage;

import static java.lang.Thread.sleep;


/**
 * TestPage of OrderLegoRoamingTest with methods, variables and test data
 */
public class OrderLegoRoamingTest extends BaseTest {

    public OrderLegoRoamingTest() {
    }

    /**
     * Test data for choose Lego roaming bundles and check their prices
     * @return:
     * Country - choose country
     * Days:
       -40 = 3
       -20 = 8
         0 = 11
        20 = 15
        40 = 30
     * DATA:
       -50 = 0 MB
       -30 = 100 MB
       -10 = 200 MB
         0 = 300 MB
        10 = 500 MB
        30 = 1 GB
        50 = 2 GB
     * Minutes:
       -50 = 0 min
       -30 = 10 min
       -10 = 20 min
        10 = 30 min
        30 = 50 min
        50 = 100 min
     * SMS:
       -40 = 0 SMS
       -20 = 15 SMS
        20 = 30 SMS
        40 = 50 SMS
     */
    @DataProvider
    public Object[][] DataForOrderLegoRoaming() {
        return new Object[][]{
                {"Франція", -40, 50, -30, 40, "675"},
                {"Франція", -20, 30, -10, 20, "490"},
                {"Франція", 0, 10, 10, -20, "405"},
                {"Франція", 20, 0, 30, -40, "430"},
                {"Франція", 40, -10, 50, -20, "700"},
        };
    }

    /**
     * Method for verify price for Lego Roaming
     * @param country - country of stay
     * @param days - quantity days
     * @param gb - gigabyte for internet
     * @param minutes - minutes for outgoing and incoming calls
     * @param sms - sms
     * @param expectedPrice - price is visible on site
     * @throws InterruptedException
     */
    @Test(dataProvider = "DataForOrderLegoRoaming")
    public void verifyPriceOfLegoRoaming(String country, int days, int gb, int minutes, int sms, String expectedPrice) throws InterruptedException {
        RoamingPage roamingPage = homePage.clickOnRoamingButton(webDriver);
        Assert.assertEquals(roamingPage.getPageTitle(), "РОУМІНГ",
                "Roaming page is not loaded");

        LegoRoamingPage legoRoamingPage = roamingPage.clickOnLegoRoaming(webDriver);
        Assert.assertEquals(legoRoamingPage.getCurrentTitle(), "Послуга «Роумінг Пазл»",
                "Roaming page is not loaded");

        legoRoamingPage.insertCountry(country);
        legoRoamingPage.chooseDays(days);
        WebDriverSleep(5000);
        legoRoamingPage.chooseData(gb);
        WebDriverSleep(5000);
        legoRoamingPage.chooseMinutes(minutes);
        WebDriverSleep(5000);
        legoRoamingPage.chooseSms(sms);
        WebDriverSleep(5000);

        Assert.assertTrue(legoRoamingPage.checkOrderButton(), "Order button is not clickable");

        Assert.assertEquals(legoRoamingPage.getActualPrice(), expectedPrice,
                "Price by Lego Roaming is incorrect");
    }


}
