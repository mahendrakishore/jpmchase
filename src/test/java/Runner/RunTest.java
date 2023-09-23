package Runner;


import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import steps.Adapter;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources",
        glue = "steps"
        )
public class RunTest {

}
