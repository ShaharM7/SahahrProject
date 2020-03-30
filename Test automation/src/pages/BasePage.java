package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BasePage {

	// Variable definition
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected SoftAssert softAssertion;

	// Constructor
	public BasePage (WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver,10);
		this.softAssertion = new SoftAssert();

		// Page factory
		PageFactory.initElements(driver, this);
	}

	///////////////////////////////////////////// Methods /////////////////////////////////////////////

	// Wait visibility Method
	public void waitVisibility(By elementBy) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
	}

	// Wait Clickable Method 
	public void waitClickable(By elementBy) {
		wait.until(ExpectedConditions.elementToBeClickable(elementBy));
	}

	//Click Method
	public void click (By elementBy) {
		waitClickable(elementBy);
		driver.findElement(elementBy).click();
	}

	// Submit Method
	public void submit (By elementBy) {
		driver.findElement(elementBy).submit();
	}

	// Write Text - sendKeys
	public void writeText (By elementBy, String text) {
		waitVisibility(elementBy);
		driver.findElement(elementBy).sendKeys(text);
	}

	// Read Text - getText
	public String readText (By elementBy) {
		waitVisibility(elementBy);
		return (driver.findElement(elementBy).getText());
	}

	// Hard Assert
	public void hardAssertEquals (By elementBy, String expectedText) {
		waitVisibility(elementBy);
		Assert.assertEquals(readText(elementBy), expectedText);
	}

	// Soft Assert
	public void softAssertEquals (By elementBy, String expectedText) {
		waitVisibility(elementBy);
		softAssertion.assertEquals(readText(elementBy), expectedText);
	}
}