package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LegoTariffPage;
import page.TariffsPlanPage;

import static java.lang.Thread.sleep;


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
    public Object[][] DataOrderLegoTariff() {
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
     * Method for verify price of discount and monthly fee in Lego tariff
     * @param minOffnet - minutes to other Networks
     * @param gb - gigabyte for internet
     * @param sms - sms
     * @param onOff - activate / NOT activate
     * @param priceDiscount - price discount is visible on site
     * @param priceMonthlyFee - price monthly fee is visible on site
     * @throws InterruptedException
     */
    @Test(dataProvider = "DataOrderLegoTariff")
    public void verifyMonthlyFeeWithUnlimOnnet(int minOffnet, int gb, int sms, int onOff, String priceDiscount, String priceMonthlyFee) throws InterruptedException {
        TariffsPlanPage TariffsPlanPage = homePage.clickOnTariffsPlanButton(webDriver);
        Assert.assertEquals(TariffsPlanPage.getCurrentTitle(), "4G LTE мобільний інтернет. lifecell - lifecell Україна",
                "Tariffs plan page is not loaded");

        LegoTariffPage legoTariffPage = TariffsPlanPage.clickOnLegoTariff(webDriver);
        Assert.assertTrue(legoTariffPage.isPageLoaded(), "Lego Tariff page is not loaded");

        legoTariffPage.chooseOffnet(minOffnet);
        legoTariffPage.chooseData(gb);
        legoTariffPage.chooseSMS(sms);
        legoTariffPage.switchSocialNetworks(onOff);

        sleep(2000);

        Assert.assertEquals(legoTariffPage.getPriceOfDiscount(), priceDiscount,
                "Discount price is incorrect");
        Assert.assertEquals(legoTariffPage.getPriceOfMonthlyFee(), priceMonthlyFee,
                "Monthly fee price is incorrect");
    }

}