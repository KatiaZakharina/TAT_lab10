package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WithModalsPage extends BasePage {
    private static final int SCROLL_UNTIL_MODAL_OPENING = 500;

    String pageUrl;

    @FindBy(className = "recommendation-modal__container")
    private WebElement customerLocationModal;

    @FindBy(className = "recommendation-modal__close-button")
    private WebElement customerLocationModalClose;

    @FindBy(xpath ="//div[@data-testid='POPUP']")
    private WebElement discountOfferModal;

    public WithModalsPage(WebDriver driver, String pageUrl) {
        super(driver);
        this.pageUrl = pageUrl;
    }

    public WithModalsPage openPage() {
        webDriver.get(pageUrl);
        closeModals();

        return this;
    }

    private void closeModals() {
        wait.until(ExpectedConditions.visibilityOf(customerLocationModal));
        customerLocationModalClose.click();
        wait.until(ExpectedConditions.invisibilityOf(customerLocationModal));

        js.executeScript("window.scrollBy(0, arguments[0])", SCROLL_UNTIL_MODAL_OPENING);
        wait.until(ExpectedConditions.visibilityOf(discountOfferModal));
        action.sendKeys(Keys.ESCAPE).perform();
        wait.until(ExpectedConditions.invisibilityOf(discountOfferModal));
    }
}
