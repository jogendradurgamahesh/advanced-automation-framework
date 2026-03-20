package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverManager;

public class LoginPage {
	
//	  public void login(String user, String pass) {
//	        DriverManager.getDriver().findElement(By.name("username")).sendKeys(user);
//	        DriverManager.getDriver().findElement(By.name("password")).sendKeys(pass);
//	        DriverManager.getDriver().findElement(By.tagName("button")).click();
//	    }
	
	   private WebDriver driver = DriverManager.getDriver();

	    private By username = By.name("username");
	    private By password = By.name("password");
	    private By loginBtn = By.xpath("//button[@type='submit']");

	    public void login(String user, String pass) {
	        driver.findElement(username).sendKeys(user);
	        driver.findElement(password).sendKeys(pass);
	        driver.findElement(loginBtn).click();
	    }


}
