package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObject {
	
		// Members
		WebDriver driver = null;
		By searchBarName = By.name("q");
		By buttonSearchName = By.name("btnk");
		
		// Constructor
		public GoogleSearchPageObject(WebDriver driver) {
			this.driver = driver;
		}
		
		// Methods
		public void sendKeysINSerachBar(String text) {
			driver.findElement(searchBarName).sendKeys(text);
		}
		
		public void submitOnSearchButton() {
			driver.findElement(buttonSearchName).submit();
		}
}
