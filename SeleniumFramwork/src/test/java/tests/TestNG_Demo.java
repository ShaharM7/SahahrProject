package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo {

	WebDriver driver = null;

	@BeforeTest
	public void setUp() {
		{
			System.setProperty("webdriver.chrome.driver",
					"D:\\Shahar\\Java\\eclipse\\SeleniumFramwork\\drivers\\chromeDriver\\chromedriver.exe");
		}

		// Constant
		final String PATH = "https://www.google.co.il/?hl=iw";
		
		// Code section
		
		driver = new ChromeDriver();
		driver.get(PATH);
		driver.manage().window().maximize();
	}


	@Test
	public void googleSerach() {
		
		// Enter to the serchBar :"Automation world"
		driver.findElement(By.name("q")).sendKeys("Automation world");

		// Click on the search button
		WebElement searchButton = driver.findElement(By.name("btnK"));
		//searchButton.click();
		searchButton.sendKeys(Keys.RETURN);
	}

	@AfterTest
	public void terminate() {
		// Close browser 
		driver.close();
		driver.quit();
		System.out.println("Test complited Successfully");
	}

}