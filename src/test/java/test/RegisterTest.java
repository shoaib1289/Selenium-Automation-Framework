package tests;

import Pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {

    private WebDriver driver;
    private RegisterPage registerPage;      // ← field, not extends

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        registerPage = new RegisterPage(driver);  // ← create it here
    }

    @Test
    public void successfulRegistration() {
            String username = "testuser" + System.currentTimeMillis();

            registerPage.fillForm(
                    "John", "Doe", "123 Main St", "Toronto",
                    "ON", "M1M1M1", "4161234567", "123456789",
                    username, "Pass123!", "Pass123!"
            );
            registerPage.clickRegister();


// Now check what actually appeared
        System.out.println("Page heading: " + driver.findElement(By.cssSelector("#rightPanel h1")).getText());
        }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}