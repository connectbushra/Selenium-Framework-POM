package Maven_framework_addtoCart;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import page_object_model.Landing_Page;

public class POM_homePage {

    ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        reporter.config().setReportName("Automation Report");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Bushra");
    }

    @Test
    public void addToCartTest() throws InterruptedException {
        test = extent.createTest("Add To Cart Test");

        String product_name = "IPHONE 13 PRO";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            Landing_Page lpPage = new Landing_Page(driver);
            lpPage.goTo();
            lpPage.loginApplication("bush@gmail.com", "Bushra@786");

            product_catatlog product_catatlog = new product_catatlog(driver);
            List<WebElement> products = product_catatlog.getProductList();
            product_catatlog.product_addtocart(product_name);
            product_catatlog.clickCart();

            CartPage cartPage = new CartPage(driver);
            cartPage.clickCheckout();

            CheckoutPage cPage = new CheckoutPage(driver);
            cPage.placeOrder();

            String msg = cPage.successOrder();
            assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
            test.pass("Order placed successfully");
            System.out.println("THANKYOU FOR THE ORDER.");

        } catch (Exception e) {
            test.fail("Test failed due to: " + e.getMessage());
            throw e;
        } finally {
            driver.quit();
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush(); // Important: this writes the report
    }
}
