package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage extends BasePage {

    private By transferFunds= By.xpath("//a[contains(text(),'Transfer')]");

    public AccountsPage(WebDriver driver){
        super(driver);

    }

    public void clicktrnsfr(){
        clickWithJS(transferFunds);
        waitForUrl("/transfer");
    }



}
