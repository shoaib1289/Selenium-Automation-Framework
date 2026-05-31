package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By firstName     = By.id("customer.firstName");
    private By lastName      = By.id("customer.lastName");
    private By address       = By.id("customer.address.street");
    private By city          = By.id("customer.address.city");
    private By state         = By.id("customer.address.state");
    private By zipcode       = By.id("customer.address.zipCode");
    private By phoneNumber   = By.id("customer.phoneNumber");
    private By ssn           = By.id("customer.ssn");
    private By usernameField = By.id("customer.username");
    private By password      = By.id("customer.password");
    private By confirm       = By.id("repeatedPassword");
    private By registerBtn = By.cssSelector("input[value='Register']");
    private By successMsg    = By.cssSelector("#rightPanel p");
    private By welcomeMsg    = By.cssSelector("#rightPanel h1");
    private By errorMsg      = By.cssSelector(".error");

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public void fillForm(String firstNameVal, String lastNameVal,
                         String addressVal, String cityVal, String stateVal,
                         String zipcodeVal, String phoneVal, String ssnVal,
                         String usernameVal, String passwordVal,
                         String confirmPasswordVal) {

        driver.findElement(firstName).sendKeys(firstNameVal);
        driver.findElement(lastName).sendKeys(lastNameVal);
        driver.findElement(address).sendKeys(addressVal);
        driver.findElement(city).sendKeys(cityVal);
        driver.findElement(state).sendKeys(stateVal);
        driver.findElement(zipcode).sendKeys(zipcodeVal);
        driver.findElement(phoneNumber).sendKeys(phoneVal);
        driver.findElement(ssn).sendKeys(ssnVal);
        driver.findElement(usernameField).sendKeys(usernameVal);
        driver.findElement(password).sendKeys(passwordVal);
        driver.findElement(confirm).sendKeys(confirmPasswordVal);
    }

    public void clickRegister() {
        driver.findElement(registerBtn).click();
        // NO wait here — let the test decide what to wait for
    }

    // State checks
    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
        return driver.findElement(successMsg).getText();
    }

    public String getWelcomeMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMsg));
        return driver.findElement(welcomeMsg).getText();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
        return driver.findElement(errorMsg).getText();
    }

    public boolean isErrorDisplayed() {
        return driver.findElements(errorMsg).size() > 0;
    }
}