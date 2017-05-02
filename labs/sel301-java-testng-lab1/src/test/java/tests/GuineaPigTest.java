package tests;

import static org.testng.AssertJUnit.assertEquals;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.saucelabs.saucerest.SauceREST;

import pages.GuineaPigPage;


public class GuineaPigTest extends TestBase {


	//Run test that uses dataProvider for desired capabilities
	@Test(dataProvider = "hardCodedBrowsers")
	  public void linkTest(String browser, String version, String os, Method method)
	          throws MalformedURLException, InvalidElementStateException, UnexpectedException {
		//create webdriver session
	    this.createDriver(browser, version, os, method.getName());
	    WebDriver driver = this.getWebDriver();

	    //Instantiate page object
	    GuineaPigPage page = new GuineaPigPage(driver);
	    page.getPage();
	    page.hyperLinkTest();
	    //references page object method(s)
	    assertEquals(page.getCurrentPageTitle(), "I am another page title - Sauce Labs");
	}

	@Test(dataProvider = "hardCodedBrowsers")
		public void commentTest(String browser, String version, String os, Method method)
	          throws MalformedURLException, InvalidElementStateException, UnexpectedException {
		//create webdriver session
	    this.createDriver(browser, version, os, method.getName());
	    WebDriver driver = this.getWebDriver();

	    //Instantiate page object
	    GuineaPigPage page = new GuineaPigPage(driver);
	    page.getPage();
	    page.editTextBox();
	    page.pressSubmitButton();
	    String end_result =  page.readComment();
	    assertEquals(end_result, "Your comments: Hello World");
	}

	//Verify test based on JUnit assert
	@AfterMethod
	public void after(ITestResult testResult) throws Exception {
		//Gets browser logs if available.
		webDriver.get().quit();
		//sends passed or failed value from sauce labs api object to Sauce Labs account - shows passed or fail on test in UI
		SauceREST restAPI = new SauceREST(USERNAME, ACCESS_KEY);
			if (testResult.isSuccess()) {
				restAPI.jobPassed(sessionId.get());
			} else {
				restAPI.jobFailed(sessionId.get());
			}
	}
}