package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WithModalsPage extends BasePage {
    String pageUrl;

    @FindBy(className = "recommendation-modal__container")
    private WebElement recommendationModal;

    @FindBy(className = "recommendation-modal__close-button")
    private WebElement recommendationModalClose;

    @FindBy(xpath ="//div[@data-testid='POPUP']")
    private WebElement advertisementModal;

    public WithModalsPage(WebDriver driver, String pageUrl) {
        super(driver);
        this.pageUrl = pageUrl;
    }
    public WithModalsPage openPage() {
        webDriver.get(pageUrl);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("recommendation-modal__container")));
        closeModals();

        return this;
    }

    private void closeModals() {
        wait.until(ExpectedConditions.visibilityOf(recommendationModal));
        recommendationModalClose.click();
        wait.until(ExpectedConditions.invisibilityOf(recommendationModal));

        js.executeScript("window.scrollBy(0,500)", "");
        wait.until(ExpectedConditions.visibilityOf(advertisementModal));
        action.sendKeys(Keys.ESCAPE).perform();
        wait.until(ExpectedConditions.invisibilityOf(advertisementModal));
    }
}
