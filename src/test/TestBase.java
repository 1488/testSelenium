package test;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestBase {

	private static  WebDriver driver;
	private static String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8888/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	protected void createGroup(GroupObject groupObject) {
		openMainPage();
	    goToGroupListPage(); 
	    initGroupCreation();
		fillGroupForm(groupObject);
	    submitGroupCreation();
	    returnToGroupListPage();
	}

	private void returnToGroupListPage() {
	    driver.findElement(By.linkText("group page")).click();
	}

	private void submitGroupCreation() {
	    driver.findElement(By.name("submit")).click();
	}

	private void initGroupCreation() {
		driver.findElement(By.name("new")).click();
	}

	private void fillGroupForm(GroupObject groupObject) {
	    type("group_name", groupObject.getName());
	    type("group_header", groupObject.getHeader());
	    type("group_footer", groupObject.getFooter());
	}

	private void type(String locator, String name) {
		driver.findElement(By.name(locator)).clear();
	    driver.findElement(By.name(locator)).sendKeys(name);
	}

	private void goToGroupListPage() {
	    driver.findElement(By.linkText("groups")).click();
	}

	public void openMainPage() {
		driver.get(baseUrl + "/addressbookv4.1.4/index.php");
	}

	@AfterTest
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

}
