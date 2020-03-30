package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*; 

public class BaseTest {

	// Chrome driver - definition 
	{
		System.setProperty("webdriver.chrome.driver",
				"D:\\Shahar\\Java\\ChromeDriver\\chromedriver.exe");
	}

	// Constants definition
	final String PATH = "file:///D:/Shahar/Desktop/HiveFive/Main.html";

	// Declared  names for chrome driver and wait driver 
	protected static WebDriver driver;//= new ChromeDriver();
	protected WebDriverWait wait; //= new WebDriverWait(driver, 10);

	@BeforeTest 
	public void initlize() {
		// Create chrome driver and wait driver shows -  All test classes use this.
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);

		driver.manage().window().maximize();
		driver.get(PATH);
	}


	@AfterClass
	public static void terminate() {
		driver.quit();
	}
}