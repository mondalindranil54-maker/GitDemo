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
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingPageproductName;
	public String offerPageProductName;
	TestContextSetup testcontextsetup;
	LandingPage landingPage;
	
	//We have to create a constructor(creating the method with same class name)
	public LandingPageStepDefinition(TestContextSetup testcontextsetup)
	{
		//this constructor method will automatically called when we will create object of the class
		this.testcontextsetup=testcontextsetup;
		this.landingPage = testcontextsetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
//		System.setProperty("webdriver.chrome.driver","C:\\Webdrivers\\chromedriver.exe");
//		testcontextsetup.driver = new ChromeDriver();//driver gets the life
//		testcontextsetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Assert.assertTrue(landingPage.getTiteLandingPage().contains("Greenkart"));
	}
	
	@When("^user searched with shortname (.+) and extract the original product$")
	public void user_searched_with_shortname_and_extract_the_original_product(String shortName) throws InterruptedException {
		
		Thread.sleep(4000);
		landingPage.searchItem(shortName);
	    Thread.sleep(4000);
	    testcontextsetup.landingPageproductName = landingPage.getProductName().split("-")[0].trim();
	    System.out.println(landingPageproductName +" is extracted from homepage");
	    System.out.println(" nengti is extracted from homepage");
	    System.out.println("Indranil Git branching");
	}
	
	@When("Added {string} items of the selected product to cart")
	public void added_items_product(String quantity)
	{
		landingPage.incrementQuantity(Integer.parseInt(quantity));//String converted to integer
		landingPage.addToCart();
	}
	
	
}
