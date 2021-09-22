package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author Muhammad Tafseer Haider
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "not @ignore",
        features = {
                "src/test/java/features"
        },
        glue = {
                "steps"
        },
        plugin = {
                "pretty", "html:target/cucumber-report/single",
                "json:target/reports/cucumber.json",
        },
        publish = true
)
public class JunitParallelRunner {
}
