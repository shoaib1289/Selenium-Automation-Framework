package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SecurePage extends BasePage{

    private By succesMsg = By.cssSelector("div#flash");
    private By logoutButton = By.xpath("//a[@href='/logout']");

    public  SecurePage(WebDriver driver){
        super(driver);

    }
    public void clickLogout(){
        clickWithJS(logoutButton);
    }
    public boolean issuccessdisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(succesMsg));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public String getsuccessMssg(){
        return getText(succesMsg);
    }

}
