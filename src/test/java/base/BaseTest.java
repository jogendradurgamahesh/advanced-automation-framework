package base;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
//    public void setup() {
//        ChromeDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        DriverManager.setDriver(driver);
//    }
//
//    public void tearDown() {
//        DriverManager.getDriver().quit();
//        DriverManager.unload();
//    }
	
	  @BeforeMethod
	    public void setup() {

			  ChromeOptions options = new ChromeOptions();

    // 🔥 Required for Docker
    options.addArguments("--headless=new");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--disable-gpu");
    options.addArguments("--window-size=1920,1080");
			
	        WebDriver driver = new ChromeDriver();
	        DriverManager.setDriver(driver);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (DriverManager.getDriver() != null) {
	            DriverManager.getDriver().quit();
	            DriverManager.unload();
	        }
	    }
}
