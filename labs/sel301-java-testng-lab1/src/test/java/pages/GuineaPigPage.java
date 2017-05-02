package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;



public class GuineaPigPage {
	protected WebDriver driver;
	protected BrowserType browser;

	public GuineaPigPage(WebDriver driver) {
		this.driver = driver;
	}

	public void getPage() {
		driver.get("https://jtack4970.github.io/training-test-page-james/");
	}

	public void hyperLinkTest() {
		//click on page link "i am a link"
		driver.findElement(By.linkText("i am a link")).click();
	}

	public void pressSubmitButton() {
		//click on submit button
		driver.findElement(By.xpath("//*[@id=\"jumpContact\"]/div/input")).submit();
	}

	public void editTextBox() {
		//Type text into text box
		driver.findElement(By.cssSelector("#comments")).sendKeys("Hello World");
	}

	public String readComment() {
		//read resulting text from comment box
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String myComments = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("your_comments")))).getText().toString();
		return myComments;
	}


	public String getCurrentPageTitle() {
		return driver.getTitle().toString();
	}

	public String readLinkText() {
		return driver.findElement(By.linkText("i am a link")).getText().toString();
	}

}