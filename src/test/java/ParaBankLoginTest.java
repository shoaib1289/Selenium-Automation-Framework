import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParaBankLoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void checkboxCanBeRemoved() {
        WebElement removeButton = driver.findElement(
                By.cssSelector("#checkbox-example button"));
        Assert.assertTrue(removeButton.isDisplayed(), "Button should be visible");
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        removeButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        Assert.assertEquals(driver.findElements(By.id("checkbox")).size(), 0);
        System.out.println("Checkbox removed successfully");
    }

    @Test
    public void inputCanBeEnabled() {
        WebElement textInput = driver.findElement(
                By.cssSelector("#input-example input[type='text']"));
        Assert.assertFalse(textInput.isEnabled(),
                "Input should be disabled initially");

        driver.findElement(By.cssSelector("#input-example button")).click();

        wait.until(d -> d.findElement(
                        By.cssSelector("#input-example input[type='text']"))
                .getAttribute("disabled") == null);

        WebElement enabledInput = driver.findElement(
                By.cssSelector("#input-example input[type='text']"));
        Assert.assertTrue(enabledInput.isEnabled(),
                "Input should be enabled after clicking Enable");

        enabledInput.sendKeys("Hello");
        System.out.println("Input is enabled and accepts text");
    }

    @AfterMethod                    // ← INSIDE the class
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}                                   // ← ONE closing brace, ends the class   // ← this ONE closing brace ends the class
// ← nothing after this