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
                {"bip"},
                {"phone"},
                {"press"},
        };
    }

    /**
     * Method for verify basic search form
     * @param searchTerm - search term
     */
    @Test(dataProvider = "DataSearch")
    public void basicSearchTest(String searchTerm) {
        SearchPage searchPage = homePage.search(searchTerm);
        Assert.assertTrue(searchPage.isPageLoaded(), "Search page is missing");

        Assert.assertTrue(searchPage.searchMenuAreDisplayed());
    }

}
