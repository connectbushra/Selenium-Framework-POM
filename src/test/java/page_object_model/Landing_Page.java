package page_object_model;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_class.Abstract_component;
import net.bytebuddy.asm.Advice.This;

	
public class Landing_Page extends Abstract_component {
	
	WebDriver driver;
	
	public Landing_Page(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);   //this will trigger initialize element which will help element to initialize like-emial,password...etc
	}
	
//	driver.findElement(By.id("userEmail")).sendKeys("bush@gmail.com");
	
//	Page_Factory...........
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	public void loginApplication(String email,String pwd)
	{
		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	
}

	