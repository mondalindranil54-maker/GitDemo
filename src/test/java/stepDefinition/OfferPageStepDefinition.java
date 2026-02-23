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
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.GenericUtils;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	public WebDriver driver;
	public String landingPageproductName;
	public String offerPageProductName;
	TestContextSetup testcontextsetup;
	PageObjectManager pageObjectManager;
	public GenericUtils genericUtils;
	//Factory design Pattern
	//We have to create a constructor(creating the method with same class name)
		public OfferPageStepDefinition(TestContextSetup testcontextsetup)
		{
			//this constructor method will automatically called when we will create object of the class
			this.testcontextsetup=testcontextsetup;
		}
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException {
		switchToOffersPage();
		OffersPage offersPage = new OffersPage(testcontextsetup.driver);
		
		offersPage.searchItem(shortName);
	    Thread.sleep(2000);
	    offerPageProductName = offersPage.getProductName();
	}
	
	public void switchToOffersPage()
	{
		//pageObjectManager=new PageObjectManager(testcontextsetup.driver);
		LandingPage landingPage =testcontextsetup.pageObjectManager.getLandingPage();
		//if already switched to offers page-> skip below part
		//if(testcontextsetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"));
		//testcontextsetup.driver.findElement(By.linkText("Top Deals")).click();
		//LandingPage landingPage =new LandingPage(testcontextsetup.driver);
		landingPage.selectTopDealsPage();
		testcontextsetup.genericUtils.SwitchWindowToChild();
	}
	
	@Then("validate Product name in offers page matches with Landing Page")
	public void validate_Product_name_in_offers_page_matches_with_Landing_Page() {
		System.out.println("Landing: " + testcontextsetup.landingPageproductName );
		System.out.println("Offer: " + offerPageProductName);
		Assert.assertEquals(offerPageProductName, testcontextsetup.landingPageproductName);
	}
	
}
