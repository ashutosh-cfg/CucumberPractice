package POM_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	private WebElement username;
	private WebElement password;
	private WebElement btn;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		System.out.println("I am inside Login page pom");
		username= driver.findElement(By.id("name"));
		password= driver.findElement(By.id("password"));
		btn = driver.findElement(By.id("login"));
		
	}
	public void userName(String username) {
		this.username.sendKeys(username);
	}
	public void passwrd(String password) {
		this.password.sendKeys(password);
	}
	public void loginBtn() {
		btn.click();
	}

}
