package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.DevicePage;
import page.PayPage;
import page.ShopPage;

/**
 * TestPage of OrderDeviceTest with methods, variables and test data
 */
public class OrderDeviceTest extends BaseTest {

    public OrderDeviceTest() {
    }

    /**
     * Test data for order device
     * @return information about users
     */
    @DataProvider
    public Object[][] DataOrderDevice() {
        return new Object[][]{
                {"632109999", "testName", "test@test.ua", "Київ та Київська обл", "Київ",
                "test", "11a", "5", "don't reply"},
        };
    }

    /**
     * Method for verify basic order device
     * @param userMobileNumber - mobile number
     * @param userName - user name
     * @param userEmail - user email
     * @param userRegion - choose region
     * @param userCity - choose city
     * @param nameOfStreet - street's name
     * @param numberHouse - number house
     * @param numberApartment - number apartment
     * @param userComment - comments by user
     */
    @Test(dataProvider = "DataOrderDevice")
    public void basicOrderDeviceTest(String userMobileNumber, String userName, String userEmail, String userRegion, String userCity,
                                     String nameOfStreet, String numberHouse, String numberApartment, String userComment) {
        ShopPage shopPage = homePage.clickOnShopButton(webDriver);
        Assert.assertEquals(shopPage.isPageLoaded(), "Інтернет-магазин",
                "Shop page is not loaded");

        DevicePage devicePage = shopPage.clickOnDevice(webDriver);
        Assert.assertTrue(devicePage.isPageLoaded(), "Device's page is not loaded");

        devicePage.clickOnBuyButton();

        devicePage.fillFieldOfStep1(userMobileNumber, userName, userEmail, userRegion, userCity);
        PayPage payPage = devicePage.fillFieldOfStep2(nameOfStreet, numberHouse, numberApartment, userComment);

        Assert.assertEquals(payPage.isPageLoaded(), "https://easypay.ua/ua/order/payment",
                "Page of pay is not loaded");
    }

}
