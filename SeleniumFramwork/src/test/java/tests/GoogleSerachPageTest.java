package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObject;

public class GoogleSerachPageTest {
	
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearchTest();
	}
	
	public static void googleSearchTest() {
		{
			System.setProperty("webdriver.chrome.driver",
					"D:\\Shahar\\Java\\eclipse\\SeleniumFramwork\\drivers\\chromeDriver\\chromedriver.exe");
		}

		driver = new ChromeDriver();
		
		GoogleSearchPageObject serachPageObj = new GoogleSearchPageObject(driver);
		
		driver.get("https://www.google.co.il/");
		
		serachPageObj.sendKeysINSerachBar("A B C D");
		serachPageObj.submitOnSearchButton();
		
		driver.close();
	}
}
