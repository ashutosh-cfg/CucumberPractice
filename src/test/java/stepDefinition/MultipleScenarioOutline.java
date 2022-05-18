package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class MultipleScenarioOutline {
	@Given("when user open notepad")
	public void when_user_open_notepad() {
		System.out.println("opened notepad");
	}
	@And("^print class A (.*) and (.*)$")
	public void print_class_A_name_and_age(String name , String age) {
		System.out.println("Name is "+name);
		System.out.println("Age is :"+age);
	}
	@Given("when user opened notepad")
	public void when_user_opened_notepad() {
		System.out.println("user opened notepad for class B student");
	}
	@And("^class B (.*) and (.*)$")
	public void class_B_name_and_age(String name, String age) {
		System.out.println("Class B Name is "+name);
		System.out.println("Class B Age is :"+age);
	}

}
