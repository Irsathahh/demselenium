package basesearch;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Browser.Browser;
import excel.Excel;

public class Searchtravel extends Browser {
	Excel exe;

	// Launching website
	@Test(priority = 0)
	public void accessgetURL() throws FileNotFoundException, IOException {
		properties();
		driver.get(prop.getProperty("Url"));
		explicit_wait(5, Bookpath);
		screenshot("Launching URL");
		PageFactory.initElements(driver, this);
		String books = bookpath.getText();
		if (books.equalsIgnoreCase("Book")) {
			LoginScenario.pass("URl process passed").addScreenCaptureFromPath(
					System.getProperty("user.dir") + "\\screenshot\\Launching URL.png", "URL Page");
		} else {
			LoginScenario.fail("URl process Failed").addScreenCaptureFromPath(
					System.getProperty("user.dir") + "\\screenshot\\Launching URL.png", "URL page Wrong");
		}
		LoginScenario.getStatus();

	}

	@Test(priority = 1)
	public void BasedLocation() {
		PageFactory.initElements(driver, this);
		Scroll(0.3);
		implicit_wait(5);
		StartDestination.click();
		Startjourney.sendKeys("Chennai");
		Startlocation.click();
		Destination.click();
		destinationjourney.sendKeys("Bangladesh");
		destinationlocate.click();
		Tripmode_1.click();
		trip_oneway.click();
		passanger_1.click();
		for (int i = 1; i < 3; i++) {
			threepassenger.click();
		}
		passengerconfirm.click();
		confirmpassenger.click();

	}

	@Test(priority = 2)
	public void calculatingResultscreen() throws IOException {
		exe = new Excel();
		By search1 = By.xpath("//h3/span[@class='label label-primary']");
		explicit_wait(5, search1);
		driver.findElement(By.xpath("(//div[@class='day-selection-header'])[6]")).click();
		implicit_wait(5);
		String secondpageinfo = driver.getTitle();
		datas = driver.findElements(By.className("montant"));
		for (int i = 0; i < datas.size(); i++) {
			System.out.println(datas.get(i).getText());
		}
		exe.useExcel("Prices");
		screenshot("Secondpage");
		assertEquals(secondpageinfo, "Search result");
		LoginScenario.pass("Navigation Successfull")
				.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\screenshot\\Secondpage.png");

	}

	@Test(priority = 3)
	public void ticketselection() throws IOException {
		PageFactory.initElements(driver, this);
		implicit_wait(3);
		String locations = locationstatus.getText();
		if (locations.equalsIgnoreCase("Chennai - Dhaka")) {
			LoginScenario.pass("Location status");

		} else {
			LoginScenario.fail("Location status");

		}
	}

	@Test(dependsOnMethods = "ticketselection")
	public void Login() throws InterruptedException, IOException {
		PageFactory.initElements(driver, this);
		driver.switchTo().frame("TopFrameId");
		driver.findElement(By.xpath("(//p[@class='font-normal font-roboto text-footerDescriptionBottomPart'])[2]"))
				.click();
		By accounts = By.xpath("(//a[@class='btn btn-primary btn-block'])[2]");
		explicit_wait(5, accounts);
		assertNotNull(accounts);
		screenshot("LoginSigninpage");
		if (driver.getTitle().equalsIgnoreCase("Login")) {
			LoginScenario.pass("Landed on Login Page")
					.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\screenshot\\LoginSigninpage.png");
		} else {
			LoginScenario.fail("Login pages")
					.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\screenshot\\LoginSigninpage.png");
		}

	}

	@Test(dependsOnMethods = "Login")
	public void accountcreation() throws InterruptedException, IOException {
		properties();
		exe = new Excel();
		// click on the create profile
		createaccountbutton.click();
		screenshot("Accountcreation");
		// Create new profile section
		loginid.sendKeys(exe.readExcel(0));
		pass.sendKeys(exe.readExcel(1));
		confirmpass.sendKeys(exe.readExcel(2));
		// personal info
		civilty.click();
		surename.sendKeys(exe.readExcel(3));
		firstname.sendKeys(exe.readExcel(4));
		email.sendKeys(exe.readExcel(5));
		// Dob.sendKeys(readExcel(6));
		// Phones
		phonehome.sendKeys("9984759344");
		phonecell.sendKeys("9809303034");
		phones.sendKeys("9458479557");
		// createbutton
		driver.findElement(By.xpath("//button[@id='btnCreateAction']")).click();
		implicit_wait(3);
		screenshot("Accountcreated");

	}

}
