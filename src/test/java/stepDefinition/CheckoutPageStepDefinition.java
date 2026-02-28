package stepDefinition;

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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
	public WebDriver driver;
	public String landingPageproductName;
	public String offerPageProductName;
	public CheckoutPage checkoutPage;//class variable
	TestContextSetup testcontextsetup;
	
	//We have to create a constructor(creating the method with same class name)
	public CheckoutPageStepDefinition(TestContextSetup testcontextsetup)
	{
		//this constructor method will automatically called when we will create object of the class
		this.testcontextsetup=testcontextsetup;
		this.checkoutPage= testcontextsetup.pageObjectManager.getCheckoutPage();
	}
	
	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order()
	{
		
		Assert.assertTrue(checkoutPage.VerifyPromoBtn());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
		System.out.println("Indranil mondal");
		System.out.println("Indranil mondal 2");
		System.out.println("Indranil mondal 5 ");
		System.out.println("Indranil mondal 8");
	
		
	}
	
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void User_proceeds_to_Checkout(String name) throws InterruptedException
	{
		checkoutPage.CheckoutItems();
		Thread.sleep(2000);
		//Assertionto extrack name from screen and compare with name
	}
	
	
	
}
