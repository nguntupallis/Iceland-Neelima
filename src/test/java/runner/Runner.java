package runner;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(monochrome=true, features= {"src/test/java/feature/Requirements.feature"},
glue= {"gluecode"}, tags= {"@SmokeTest" , "@RegressionTest"}, plugin= {"pretty", "html:target/cucumber"})

public class Runner {
	
	
	

}
