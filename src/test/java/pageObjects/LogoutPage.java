package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {

		static WebElement ele = null;

		public static WebElement btnLogout(WebDriver driver) {
			return ele = driver.findElement(By.linkText("Logout"));
			
		}
		public static WebElement btnContinue(WebDriver driver) {
			return ele = driver.findElement(By.linkText("Continue"));
		}
	}


