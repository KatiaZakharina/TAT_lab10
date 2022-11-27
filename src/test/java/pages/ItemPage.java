package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ItemPage extends WithModalsPage {
    public static String ITEM_PAGE_URL = "https://www.glistencosmetics.com/collections/palettes/products/pastel-split-liner";

    @FindBy(className = "product-single__cart-submit")
    private WebElement addToCartButton;

    @FindBy(className = "btn--view-cart")
    private WebElement viewCartButton;

    @FindBy(id = "CartCount")
    private WebElement cartAmountCounter;

    public ItemPage(WebDriver driver) {
        super(driver, ITEM_PAGE_URL);
    }

    public ItemPage openPage() {
        super.openPage();

        return this;
    }

    public ItemPage addItemToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();

        return this;
    }

    public String getAmountOfProducts() {
        wait.until(ExpectedConditions.visibilityOf(viewCartButton));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(cartAmountCounter, "0")));

        return cartAmountCounter.getText();
    }
}