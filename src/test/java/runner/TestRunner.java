package runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions(
features = {"classpath:features"},
tags = {"@RegistrationPageValidations"},
glue= {"stepDefs"},
plugin = {"pretty", "html:target/cucumber-html-report"})

public class TestRunner {
}