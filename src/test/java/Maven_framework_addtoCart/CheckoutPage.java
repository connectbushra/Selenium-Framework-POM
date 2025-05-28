package Maven_framework_addtoCart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_class.Abstract_component;

public class CheckoutPage extends Abstract_component{
	

WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);//this will trigger initialize element which will help element to initialize like-emial,password...etc
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement city;
	
	By list_group=By.cssSelector(".list-group i");
//	By heroPrimary=By.className("hero-primary");
	
	@FindBy(className="hero-primary")
	WebElement heroPrimary;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement CityButton;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	public void placeOrder() throws InterruptedException
	{
		city.sendKeys("india");
		wait_forElementAppear(list_group);
		CityButton.click();
		// scroll window...............................

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		submit.click();		
}
	
	public String successOrder() throws InterruptedException
	{
		Thread.sleep(2000);	   
		 String msg=heroPrimary.getText();	
		 return msg;
	}
}
