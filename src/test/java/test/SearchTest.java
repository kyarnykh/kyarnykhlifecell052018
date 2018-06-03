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

    @DataProvider
    public Object[][] DataSearch() {
        return new Object[][]{
                {"lifecell"},
        };
    }


    @Test(dataProvider = "DataSearch")
    public void basicSearchTest(String searchTerm) {
        Assert.assertEquals(homePage.getCurrentTittle(), "Мобільний зв'язок lifecell - lifecell Україна",
                "Home page is wrong");

        SearchPage searchPage = homePage.search(searchTerm);
        Assert.assertTrue(searchPage.isPageLoaded(),
                "Search page is missing");



//        Assert.assertTrue(searchMenu.isDisplayed);




    }






}
