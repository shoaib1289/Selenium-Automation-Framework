package test;

import org.testng.annotations.BeforeMethod;
import Pages.CheckBoxPage;
import Pages.DropdownPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class InternetTest extends  BaseTest{


        private HomePage homePage;
        private DropdownPage dropdownPage;
        private CheckBoxPage checkBoxPage;
        @BeforeMethod
        public void setup(){
            driver.get("https://the-internet.herokuapp.com");
            homePage =new HomePage(driver);
        }
    @Test
    public void checkboxStateManagement() {
        // Navigate to checkboxes page
        homePage.gotoCheckbox();
        checkBoxPage = new CheckBoxPage(driver);

        // Verify initial state
        Assert.assertFalse(
                checkBoxPage.isCheckbox1Selected(),
                "Checkbox 1 should be unchecked initially"
        );
        Assert.assertTrue(
                checkBoxPage.isCheckbox2Selected(),
                "Checkbox 2 should be checked initially"
        );

        // Check checkbox 1
        checkBoxPage.checkCheckbox1();
        Assert.assertTrue(
                checkBoxPage.isCheckbox1Selected(),
                "Checkbox 1 should be checked after clicking"
        );

        // Uncheck checkbox 2
        checkBoxPage.uncheckCheckbox2();
        Assert.assertFalse(
                checkBoxPage.isCheckbox2Selected(),
                "Checkbox 2 should be unchecked after clicking"
        );

        System.out.println("Checkbox 1 selected: " + checkBoxPage.isCheckbox1Selected());
        System.out.println("Checkbox 2 selected: " + checkBoxPage.isCheckbox2Selected());
    }


}
