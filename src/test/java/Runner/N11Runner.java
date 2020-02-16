package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * created by MehmetBesli on 02.2020
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/Feature"},
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        glue = {"src/test/java/Steps"})
public class N11Runner {
}
