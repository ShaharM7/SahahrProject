package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_GoogleSearch {

	public static void main(String[] args) {
		googleSerach(); 
	}
	
	public static void googleSerach() {
		{
			System.setProperty("webdriver.chrome.driver",
					"D:\\Shahar\\Java\\eclipse\\SeleniumFramwork\\drivers\\chromeDriver\\chromedriver.exe");
		}

		// Constant
		final String PATH = "https://www.google.co.il/?hl=iw";

		WebDriver driver = new ChromeDriver();

		// Go to googl.chrome
		driver.get(PATH);

		// Enter to the serchBar :"Automation world"
		driver.findElement(By.name("q")).sendKeys("Automation world");

		// Click on the search button
		WebElement searchButton = driver.findElement(By.name("btnK"));
		//searchButton.click();
		searchButton.sendKeys(Keys.RETURN);

		// Close browser 
		driver.close();
		System.out.println("Test complited Successfully");

	}

}