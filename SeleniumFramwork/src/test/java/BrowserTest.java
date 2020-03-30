

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {

	public static void main(String[] args) {
		{
			
			System.setProperty("webdriver.chrome.driver",
					"D:\\Shahar\\Java\\eclipse\\SeleniumFramwork\\drivers\\chromeDriver\\chromedriver.exe");
		
		}
		WebDriver driver = new ChromeDriver();
		
		// Constant 
		final String PATH = "https://www.google.co.il/?hl=iw";
		
		//  Code Section
		driver.get(PATH);
		driver.manage().window().maximize();
		
		WebElement serachBar = driver.findElement(By.xpath("//input[@name='q']"));
		serachBar.sendKeys("Automation world");
		serachBar.submit();
		
		List<WebElement> lsitOfInputElement = driver.findElements(By.xpath("//input"));
		int count = lsitOfInputElement.size();
		System.out.println("Count of Input Elemnts : " + count);
	}
}