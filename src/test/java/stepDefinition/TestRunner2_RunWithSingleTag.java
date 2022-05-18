package stepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/FeatureWithTags/Tags.feature",glue= {"stepDefinition"},tags="@smoke or @regression")

public class TestRunner2_RunWithSingleTag {

}
