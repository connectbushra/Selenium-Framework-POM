package Maven_framework_addtoCart;

import java.util.List;

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

public class AddtoCart_maven_framework {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String product_name="IPHONE 13 PRO";
		
//		System.setProperty("Webdriver.chrome.driver","C:\\Users\\2080947\\Downloads\\chromedriver_win32\\chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("userEmail")).sendKeys("bush@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Bushra@786");
		driver.findElement(By.id("login")).click();
	    List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	   
	    WebElement items=products.stream().filter(s->s.findElement(By.cssSelector("b"))
	    		.getText().equals(product_name)).findFirst().get();
	    System.out.println(products.size()+items.getText());
	    Thread.sleep(5000);
	    items.findElement(By.cssSelector("[class='btn w-10 rounded']")).click();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	    driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	    
	    List<WebElement> ProducTitle=driver.findElements(By.cssSelector(".cartSection h3"));
	    boolean match=ProducTitle.stream().anyMatch(s->s.getText().equalsIgnoreCase(product_name));
	    assertTrue(match);
	   
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector(".totalRow button")).click();
	    driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("india");
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list-group i")));
	    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

	   JavascriptExecutor js = (JavascriptExecutor) driver;
		// scroll window...............................
	   js.executeScript("window.scrollBy(0,1000)");
	   
	    Thread.sleep(500);
	   driver.findElement(By.cssSelector(".action__submit")).click();
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hero-primary")));
	   
	   String msg=driver.findElement(By.className("hero-primary")).getText();
	   Thread.sleep(1000);
	   assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	   System.out.println("THANKYOU FOR THE ORDER.");
	   driver.close();
	    

	}

}
