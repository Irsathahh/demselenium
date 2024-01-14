package Browser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Browser extends variables {

	// Declaring the Explicit wait function
	public void explicit_wait(int num, By locator) {
		wait = new WebDriverWait(driver, num);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Declaring the Implicit wait
	public void implicit_wait(int num) {
		driver.manage().timeouts().implicitlyWait(num, TimeUnit.SECONDS);
	}

	// To Scroll Down
	public void Scroll(double nums) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		implicit_wait(3);

		js.executeScript("window.scroll(0," + nums * 1000 + ")");
	}

	// To Scroll Down
	public void Scroll(int nums) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		implicit_wait(3);

		js.executeScript("window.scroll(0," + nums * 1000 + ")");
	}

	// Taking the screenshot
	public void screenshot(String filename) {
		takescreenshot = (TakesScreenshot) driver;
		source = takescreenshot.getScreenshotAs(OutputType.FILE);
		path = System.getProperty("user.dir") + "\\screenshot\\" + filename + ".png";
		try {
			FileUtils.copyFile(source, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void properties() {
		prop = new Properties();

		try {
			prop.load(new FileInputStream(config_path));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Extend Report Function
	@BeforeSuite
	public void extentReport() {
		// start reporters
		htmlReporter = new ExtentHtmlReporter(report_path);

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		Browsertest = extent.createTest("Browser Verification", "Launching and closing Browser");
		LoginScenario = extent.createTest("Booking", "The process of booking and login validation");

	}

	@AfterSuite
	public void report() {
		extent.flush();
	}

	// Browser
	@BeforeTest
	public void invokeBrowser() {
		properties();
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose a valid browser \n 1)Chrome \n 2)FireFox \n 3)Edge ");

		selectbrowser = sc.nextInt();
		sc.close();
		// For ChromeDriver
		if (selectbrowser == 1) {
			System.setProperty(chromekey, chromepath);
			driver = new ChromeDriver();
			System.out.println("Chrome launched");

		}
		// For FireFoxDriver
		else if (selectbrowser == 2) {
			System.setProperty(firefoxkey, firefoxpath);
			driver = new FirefoxDriver();
			System.out.println("FireFox launched");
		}
		// For EdgeDriver
		else if (selectbrowser == 3) {
			System.setProperty(edgekey, edgepath);
			driver = new EdgeDriver();
			System.out.println("Edge launched");
		} else {
			System.out.println("Please choose valid browser");
		}

		// To maximize the Browser Window
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		implicit_wait(10);
		String Windowopened = driver.getWindowHandle();
		if (Windowopened == null) {
			Browsertest.fail("Browser setup Failed");
		} else if (!(Windowopened == null)) {
			Browsertest.pass("Browser setup passed");
		} else {
			Browsertest.info("Browsersetup is Not correct");
			System.out.println("Browsersetup problem");
		}
	}

	// Close the browser
	@AfterTest
	public void Browserclose() {
		driver.quit();

	}
}
