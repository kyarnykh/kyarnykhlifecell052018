package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.SearchPage;

/**
 * TestPage of SearchTest with methods, variables and test data
 */
public class SearchTest extends BaseTest {

    public SearchTest() {
    }

    /**
     * Test data for search field
     * @return search term
     */
    @DataProvider
    public Object[][] DataSearch() {
        return new Object[][]{
                {"lifecell"},
        };
    }

    /**
     * Method for verify basic search form
     * @param searchTerm - search term
     */
    @Test(dataProvider = "DataSearch")
    public void basicSearchTest(String searchTerm) {
        SearchPage searchPage = homePage.search(searchTerm);
        Assert.assertTrue(searchPage.isPageLoaded(), "Search page is not loaded");

        Assert.assertEquals(searchPage.getNameOfAll(),"ВСІ", "Menu item 'All' is not displayed");
        Assert.assertEquals(searchPage.getNameOfTariffs(),"ТАРИФИ", "Menu item 'Tariffs' is not displayed");
        Assert.assertEquals(searchPage.getNameOfService(),"ПОСЛУГИ", "Menu item 'Service' is not displayed");
        Assert.assertEquals(searchPage.getNameOfInternetPackages(),"ІНТЕРНЕТ ПАКЕТИ", "Menu item 'Internet Packages' is not displayed");
        Assert.assertEquals(searchPage.getNameOfOffers(),"АКЦІЇ", "Menu item 'Offers' is not displayed");
        Assert.assertEquals(searchPage.getNameOfDevices(),"ПРИСТРОЇ", "Menu item 'Devices' is not displayed");
        Assert.assertEquals(searchPage.getNameOfAnnouncements(),"НОВИНИ", "Menu item 'Announcements' is not displayed");
        Assert.assertEquals(searchPage.getNameOfGuannouncements(),"ОГОЛОШЕННЯ", "Menu item 'Guannouncement' is not displayed");
        Assert.assertEquals(searchPage.getNameOfQuestions(),"ЗАПИТАННЯ", "Menu item 'Questions' is not displayed");
        Assert.assertEquals(searchPage.getNameOfVacancy(),"ВАКАНСІЇ", "Menu item 'Vacancy' is not displayed");
        Assert.assertEquals(searchPage.getNameOfAboutCompany(),"ПРО КОМПАНІЮ", "Menu item 'About Company' is not displayed");
    }

}
