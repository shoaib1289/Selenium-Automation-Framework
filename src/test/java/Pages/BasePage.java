package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.Urls;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));

    }

    protected void clickWithJS(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }


    protected String getText(By locator) {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }
    protected void verify(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    protected void type(By locator, String text) {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(locator)).sendKeys(text);
    }


    protected boolean isDisplayed(By locator){
        return driver.findElements(locator).size()>0;

    }
    protected void waitForUrl(String urlFragment) {
        wait.until(ExpectedConditions.urlContains(urlFragment));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    protected void navigateBack(String urlFragment) {
        driver.navigate().back();
        waitForUrl(urlFragment);    // wait for the previous page URL to appear
    }
    protected void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void selectByText(By locator, String visibleText) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
        new Select(element).selectByVisibleText(visibleText);
    }
    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


}
