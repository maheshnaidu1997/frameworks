package stepDefinations;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutStepDefination {

	public TestContextSetup testContextSetup;
	public CheckoutPage checkoutPage;

	public CheckoutStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.GetCheckoutPage();
	}

	@And("Varify user has ability to enter promo code and place the order")
	public void Varify_user_has_ability_to_enter_promo_code_and_place_the_order() {
		// testContextSetup.pageObjectManager.GetCheckoutPage();
		// CheckoutPage checkoutPage =
		// testContextSetup.pageObjectManager.GetCheckoutPage();

		Assert.assertTrue(checkoutPage.VarifyPromoBtn());

		Assert.assertTrue(checkoutPage.VarifyPlaceOrder());
	}

	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void User_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) throws InterruptedException {
		checkoutPage.CheckoutItems(name);
		Thread.sleep(2000);

	}
}
