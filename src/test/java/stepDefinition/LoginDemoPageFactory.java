package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageFactory.LoginPage_PageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDemoPageFactory {
	WebDriver driver;
	
	
	@Given("Browser is open")
	
	public void browser_is_open() {
	   System.out.println("I am inside page factory");
	   String projectpath= System.getProperty("user.dir");
	   System.setProperty("webdriver.chrome.driver", projectpath+"/Drivers/chromedriver.exe");
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
		driver.get("https://example.testproject.io/web/");
	   
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		LoginPage_PageFactory lp =new LoginPage_PageFactory(driver);
		
		lp.enterUsername(username);
		lp.enterPassword(password);
	    
	}
	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		LoginPage_PageFactory lp =new LoginPage_PageFactory(driver);
		lp.ClickLogin();;
	}

	
	@Then("user navigated to the home page")
	public void user_navigated_to_the_home_page() {
		driver.getPageSource().contains("TestProject Example page");
		driver.close();
		driver.quit();
	    
	}

}
