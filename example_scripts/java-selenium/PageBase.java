package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	protected WebDriver driver;
	protected BrowserType browser;

	public PageBase (WebDriver driver) {
		this.driver = driver;
	}

	public WebElement findElement (By locator) {
		return driver.findElement(locator);

	}

	public PageBase submitKey (By locator) {
		findElement(locator).submit();
		return new PageBase(driver);
	}

	public PageBase clickOn (By locator) {
		findElement(locator).click();
		return new PageBase(driver);
	}

	public String getString (By locator) {
		return findElement(locator).getText().toString();
	}

	public PageBase sendString (By locator, String input) {
		findElement(locator).sendKeys(input);
		return new PageBase(driver);
	}

	public String pageTitle () {
		return this.driver.getTitle().toString();
	}



	public Boolean isDisplayed (By locator) throws InvalidElementStateException {
		if(!findElement(locator).isDisplayed()) {
			throw new InvalidElementStateException("This web element is not displaying");
		} else {
			return true;
		}
	}

	public WebElement visibleWait(By locator, Integer timeout) {
		timeout = timeout != null ? timeout : 10;
    	WebDriverWait wait = new WebDriverWait(driver, timeout);
    	return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

}

