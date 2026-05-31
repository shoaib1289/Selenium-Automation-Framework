package test;

import Pages.LoginPage;
import Pages.SecurePage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private SecurePage securePage;

    @BeforeMethod
    public void setUpPage() {
        driver.get(ConfigReader.get("baseUrl") + "/login");
        loginPage = new LoginPage(driver);
        test.log(Status.INFO, "Navigated to login page");
    }
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                { "tomsmith", "SuperSecretPassword!", true  },
                { "wronguser", "wrongpass",           false },
                { "tomsmith",  "wrongpass",           false }
        };
    }



    @Test(dataProvider = "loginData")
    public void loginWithVariousCredentials(String username,
                                            String password,
                                            boolean shouldSucceed) {

        test.log(Status.INFO, "Testing login — username: " + username +
                " | expected success: " + shouldSucceed);

        loginPage.logIn(username, password);

        if (shouldSucceed) {
            securePage = new SecurePage(driver);

            Assert.assertTrue(
                    loginPage.getCurrentUrl().contains("/secure"),
                    "URL should contain /secure for valid login"
            );
            Assert.assertTrue(
                    securePage.issuccessdisplayed(),
                    "Success message should be visible"
            );

            test.log(Status.INFO, "Success: " + securePage.getsuccessMssg());
            System.out.println("PASS — logged in as: " + username);

        } else {
            Assert.assertFalse(
                    loginPage.getCurrentUrl().contains("/secure"),
                    "URL should NOT contain /secure for invalid login"
            );
            Assert.assertTrue(
                    loginPage.isErrorDisplayed(),
                    "Error message should be visible"
            );

            test.log(Status.INFO, "Error: " + loginPage.geterrormssg());
            System.out.println("PASS — error shown for: " + username);
        }
    }

    @Test
    public void invalidLoginShowsError() {
        test.log(Status.INFO, "Logging in with invalid credentials");
        loginPage.logIn("wronguser", "wrongpassword");

        test.log(Status.INFO, "Verifying error message appears");
        Assert.assertTrue(
                loginPage.isErrorDisplayed(),
                "Error message should appear for invalid credentials"
        );
        Assert.assertFalse(
                loginPage.getCurrentUrl().contains("/secure"),
                "Should not navigate to secure page"
        );

        test.log(Status.PASS, "Invalid login error verified");
        System.out.println("Error: " + loginPage.geterrormssg());
    }
}