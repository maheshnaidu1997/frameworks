package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//input[@type='search']");
	By productName = By.xpath("//h4[@class='product-name']");
	By topDeals = By.linkText("Top Deals");
	By incrimentBtn = By.xpath("//a[@class='increment']");
	By addtoCart = By.xpath("//button[text()='ADD TO CART']");

	public void searchItem(String name) {

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(search).sendKeys(name);

	}

	public String getSearchText() {

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver.findElement(productName).getText();

	}

	public void topDealsPage() {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(topDeals).click();
	}

	public void incrimentQuantity(int quantity) {
		int n = quantity;
		for (int i = 0; i < n; i++) {
			driver.findElement(incrimentBtn).click();
		}
	}

	public void AddToCart() {
		driver.findElement(addtoCart).click();
		
	}

}
