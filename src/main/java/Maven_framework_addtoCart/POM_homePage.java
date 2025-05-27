package Maven_framework_addtoCart;
import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import page_object_model.Landing_Page;

public class POM_homePage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String product_name="IPHONE 13 PRO";
		WebDriverManager.chromedriver().setup(); // Auto-downloads compatible ChromeDriver
	       
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Landing_Page lpPage=new Landing_Page(driver);
		lpPage.goTo();
		lpPage.loginApplication("bush@gmail.com","Bushra@786");
		
		product_catatlog product_catatlog=new product_catatlog(driver);
		List<WebElement> products=product_catatlog.getProductList();
	    product_catatlog.product_addtocart(product_name);
	    product_catatlog.clickCart();
	    CartPage cartPage=new CartPage(driver);
//	    Boolean match=cartPage.varifyProduct(product_name);
//	    assertTrue(match);
	    cartPage.clickCheckout();	
	    CheckoutPage cPage=new CheckoutPage(driver);
	    cPage.placeOrder();
	    String msg=cPage.successOrder();
	    assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	   System.out.println("THANKYOU FOR THE ORDER.");
	   driver.close();    

	}

}
