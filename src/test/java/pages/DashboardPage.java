package pages;

import org.openqa.selenium.WebDriver;

import base.DriverManager;

public class DashboardPage {

//	 public String searchEmployee(String name) {
//	        DriverManager.getDriver().findElement(By.xpath("//input")).sendKeys(name);
//	        return DriverManager.getDriver().findElement(By.xpath("//div")).getText();
//	    }
	
	 private WebDriver driver = DriverManager.getDriver();

	    // Example method to search employee or verify page
	    public String searchEmployee(String empName) {
	        // Just returning page text for demo
	        return driver.getPageSource();
	    }
}
