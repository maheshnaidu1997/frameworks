package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//import com.aventstack.extentreports.gherkin.model.Scenario;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

import utils.TestContextSetup;

public class Hooks {
	TestContextSetup testContextSetup;
	WebDriver driver;

	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.driver =testContextSetup.testBase.WebDriverManager();
	}

	@After
	public void AfterScenario() {

		driver.quit();
	}
@AfterStep
public void AddScreenshot(Scenario scenario) throws IOException
{
if(scenario.isFailed())
{
	//screenshot
	File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
	scenario.attach(fileContent, "image/png", "image");
}
}
	
	
}
