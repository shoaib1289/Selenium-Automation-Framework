package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TransferPage extends BasePage{
    private By amtBar= By.id("amount");
    private By fromacctBtn= By.id("FromAccountId");
    private By toacctBtn= By.id("ToAccountId");
    private By trnsfrBtn= By.xpath("//input[@value='Transfer']");
    private By confirmMsg=By.xpath("//h1[text()='Transfer Complete!']");

    public TransferPage(WebDriver driver){
        super(driver);

    }
    public void enterAmount(String amount){
       type(amtBar,amount);
    }
    public void selectFromAccount(String accountId) {
        selectByText(fromacctBtn, accountId);
        }
    public void selectToAccount(String accountId) {
        selectByText(toacctBtn, accountId);
    }
    public void clickTransfer() {
        click(trnsfrBtn);
        waitForConfirmation();
    }

    private void waitForConfirmation() {
        waitForVisibility(confirmMsg);
    }

    public boolean isTransferSuccessful() {
        return isDisplayed(confirmMsg);
    }

    public String getConfirmationText() {
        return getText(confirmMsg);
    }

    // In TransferPage — add this method
    public void selectFromAccountByIndex(int index) {
        WebElement element = driver.findElement(fromacctBtn);
        new Select(element).selectByIndex(index);
    }
    public void selectToAccountByIndex(int index) {
        WebElement element = driver.findElement(toacctBtn);
        new Select(element).selectByIndex(index);
    }

    public String getAmountTransferred(){
        return getText(amtBar);
    }


}
