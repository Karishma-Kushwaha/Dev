package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainScript {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		
		//Login
		LoginPage.txtusername(driver).sendKeys("traindevops@gmail.com");
		LoginPage.txtpassword(driver).sendKeys("Devopstr@!n0");
		LoginPage.btnLogin(driver).click();
		
		Thread.sleep(2000);
		
		//Logout
		LogoutPage.btnLogout(driver).click();
		Thread.sleep(1000);
		LogoutPage.btnContinue(driver).click();
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
