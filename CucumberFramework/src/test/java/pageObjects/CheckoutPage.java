package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage {

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	By cartbag = By.xpath("//img[@alt='Cart']");
	By checkoutbutton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By promobtn = By.xpath("//div[@class='promoWrapper']/button");
	By placeorder = By.xpath("//button[text()='Place Order']");
	By itemname = By.xpath("//p[@class='product-name']");
	By addtoCart = By.xpath("//button[text()='ADD TO CART']");
	
	public void CheckoutItems(String name) throws InterruptedException
	{
		driver.findElement(addtoCart).click();
		driver.findElement(cartbag).click();
		driver.findElement(checkoutbutton).click();
		Thread.sleep(2000);
		
	//Assert.assertTrue(driver.findElement(itemname).getText().contains("name"));	
		
	}
	
	public boolean VarifyPromoBtn ()
	{
		return driver.findElement(promobtn).isDisplayed();
	}
	
	public boolean VarifyPlaceOrder()
	{
		return driver.findElement(placeorder).isDisplayed();
	}
	
}
