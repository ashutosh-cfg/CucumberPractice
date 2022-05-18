package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	WebDriver driver;
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Inside Step - Browser is open");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		System.out.println("Inside Step - user is on google search page");
		driver.get("https://www.google.com/");
	    
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() {
		System.out.println("Inside Step - User enters a text in search box");
		driver.findElement(By.name("q")).sendKeys("Ashutosh kumar linkedIn coforge");
	    
	}

	@And("hits enter")
	public void hits_enter() {
		System.out.println("Inside Step - Hits Enter");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	   
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
		System.out.println("Inside Step - User is navigated to search results");
		driver.getPageSource().contains("Ashutosh kumar - Graduate Engineering Trainee - Coforge");
		
		driver.close();
		driver.quit();
		
	}

}
