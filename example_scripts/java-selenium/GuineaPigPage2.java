package pages;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class GuineaPigPage extends PageBase{

	public GuineaPigPage(WebDriver driver) {
		super(driver);
	}

	/*Different States of the checkbox require separate element IDs*/
	By linkTitle = By.linkText("i am a link");
	By sendButton = By.xpath("//*[@id=\"submit\"]");
	By commentBox = By.cssSelector("#comments");
	By yourComments = By.id("your_comments");

	public void getPage() {
		driver.get("https://saucelabs.com/test/guinea-pig");
	}

	public void hyperLinkTest() {
		//click on page link "i am a link"
		clickOn(linkTitle);
	}

	public void pressSubmitButton() {
		//click on submit button
		submitKey(sendButton);
	}

	public void editTextBox() {
		//Type text into text box
		sendString(commentBox, "Hello World");
	}

	public String readComment() {
		//read resulting text from comment box
		this.visibleWait(yourComments, 10);
		return getString(yourComments);
	}


	public String getCurrentPageTitle() {
		return this.pageTitle();
	}

	public String readLinkText() {
		return getString(linkTitle);
	}

}