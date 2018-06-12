package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LegoTariffPage;
import page.PayPage;
import page.TariffsPlanPage;


public class OrderLegoTariffTest extends BaseTest {

    public OrderLegoTariffTest() {
    }

    /**
     * Test data for order device
     * @return information about users
     */
    @DataProvider
    public Object[][] DataOrderLegoTariff() {
        return new Object[][]{
                {""},
        };
    }

    /**
     * Method for verify basic order device
     * @param
     */
    @Test()
    public void verifyMonthlyFeeWithUnlimOnnet() {
        TariffsPlanPage TariffsPlanPage = homePage.clickOnTariffsPlanButton(webDriver);
        Assert.assertEquals(TariffsPlanPage.getCurrentTitle(), "4G LTE мобільний інтернет. lifecell - lifecell Україна",
                "Tariffs plan page is not loaded");

        LegoTariffPage legoTariffPage = TariffsPlanPage.clickOnLegoTariff(webDriver);
        Assert.assertTrue(legoTariffPage.isPageLoaded(), "Lego Tariff page is not loaded");


        legoTariffPage.chooseOffnet();
//        legoTariffPage.chooseData();
//        legoTariffPage.chooseSMS();
//
//        devicePage.fillFieldOfStep1(userMobileNumber, userName, userEmail, userRegion, userCity);
//        PayPage payPage = devicePage.fillFieldOfStep2(nameOfStreet, numberHouse, numberApartment, userComment);
//
//        Assert.assertEquals(legoTariffPage.getDiscountPrice(), "?????",
//                "Discount price is incorrect");
//
//        Assert.assertEquals(legoTariffPage.getMonthlyFeePrice(), "?????",
//                "Monthly fee price is incorrect");
    }

}