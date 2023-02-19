package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "featureFiles/addtodomvctask.feature" , glue = "stepDefinitions", tags="@functionalTest" , publish =true )
public class RunTest {
	
	// this will combine the feature files and the step definition
	// runner definition

}
