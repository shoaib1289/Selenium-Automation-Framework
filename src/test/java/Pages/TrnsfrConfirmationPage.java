package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrnsfrConfirmationPage extends BasePage{

    private By amountResult=
            By.xpath("//span[@id='amountResult']");
    private By fromacctresult=By.xpath("//span[@id='fromAccountIdResult']");
    private By toacctresult=By.xpath("//span[@id='toAccountIdResult']");

    public TrnsfrConfirmationPage(WebDriver driver){
        super(driver);
    }

    public String getAmountTransferred() {
        return getText(amountResult);
    }

    public String getFromAccount() {
        return getText(fromacctresult);
    }

    public String getToAccount() {
        return getText(toacctresult);
    }


}
