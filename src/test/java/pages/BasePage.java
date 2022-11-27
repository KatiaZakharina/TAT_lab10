package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    protected Actions action;

    protected abstract BasePage openPage();

    protected BasePage(WebDriver driver) {
        this.webDriver = driver;

        this.js = (JavascriptExecutor) driver;
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }
}