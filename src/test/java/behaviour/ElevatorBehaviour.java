package behaviour;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:../build/reports/behaviour/cucumber/"},
        features = "src/test/resources/features",
        glue = "steps"
)
public class ElevatorBehaviour {
}