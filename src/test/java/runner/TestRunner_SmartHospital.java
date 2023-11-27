package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="C:\\Git\\Test\\Test\\smartHospital\\src\\test\\resources\\Features",
glue="com.stepdefinition",plugin = "json:target/cucumber-report.json")
public class TestRunner_SmartHospital extends AbstractTestNGCucumberTests{

}
