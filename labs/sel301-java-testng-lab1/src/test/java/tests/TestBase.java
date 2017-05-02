package tests;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


public class TestBase {

	public static final String USERNAME = "SAUCE_USERNAME";
	public static final String ACCESS_KEY = "SAUCE_ACCESS_KEY";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	/*ThreadLocal variable which contains instance used to perform browser interaction  */
	protected ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	/*ThreadLocal variable which contains the Sauce Job Id.		 */
	protected ThreadLocal<String> sessionId = new ThreadLocal<String>();


	public WebDriver getWebDriver() {
		 return webDriver.get();
		}

	public String getSessionId() {
		   return sessionId.get();
		}

	//Pass Multiple Browser Capabilities using the @DataProvider annotation
	@DataProvider(name = "hardCodedBrowsers", parallel = true )
	  public static Object[][] sauceBrowserDataProvider(Method testMethod) {
	      return new Object[][]{
	              new Object[]{"internet explorer", "11", "Windows 8.1"},
	              new Object[]{"chrome", "41", "Windows XP"},
	              new Object[]{"chrome", "54.0", "OS X 10.9"},
	              new Object[]{"firefox", "27.0", "Windows 10"},
	              new Object[]{"safari", "7.0", "OS X 10.9"},
	              }
	      	;
		}
	public void createDriver(String browser, String version, String os, String methodName)
	           throws MalformedURLException, UnexpectedException {

		//Set desired capabilities for current webDriver
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability(CapabilityType.BROWSER_NAME, browser);
				caps.setCapability(CapabilityType.VERSION, version);
				caps.setCapability(CapabilityType.PLATFORM, os);
				caps.setCapability("name", methodName + "_" + browser);
				caps.setCapability("build", "beta");
				System.out.println(caps);


				// Launch remote browser and set it as the current thread
			    webDriver.set(new RemoteWebDriver(new URL(URL), caps));

			    //set current sessionId
			    WebDriver driver = getWebDriver();
			       String id = ((RemoteWebDriver) driver).getSessionId().toString();
					sessionId.set(id);
					System.out.println(id);
			   }
}


