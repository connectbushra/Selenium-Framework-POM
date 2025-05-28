package Maven_framework_addtoCart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_class.Abstract_component;

public class CartPage extends Abstract_component{
	



WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);//this will trigger initialize element which will help element to initialize like-emial,password...etc
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProduct;
	
	@FindBy(css=".totalRow button")
	WebElement checkhoutButton;
	
	public Boolean varifyProduct(String prod)
	{
		 boolean match=cartProduct.stream().anyMatch(s->s.getText().equalsIgnoreCase(prod));
		return match;
		   
	}
	public void clickCheckout() throws InterruptedException
	{
		Thread.sleep(3000);
		checkhoutButton.click();
		
		
	
}

}
