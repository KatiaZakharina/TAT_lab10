package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ItemPage;

import java.time.Duration;

public class GlistenCosmeticsTest {
    private static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testAddItemToCart() {
        String EXPECTED_AMOUNT = "1";

        String amountOfProducts = new ItemPage(driver)
                .openPage()
                .addItemToCart()
                .getAmountOfProducts();
        Assert.assertEquals(amountOfProducts, EXPECTED_AMOUNT);
    }

    @Test
    public void testEmptySearchResult() {
        String SEARCH_QUERY = "abcdef";
        String RESULT_INFO = String.format("Your search for \"%s\" did not yield any results.", SEARCH_QUERY);
        ;

        String searchResults = new HomePage(driver)
                .openPage()
                .searchByQuery(SEARCH_QUERY)
                .getSearchResult();
        Assert.assertEquals(searchResults, RESULT_INFO);
    }


    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}