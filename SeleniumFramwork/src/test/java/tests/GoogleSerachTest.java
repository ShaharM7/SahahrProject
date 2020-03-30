package tests;

import pages.GoogleSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSerachTest {

	private static WebDriver driver;
	
	public static void main(String[] args) {
		googleSerach(); 
	}
	
	public static void googleSerach() {
		
		
		{
			System.setProperty("webdriver.chrome.driver",
					"D:\\Shahar\\Java\\eclipse\\SeleniumFramwork\\drivers\\chromeDriver\\chromedriver.exe");
		}

		final String PATH = "https://www.google.co.il/?hl=iw";

		driver = new ChromeDriver();
		
		// Go to googlchrome.com
		driver.get(PATH);
		driver.manage().window().maximize();
		
		GoogleSearchPage.searchBar(driver).sendKeys("Automation world");
		GoogleSearchPage.buttonSerach(driver).sendKeys(Keys.TAB);
	
		// Enter to the serchBar :"Automation world"
		//driver.findElement(By.name("q")).sendKeys("Automation world");

		// Click on the search button
		//WebElement searchButton = driver.findElement(By.name("btnK"));
		//searchButton.click();
		//searchButton.sendKeys(Keys.RETURN);

		// Close browser 
		driver.close();
		System.out.println("Test complited Successfully");
	}
}