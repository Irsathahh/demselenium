package Browser;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class variables {
	public TakesScreenshot takescreenshot;
	public File source;
	public String path;
	public static ExtentTest Browsertest;
	public static ExtentTest LoginScenario;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public static Properties prop;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public int selectbrowser;
	public String report_path = System.getProperty("user.dir")+"\\target\\FinalReport\\SeleniumExtentreport.html";
	public String config_path = System.getProperty("user.dir")+"\\Configuration\\Config.properties";
	public String chromekey = "webdriver.chrome.driver";
	public String chromepath = "C:\\Users\\2252171\\OneDrive - Cognizant\\Desktop\\chromedriver.exe";
	public String firefoxkey = "webdriver.gecko.driver";
	public String firefoxpath = "C:\\Users\\2252171\\OneDrive - Cognizant\\Desktop\\geckodriver.exe";
	public String edgekey = "webdriver.edge.driver";
	public String edgepath = "C:\\Users\\2252171\\OneDrive - Cognizant\\Desktop\\msedgedriver.exe";
	//searchtravel
	public By Bookpath = By.xpath("//*[@id='__next']/div[3]/div[2]/section/div/div[1]/div/div[1]/h5");
	@FindBy(xpath = "//*[@id='__next']/div[3]/div[2]/section/div/div[1]/div/div[1]/h5")
	public WebElement bookpath;
	@FindBy(xpath = "//*[@id='__next']/div[3]/div[2]/section/div/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div/div[1]")
	public WebElement StartDestination;
	@FindBy(id = "auto_com")
	public WebElement Startjourney;
	@FindBy(xpath = "//p[@class='font-roboto text-[#333333] text-navBarTitle font-normal']")
	public WebElement Startlocation;
	@FindBy(xpath = "//*[@id='__next']/div[3]/div[2]/section/div/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]")
	public WebElement Destination;
	@FindBy(id = "auto_com")
	public WebElement destinationjourney;
	@FindBy(xpath = "//p[@class='font-roboto text-[#333333] text-navBarTitle font-normal']")
	public WebElement destinationlocate;
	@FindBy(xpath = "(//div[@class='font-roboto text-[#333333] text-navBarTitle font-normal truncate'])[1]")
	public WebElement Tripmode_1;
	@FindBy(xpath = "//div[@class='space-y-2 p-2 hover:bg-hover hover:cursor-pointer false'][1]")
	public WebElement trip_oneway;
	@FindBy(xpath = "(//div[@class='font-roboto text-[#333333] text-navBarTitle font-normal truncate'])[2]")
	public WebElement passanger_1;
	@FindBy(xpath = "//*[@id='FlightsResumes']/div[2]/div/div/div[1]/div[1]/h4")
	public WebElement locationstatus;
	@FindBy(xpath = "(//*[@class='text-lg'])[2]")
	public WebElement threepassenger;
	@FindBy(xpath = "(//div[@class='font-roboto text-[#333333] text-navBarTitle font-normal truncate'])[2]")
	public WebElement passengerconfirm;
	@FindBy(xpath = "//*[@id='__next']/div[3]/div[2]/section/div/div[2]/div[3]/div[2]/div/div/div[2]/div/button")
	public WebElement confirmpassenger;
	@FindBy(xpath = "(//a[@class='btn btn-primary btn-block'])[2]")
	public WebElement createaccountbutton;
	@FindBy(name = "Login")
	public WebElement loginid;
	@FindBy(name = "Password")
	public WebElement pass;
	@FindBy(name = "PasswordConfirm")
	public WebElement confirmpass;
	@FindBy(xpath = "//select[@id='Civility']")
	public WebElement check;
	@FindBy(xpath = "//select[@id='Civility']")
	public WebElement civilty;
	@FindBy(name = "Surname")
	public WebElement surename;
	@FindBy(name = "FirstName")
	public WebElement firstname;
	@FindBy(name = "EmailAddress")
	public WebElement email;
	@FindBy(name = "BirthDate")
	public WebElement Dob;
	@FindBy(xpath = "//input[@id='PhoneNumberHome']")
	public WebElement phonehome;
	@FindBy(xpath = "//input[@id='PhoneNumberOffice']")
	public WebElement phonecell;
	@FindBy(xpath = "//input[@id='PhoneNumberMobile']")
	public WebElement phones;
	@FindBy(xpath="//*[@id='FormClient']/div[1]/div[1]/div/ul/li/text()")
	public WebElement creations;
	public String values;
	public String excalpath = System.getProperty("user.dir")+"\\excel\\datas.xlsx";
	public File file;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public List<WebElement> datas;
	public FileOutputStream fileout;

}
