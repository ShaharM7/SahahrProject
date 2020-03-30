package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;

import gss.GetScreenshot;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reporter {
	// TODO: Handle parallel reporting
	// Creating a method getScreenshot and passing two parameters 
	// driver and screenshotName
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
	private static final String REPORT_PATH = "D:\\Shahar\\Desktop\\Eclipse\\Reports";

	private static WebDriver driver;
	private static ExtentReports extentReports;
	private static ExtentHtmlReporter extentHtmlReporter;
	private static ExtentTest extentTest;
	
	public static void initialize() {
		LocalDateTime now = LocalDateTime.now();
		extentHtmlReporter = new ExtentHtmlReporter(REPORT_PATH + "Report " + dateTimeFormatter.format(now) + ".html");

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
	}
	
	public static void initialize(WebDriver driver) {
		initialize();
		Reporter.driver = driver;
	}

	public static void createTest(String testName) {
		extentTest = extentReports.createTest(testName);
	}

	public static void passStep(String description) {
		passStep(description, null);
	}

	public static void passStep(String description, String imageName) {
		log(Status.PASS, description, imageName);
	}

	public static void failStep(String description) {
		failStep(description, null);
	}

	public static void failStep(String description, String imageName) {
		log(Status.FAIL, description, imageName);
	}

	public static void infoStep(String description) {
		infoStep(description, null);
	}

	public static void infoStep(String description, String imageName) {
		log(Status.INFO, description, imageName);
	}

	public static void skipStep(String description) {
		log(Status.SKIP, description);
	}
	
	private static void log(Status status, String description) {
		Reporter.log(status, description, null);
	}

	private static void log(Status status, String description, String imageName) {
		if (extentTest == null) {
			throw (new NullPointerException("Before you log a step, you need to create a test."));
		}
		else {
			MediaEntityModelProvider screenshot = getScreenshotAsMediaEntityModel(imageName
					+ System.currentTimeMillis());

			description = description.replace("\n", "<br>");

			if (screenshot == null) {
				extentTest.log(status, description);
			}
			else {
				extentTest.log(status, description, screenshot);
			}
		}
	}

	private static MediaEntityModelProvider getScreenshotAsMediaEntityModel(String imageName) {
		if (imageName == null) {
			return (null);
		}

		try {
			return (MediaEntityBuilder.createScreenCaptureFromPath(
					GetScreenshot.Capture(driver, imageName)).build());
		}
		catch (IOException ex) {
			infoStep("Could not get " + imageName + " screenshot.");
			return (null);
		}
	}
	
	public static void setTestAuthor(String name) {
		if (extentTest != null) {
			extentTest.assignAuthor(name);
		}
		else {
			throw (new NullPointerException("Before performing this action you must create a test."));
		}
	}

	public static void setTestCategory(String name) {
		if (extentTest != null) {
			extentTest.assignCategory(name);
		}
		else {
			throw (new NullPointerException("Before performing this action you must create a test."));
		}
	}

	public static void setReportName(String name) {
		extentHtmlReporter.config().setReportName(name);
	}

	public static void setDocumentTitle(String name) {
		extentHtmlReporter.config().setDocumentTitle(name);
	}

	public static void setDarkTheme() {
		extentHtmlReporter.config().setTheme(Theme.DARK);
	}

	public static void setLightTheme() {
		extentHtmlReporter.config().setTheme(Theme.STANDARD);
	}

	public static void setSystemInfo(String key, String value) {
		extentReports.setSystemInfo(key, value);
	}

	public static void setDriver(WebDriver driver) {
		Reporter.driver = driver;
	}

	public static void generateReport() {
		if (extentReports != null) {
			extentReports.flush();
		}
	}
}
