package stepsForHooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import POM_Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HooksDemoSteps {
	WebDriver driver;
	ExtentSparkReporter htmlReporter;
	static ExtentReports extent;
	ExtentTest test1;
	static int count;

	@Before
	public void browserSetup() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
        if(count<1) {
			htmlReporter = new ExtentSparkReporter(projectPath+"/ExtentReport/extent.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);

        }

		test1 = extent.createTest("Login test"+String.valueOf(++count), "This will test login functionality");
		System.out.println("new test started");
		test1.log(Status.INFO, "Test Starts..");

	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		driver.get("https://example.testproject.io/web/");
		test1.log(Status.PASS, "user is sucessfully on login page");
	}
	@When("^user enters valid (.*) and (.*)$")
	public void user_enters_valid_username_and_password(String username, String password) {

		LoginPage lp =new LoginPage(driver);
		lp.userName(username);
		lp.passwrd(password);

		test1.log(Status.PASS, "user is sucessfully entered username and password");
	}
	@When("clicks on login button")
	public void clicks_on_login_button() {

		LoginPage lp =new LoginPage(driver);
		lp.loginBtn();

		test1.log(Status.PASS, "user is sucessfully clicked on login button");
	}
	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		driver.getPageSource().contains("TestProject Example page");

		test1.log(Status.PASS, "user is sucessfully is on home page");
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();

		extent.flush();

	}


}
