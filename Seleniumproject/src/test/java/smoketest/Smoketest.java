package smoketest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.*;

import basesearch.Searchtravel;

public class Smoketest {
	Searchtravel search = new Searchtravel();

	@BeforeSuite
	public void extendreport() {
		search.extentReport();
	}

	@BeforeTest
	public void browsersetup() {
		search.invokeBrowser();
	}

	@Test
	public void process() throws FileNotFoundException, IOException, InterruptedException {
		search.accessgetURL();
		search.BasedLocation();
		search.calculatingResultscreen();
		search.ticketselection();
		search.Login();
		search.accountcreation();
	}

	@AfterTest
	public void closebrowser() {
		search.Browserclose();
	}

	@AfterSuite
	public void closereport() {
		search.report();
	}

}
