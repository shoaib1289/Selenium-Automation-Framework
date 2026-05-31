package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private By checkbox= By.cssSelector("a[href='/checkbox']");
    private  By dropDown=By.cssSelector("a[href='/dropdown']");

    public HomePage(WebDriver driver) {
        super(driver);    // calls BasePage constructor — sets up driver and wait
    }
    public void gotoCheckbox(){
        clickWithJS(checkbox);
        waitForUrl("/checkbox");

    }
   public void gotodropDown(){
        clickWithJS(dropDown);
        waitForUrl("/dropdown");
    }
}
