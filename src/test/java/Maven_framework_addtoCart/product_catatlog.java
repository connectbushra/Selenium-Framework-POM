package Maven_framework_addtoCart;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstract_class.Abstract_component;

public class product_catatlog extends Abstract_component{
	
	
WebDriver driver;
	
	public product_catatlog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);//this will trigger initialize element which will help element to initialize like-emial,password...etc
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement clickCart;
	
	By Prodcts_list=By.cssSelector(".mb-3");
	By addTocart=By.cssSelector("[class='btn w-10 rounded']");
	By toast=By.cssSelector("#toast-container");
	By animating=By.cssSelector(".ng-animating");
	
	public List<WebElement> getProductList()
	{
		wait_forElementAppear(Prodcts_list);
		return products;
	}
	
	public WebElement getProdctName(String product_name) 
	{
		
		  WebElement items=getProductList().stream().filter(s->s.findElement(By.cssSelector("b"))
		    		.getText().equals(product_name)).findFirst().get();
		  System.out.println(products.size()+items.getText());
		  return items;	  
	}
	
	public void product_addtocart(String product_name) throws InterruptedException
	{
		WebElement prod=getProdctName(product_name);
		Thread.sleep(3000);
		prod.findElement(addTocart).click();
		wait_forElementAppear(toast);
		wait_forElementDisappear(animating);	   
	}
	
	public void clickCart()
		{
			clickCart.click();
		}

}
