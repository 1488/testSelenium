package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactCreationTests {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeTest
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://127.0.0.1:8888/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreatedContactValid() throws Exception {
    openMainPage();
    initContactCreation();
    FiilContactFormParameter validForm = new FiilContactFormParameter("first name", "last name", "adress epta", "123321", "9267294753", "5555555", "Cherednikov.roman@gmail.com", "danieldefo60@gmail.com", "19", "December", "1991", "adress");
	fiilContactForm(validForm);
    submitContactForm();
    returnToHomePage();
  }


  @Test
  public void testCreatedEmptyContact() throws Exception {
    FiilContactFormParameter validForm = new FiilContactFormParameter("", "", "", "", "", "", "", "", "", "", "", "");
	openMainPage();
    initContactCreation();
	fiilContactForm(validForm);
    submitContactForm();
    returnToHomePage();
  }
  
private void returnToHomePage() {
	driver.findElement(By.linkText("home page")).click();
}

private void submitContactForm() {
	driver.findElement(By.name("submit")).click();
}

private void fiilContactForm(FiilContactFormParameter parameterObject) {
	type("firstname", parameterObject.getNameF());
	type("lastname", parameterObject.getNameL());
	type("address", parameterObject.getAddress());
	type("home", parameterObject.getPhoneH());
	type("mobile", parameterObject.getPhoneM());
	type("work", parameterObject.getPhoneW());
	type("email", parameterObject.getEmail1());
	type("email2", parameterObject.getEmail2());
    bDayDate("bday", parameterObject.getBday());
    bDayDate("bmonth", parameterObject.getBmonth());
    type("byear", parameterObject.getByear());
    type("address2", parameterObject.getAddress2());
    type("phone2", parameterObject.getAddress2());
}

private void bDayDate(String locator2, String bday) {
	new Select(driver.findElement(By.name(locator2))).selectByVisibleText(bday);
}

private void type(String locator, String nameF) {
	driver.findElement(By.name(locator)).clear();
    driver.findElement(By.name(locator)).sendKeys(nameF);
}

private void initContactCreation() {
	driver.findElement(By.linkText("add new")).click();
}

private void openMainPage() {
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

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alert.getText();
    } finally {
      acceptNextAlert = true;
    }
  }
}
