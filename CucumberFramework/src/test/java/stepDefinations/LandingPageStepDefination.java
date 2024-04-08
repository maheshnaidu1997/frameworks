package stepDefinations;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LandingPageStepDefination {

	// public WebDriver driver;
	// public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	public LandingPage landingPage;

	public LandingPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		// testContextSetup.driver = new ChromeDriver();
		// testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@When("^user searched with a shortname (.+) and extracted the actual name of product$")
	public void user_searched_with_a_shortname_and_extracted_the_actual_name_of_product(String shortName) {
		// testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// LandingPage landingPage = new LandingPage(testContextSetup.driver);

		// PageObjectManager pageObjectManager = new
		// PageObjectManager(testContextSetup.driver);

		// pageObjectManager.getLandingPage();
		//3testContextSetup.pageObjectManager.getLandingPage();
		//LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();

		landingPage.searchItem(shortName);

		// testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testContextSetup.landingPageProductName = landingPage.getSearchText().split("-")[0].trim();

		System.out.println(testContextSetup.landingPageProductName + " is extracted from homepage");

	}

	@And("Added {string} items of selected product to cart")
	public void Added_items_of_selected_product_to_cart(String quantity)
	{
		landingPage.incrimentQuantity(Integer.parseInt(quantity));
	}
	
	
	
	
	
	
}
