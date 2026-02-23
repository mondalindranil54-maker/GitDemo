package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OffersPage {
	public WebDriver driver;

	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}

	private By search = By.xpath("//input[@type='search']");
	//private By productName = By.cssSelector("tr td:nth-child(1)");
	private By productName = By.cssSelector("tbody td:nth-child(1)");

	public void searchItem(String name) {
		//driver.findElement(search).sendKeys(name);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement box = wait.until(ExpectedConditions.elementToBeClickable(search));
		box.click();
		box.clear();
		box.sendKeys(name);
		box.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("tbody tr"),0));
	}

	public void getSearchText() {
		driver.findElement(search).getText();
	}

	public String getProductName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
		return driver.findElement(productName).getText();
	}

}
