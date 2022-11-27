package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends WithModalsPage {
    public static String HOME_PAGE_URL = "https://www.glistencosmetics.com";

    @FindBy(xpath = "//input[@placeholder='Search' and @name='q']")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@class='search-bar__submit']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//h1[@class='h2 small--text-center']")
    private WebElement searchResult;


    public HomePage(WebDriver driver) {
        super(driver, HOME_PAGE_URL);
    }

    public HomePage openPage() {
        super.openPage();
        return this;
    }

    public HomePage searchByQuery(String searchQuery) {
        wait.until(ExpectedConditions.visibilityOf(searchBox));

        searchBox.sendKeys(searchQuery);
        buttonSearch.click();

        return new HomePage(webDriver);
    }

    public String getSearchResult() {
        wait.until(ExpectedConditions.visibilityOf(searchResult));
        return searchResult.getText();
    }
}