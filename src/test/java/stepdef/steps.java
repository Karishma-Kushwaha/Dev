package stepdef;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;

public class steps {

	WebDriver driver;
	Logger logger;

	@Before
	public void setup() {
		// for logging
		logger = LogManager.getLogger(this.getClass());
	}

	@Given("User Launch browser")
	public void user_launch_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		logger.info("Browser is launched");
	}

	@Given("opens URL {string}")
	public void opens_url(String url) {
		driver.get(url);
		logger.info("URL is accessible");
	}

	@When("User navigate to MyAccount menu")
	public void user_navigate_to_my_account_menu() {
		driver.findElement(By.xpath("//*[@id='top-links\']/ul/li[2]/a/span[2]")).click();
		logger.info("Clicked on My Account Menu Item");
	}

	@When("click on Login")
	public void click_on_login() {
		driver.findElement(By.xpath("//*[@id=\'top-links\']/ul/li[2]/ul/li[2]/a")).click();
		logger.info("Clicked on Login Menu Item");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) {
//		driver.findElement(By.name("email")).sendKeys(email);
		LoginPage.txtusername(driver).sendKeys(email);
//		driver.findElement(By.name("password")).sendKeys(pwd);
		LoginPage.txtpassword(driver).sendKeys(pwd);
		logger.info("Email and password is entered successfully");
	}

//	@When("Email {string} and password {string}")
//	public void email_and_password(String email, String pwd) {
//		driver.findElement(By.name("email")).sendKeys(email);
//		driver.findElement(By.name("password")).sendKeys(pwd);
//	}

	@When("Click on Login button")
	public void click_on_login_button() {
//		driver.findElement(By.xpath("//*[@id=\'content']/div/div[2]/div/form/input")).click();
		LoginPage.btnLogin(driver).click();
		logger.info("Clicked on Login button");
	}

	@Then("User navigates to MyAccount Page")
	public void user_navigates_to_my_account_page() {

		MyAccountPage accountObject = new MyAccountPage(driver);
		boolean targetPage = accountObject.isMyAccountPageExists();
		if (targetPage) {
			Assert.assertTrue(true);
			logger.info("Navigated to My Account Page successfully");
		} else {
			Assert.assertTrue(false);
		}

	}

	@Then("Click on Logout")
	public void click_on_logout() throws InterruptedException {
		LogoutPage.btnLogout(driver).click();
		Thread.sleep(2000);
		logger.info("Clicked on Logout");
	}

	@Then("Click on Continue")
	public void click_on_continue() {
		LogoutPage.btnContinue(driver).click();
		logger.info("Clicked on Continue");
		driver.close();
	}

}