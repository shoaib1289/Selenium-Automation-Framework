package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class    BaseTest {

    protected WebDriver driver;
    protected ExtentTest test;
    private static ExtentReports extent;

    @BeforeSuite
    public void setUpReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(
                "reports/TestReport.html"
        );
        reporter.config().setReportName("Automation Test Report");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Tester",      ConfigReader.get("tester"));
        extent.setSystemInfo("Environment", ConfigReader.get("environment"));
        extent.setSystemInfo("Browser",     ConfigReader.get("browser"));
        extent.setSystemInfo("Base URL",    ConfigReader.get("baseUrl"));
    }

    @BeforeMethod
    public void setUp(Method method) {
        String browser = ConfigReader.get("browser");

        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();

        test = extent.createTest(method.getName());
        test.log(Status.INFO, "Browser opened: " + browser);
        test.log(Status.INFO, "Test started: " + method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL,
                    "Test FAILED: " + result.getThrowable().getMessage());

            try {
                File src = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                        .format(new Date());
                String screenshotPath = "reports/screenshots/"
                        + result.getName() + "_" + timestamp + ".png";
                FileUtils.copyFile(src, new File(screenshotPath));
                test.addScreenCaptureFromPath(screenshotPath,
                        "Failure Screenshot");
                test.log(Status.INFO,
                        "Screenshot saved: " + screenshotPath);
            } catch (IOException e) {
                test.log(Status.WARNING,
                        "Screenshot failed: " + e.getMessage());
            }

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test PASSED");

        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test SKIPPED");
        }

        if (driver != null) {
            driver.quit();
            test.log(Status.INFO, "Browser closed");
        }
    }

    @AfterSuite
    public void tearDownReport() {
        if (extent != null) {
            extent.flush();
            System.out.println("====================================");
            System.out.println("Report: reports/TestReport.html");
            System.out.println("====================================");
        }
    }
}