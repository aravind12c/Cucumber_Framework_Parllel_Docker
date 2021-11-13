package com.flink.stepDefinitions;

import com.flink.pageObjects.BuyProduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlinkWebStepDef {

	@Given("I am on the homescreen")
	public void iamOnHomeScreen() {
		BuyProduct.presenceOfHomeScreen();
	}

	@When("I click on Buy option on suncreen or Moisturizers based on the temprature")
	public void iClickOnBuyProductCategoryBasedOnTemp() {
		BuyProduct.clickOnBuyProduct();
		BuyProduct.presenceOfAptProductCategoryScreen();
	}

	@And("I add less expensive product from two product types and click on Cart")
	public void iAddLessExpensiveProductFromTwoProductTypes() {
		BuyProduct.addLessExpensiveProducts();
		BuyProduct.clickOnCart();
	}

	@And("I verify added products are available in cart")
	public void iVerifyAddedProductsInCart() {
		BuyProduct.verifyAddedProducts();
	}

	@Then("I verify the total product cost is shown correctly")
	public void iVerifyTotProductCostShown() {
		BuyProduct.verifyTotalProductCost();
	}

	@And("I click on pay with card button")
	public void iClickOnPayCardBtn() {
		BuyProduct.clickOnPayCardBtn();
	}

	@When("I enter email and card details and Click on pay")
	public void iEntercardandEmailDetails() {
		BuyProduct.sendOnEmailandCardDetails();
		BuyProduct.clickOnPay();
	}

	@And("I verify whether payment is done successfully")
	public void iVerifyPaymentSuccessMsg() {
		BuyProduct.verifyPaymentSuccessMsg();
	}
}