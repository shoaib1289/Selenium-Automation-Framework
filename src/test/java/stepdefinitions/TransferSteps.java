package stepdefinitions;

import Pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utils.ConfigReader;

public class TransferSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private AccountsPage accountsPage;
    private TransferPage transferPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("baseUrl") + "/parabank/login.htm");
        loginPage = new LoginPage(driver);
    }

    @Given("I am logged in as {string} with password {string}")
    public void iAmLoggedInAs(String username, String password) {
        loginPage.logIn(username, password);
        Assert.assertTrue(
                loginPage.getCurrentUrl().contains("overview"),
                "Should be on overview page after login"
        );
        accountsPage = new AccountsPage(driver);
    }

    @When("I navigate to Transfer Funds page")
    public void iNavigateToTransferFunds() {
        accountsPage.clicktrnsfr();
        transferPage = new TransferPage(driver);
        Assert.assertTrue(
                transferPage.getCurrentUrl().contains("transfer"),
                "Should be on transfer page"
        );
    }

    @And("I select the first account as source")
    public void iSelectFirstAccountAsSource() {
        transferPage.selectFromAccountByIndex(0);
    }

    @And("I select the second account as destination")
    public void iSelectSecondAccountAsDestination() {
        transferPage.selectToAccountByIndex(1);
    }

    @And("I enter transfer amount {string}")
    public void iEnterTransferAmount(String amount) {
        transferPage.enterAmount(amount);
    }

    @And("I click the Transfer button")
    public void iClickTransferButton() {
        transferPage.clickTransfer();
    }

    @Then("the transfer should be successful")
    public void theTransferShouldBeSuccessful() {
        Assert.assertTrue(
                transferPage.isTransferSuccessful(),
                "Transfer confirmation should be displayed"
        );
    }

    @And("the amount transferred should be {string}")
    public void theAmountTransferredShouldBe(String expectedAmount) {
        Assert.assertEquals(
                transferPage.getAmountTransferred(),
                expectedAmount,
                "Amount transferred should match expected"
        );
        System.out.println("Transferred: " + transferPage.getAmountTransferred());
        System.out.println("Confirmation: " + transferPage.getConfirmationText());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
