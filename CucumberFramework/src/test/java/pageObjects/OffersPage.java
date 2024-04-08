package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

	WebDriver driver;

	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//input[@type='search']");
	By productName = By.xpath("//td[1]");
	
	
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
		
	}
	
public String getSearchText()
{
return driver.findElement(productName).getText();


}

}
