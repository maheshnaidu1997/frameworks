package stepDefinations;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefination {

	
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	public PageObjectManager pageObjectManager;
	
	public OfferPageStepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	
	
	
	//OffersPage offerspage = new OffersPage(testContextSetup.driver);
			

	@Then("^user searched for (.+) shortname in offerspage$")
	public void user_searched_for_same_shortname_in_offerspage_to_check_if_product_exist(String shortName) {
		
		switchToOffersPage();
		
		testContextSetup.pageObjectManager.getOffersPage();
		
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		offersPage.searchItem(shortName);
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		  try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		offerPageProductName = offersPage.getSearchText();

	}

	@Then("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(testContextSetup.landingPageProductName, offerPageProductName);
	}

	
	public void switchToOffersPage()
	{
		
		//pageObjectManager = new PageObjectManager(testContextSetup.driver);
		//pageObjectManager.getLandingPage();
		testContextSetup.pageObjectManager.getLandingPage();
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		//LandingPage landingPage = new LandingPage(testContextSetup.driver);
		
		landingPage.topDealsPage();
		//testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		//testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//Set<String> s1 =testContextSetup.driver.getWindowHandles();
		//Iterator<String> i1 = s1.iterator();
		//String parentWindow = i1.next();
		//String childWindow = i1.next();
		//testContextSetup.driver.switchTo().window(childWindow);
		
		testContextSetup.genericUtils.SwitchWindowToChild();
		
		
	}
	
	
	
	
	
	
}
