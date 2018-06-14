package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LegoTariffPage;
import page.TariffsPlanPage;


public class OrderLegoTariffTest extends BaseTest {

    public OrderLegoTariffTest() {
    }

    /**
     * Test data for choose Lego bundles and check discount and monthly prices
     * @return:
     * Minutes=
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
        0 = 100 SMS,
        50 = 250 SMS.
     * Social Networks:
        0 = OFF,
        1 = ON.
     */
    @DataProvider
    public Object[][] DataOrderLegoTariff() {
        return new Object[][]{
                {-50, -25, -25, 0, "20 грн", "43 грн"},
//                {-25, 0, 0, 1, "45 грн", "70 грн"},
//                {0, 25, 50, 0, "35 грн", "95 грн"},
//                {25, 50, -50, 1, "45 грн", "140 грн"},
//                {50, -50, -25, 0, "20 грн", "103 грн"},
//                {-50, -25, 0, 1, "30 грн", "50 грн"},
        };
    }

    /**
     * Method for verify basic order device
     * @param
     */
    @Test(dataProvider = "DataOrderLegoTariff")
    public void verifyMonthlyFeeWithUnlimOnnet(int minOffnet, int gb, int sms, int onOff, String priceDiscount, String priceMonthlyFee) {
        TariffsPlanPage TariffsPlanPage = homePage.clickOnTariffsPlanButton(webDriver);
        Assert.assertEquals(TariffsPlanPage.getCurrentTitle(), "4G LTE мобільний інтернет. lifecell - lifecell Україна",
                "Tariffs plan page is not loaded");

        LegoTariffPage legoTariffPage = TariffsPlanPage.clickOnLegoTariff(webDriver);
        Assert.assertTrue(legoTariffPage.isPageLoaded(), "Lego Tariff page is not loaded");

        legoTariffPage.chooseOffnet(minOffnet);
        legoTariffPage.chooseData(gb);
        legoTariffPage.chooseSMS(sms);
        legoTariffPage.switchSocialNetworks(onOff);

        Assert.assertEquals(legoTariffPage.matchDiscountPrice(), priceDiscount,
                "Discount price is incorrect");
        Assert.assertEquals(legoTariffPage.matchMonthlyFeePrice(), priceMonthlyFee,
                "Monthly fee price is incorrect");
    }

}