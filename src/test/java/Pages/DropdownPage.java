package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {


    private By dropDownLocator= By.id("dropdown");

    public DropdownPage(WebDriver driver){
        super(driver);
    }

    public void selectOption(String visibletext){
        WebElement dropdownelement= driver.findElement(dropDownLocator);
        Select dropDown= new Select(dropdownelement);
        dropDown.selectByVisibleText(visibletext);
    }
    public String getselectedOption(){
        WebElement dropdownelement= driver.findElement(dropDownLocator);
        Select dropDown= new Select(dropdownelement);
        return dropDown.getFirstSelectedOption().getText();
    }
    public Boolean isselectdisplayed(){
        return isDisplayed(dropDownLocator);

    }
    public void goback(){
        navigateBack("/");
    }


}
