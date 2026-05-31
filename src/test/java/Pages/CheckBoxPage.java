package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage extends BasePage {

    private By checkboxes = By.cssSelector("input[type='checkbox']");

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckbox1Selected() {
        return driver.findElements(checkboxes).get(0).isSelected();
    }

    public boolean isCheckbox2Selected() {
        return driver.findElements(checkboxes).get(1).isSelected();
    }

    public void checkCheckbox1() {
        WebElement cb1 = driver.findElements(checkboxes).get(0);
        if (!cb1.isSelected()) {
            cb1.click();
        }
    }

    public void uncheckCheckbox2() {
        WebElement cb2 = driver.findElements(checkboxes).get(1);
        if (cb2.isSelected()) {
            cb2.click();
        }
    }

    public void checkCheckbox2() {
        WebElement cb2 = driver.findElements(checkboxes).get(1);
        if (!cb2.isSelected()) {
            cb2.click();
        }
    }
}