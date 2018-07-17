package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LegoTariffPage;
import page.TariffsPlanPage;


/**
 * TestPage of OrderLegoTariffTest with methods, variables and test data
 */
public class OrderLegoTariffTest extends BaseTest {

    public OrderLegoTariffTest() {
    }

    /**
     * Test data for choose Lego bundles and check discount and monthly prices
     * @return:
     * Minutes:
       -50 = 0 min
       -25 = 50 min
        0 = 100 min
        25 = 200 min
        50 = 400 min
     * DATA:
       -50 = 0 GB
       -25 = 1 GB
        0 = 4 GB
        25 = 8 GB
        50 = 10 GB
     * SMS:
       -50 = 0 SMS
       -25 = 50 SMS
        25 = 100 SMS
        50 = 250 SMS
     * Social Networks:
        0 = OFF
        1 = ON
     */
    @DataProvider
    public Object[][] DataForOrderLegoTariffWithUnlimOnnet() {
        return new Object[][]{
                {-50, -25, -25, 0, "20 грн", "43"},
                {-25, 0, 25, 1, "45 грн", "70"},
                {0, 25, 50, 0, "35 грн", "95"},
                {25, 50, -50, 1, "45 грн", "140"},
                {50, -50, -25, 0, "20 грн", "103"},
                {-50, -25, 25, 1, "30 грн", "50"},
        };
    }

    /**
     * Test data for choose Lego bundles and check discount and monthly prices
     * @return:
     * Minutes:
       -50 = 300 min
        0 = 500 min
        50 = 1000 min
     * DATA:
       -50 = 0 GB
       -25 = 1 GB
        0 = 4 GB
        25 = 8 GB
        50 = 10 GB
     * SMS:
       -50 = 0 SMS
       -25 = 50 SMS
        25 = 100 SMS
        50 = 250 SMS
     * Social Networks:
        0 = OFF
        1 = ON
     */
    @DataProvider
    public Object[][] DataForOrderLegoTariffWithAnynet() {
        return new Object[][]{
                {-50, -25, -25, 1, "30 грн", "58"},
                {0, 0, 25, 0, "35 грн", "80"},
                {50, 25, 50, 1, "60 грн", "165"},
                {-50, 50, -50, 0, "20 грн", "110"},
                {0, -50, -25, 1, "0 грн", "93"},
        };
    }

    /**
     * Method for verify price of discount and monthly fee in Lego tariff
     * @param minOffnet - minutes to other Networks
     * @param gb - gigabyte for internet
     * @param sms - sms
     * @param onOff - activate / NOT activate
     * @param expectedPriceDiscount - price discount is visible on site
     * @param expectedPriceMonthlyFee - price monthly fee is visible on site
     * @throws InterruptedException
     */
//    @Test(dataProvider = "DataForOrderLegoTariffWithUnlimOnnet")
    public void verifyPriceOfMonthlyFeeWithUnlimOnnet(int minOffnet, int gb, int sms, int onOff,
                                                      String expectedPriceDiscount, String expectedPriceMonthlyFee) {
        TariffsPlanPage tariffsPlanPage = homePage.clickOnTariffsPlanButton(webDriver);
        Assert.assertEquals(tariffsPlanPage.getPageTitle(), "ТАРИФНІ ПЛАНИ",
                "Tariffs plan page is not loaded");

        LegoTariffPage legoTariffPage = tariffsPlanPage.clickOnLegoTariff(webDriver);
        Assert.assertTrue(legoTariffPage.isPageLoaded(), "Lego Tariff page is not loaded");

        legoTariffPage.chooseOffnet(minOffnet);
        legoTariffPage.chooseData(gb);
        legoTariffPage.chooseSMS(sms);
        legoTariffPage.switchSocialNetworks(onOff);

        waitForJQueryEnds();

        Assert.assertEquals(legoTariffPage.getPriceOfDiscount(), expectedPriceDiscount,
                "Discount price is incorrect");
        Assert.assertEquals(legoTariffPage.getPriceOfMonthlyFee(), expectedPriceMonthlyFee,
                "Monthly fee price is incorrect");
    }

    /**
     * Method for verify price of discount and monthly fee in Lego tariff
     * @param minAnynet - minutes to any Networks
     * @param gb - gigabyte for internet
     * @param sms - sms
     * @param onOff - activate / NOT activate
     * @param expectedPriceDiscount - price of discount
     * @param expectedPriceMonthlyFee - price of monthly fee
     * @throws InterruptedException
     */
//    @Test(dataProvider = "DataForOrderLegoTariffWithAnynet")
    public void verifyPriceOfMonthlyFeeWithAnynet(int minAnynet, int gb, int sms, int onOff,
                                                  String expectedPriceDiscount, String expectedPriceMonthlyFee) {
        TariffsPlanPage TariffsPlanPage = homePage.clickOnTariffsPlanButton(webDriver);
        Assert.assertEquals(TariffsPlanPage.getPageTitle(), "ТАРИФНІ ПЛАНИ",
                "Tariffs plan page is not loaded");

        LegoTariffPage legoTariffPage = TariffsPlanPage.clickOnLegoTariff(webDriver);
        Assert.assertTrue(legoTariffPage.isPageLoaded(), "Lego Tariff page is not loaded");

        legoTariffPage.clickOnAnynetButton();
        legoTariffPage.chooseAnynet(minAnynet);
        legoTariffPage.chooseData(gb);
        legoTariffPage.chooseSMS(sms);
        legoTariffPage.switchSocialNetworks(onOff);

        waitForJQueryEnds();

        Assert.assertEquals(legoTariffPage.getPriceOfDiscount(), expectedPriceDiscount,
                "Discount price is incorrect");
        Assert.assertEquals(legoTariffPage.getPriceOfMonthlyFee(), expectedPriceMonthlyFee,
                "Monthly fee price is incorrect");
    }

}