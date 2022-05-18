package PassOrFail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class PassFail {
	WebDriver driver;
	ExtentSparkReporter htmlreporter;
	ExtentReports extent;
	ExtentTest test;

	public void check() {
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath+"/Drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		htmlreporter = new ExtentSparkReporter("CheckExtent.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);

		test=extent.createTest("search test","this test will check search functionality of google");
		test.log(Status.INFO, "test starts");

		driver.get("https://www.google.com/");
	}
	public void search() {
		try {
			driver.findElement(By.name("qsd")).sendKeys("Ashutosh kumar");
			
			test.log(Status.PASS, "successfully located the search box and entered the text");
			

		}
		catch(Exception e){
			test.log(Status.FAIL, "not able to locate the box");

		}

	}
	public void enter() {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		test.log(Status.PASS, "entered the enter key");
		
	}
	
	public void teardown() {
		driver.close();
		driver.quit();
		extent.flush();
		
	}
	
	public static void main(String[] args) {
		PassFail p = new PassFail();
		p.check();
		p.search();
		p.enter();
		p.teardown();
	}
	

}
