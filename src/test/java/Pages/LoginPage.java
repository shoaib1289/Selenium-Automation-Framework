package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage{


    private By userName= By.name("username");
    private By passWord=By.name("password");
    private By logInBut = By.cssSelector("button[type='submit']");
    private By errorMssg = By.id("flash");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void enterUsername(String username) {
        type(userName, username);    // what goes in the blanks?


    }
    public void enterPassword(String password) {
        type(passWord, password);    // what goes in the blanks?
    }
    public void clickLogin() {
        clickWithJS(logInBut);    // use JS click instead of regular click
    }
    public boolean isErrorDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMssg));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String geterrormssg(){
        return getText(errorMssg);
    }
    public void logIn(String username,String password){
        type(userName,username);
        type(passWord,password);
        clickLogin();

    }
    public void waitForSecurePage() {
        waitForUrl("/secure");
    }

}
