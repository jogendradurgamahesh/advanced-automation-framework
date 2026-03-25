package base;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
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
	public void setup(@org.testng.annotations.Optional("chrome") String browser) throws Exception {

		//String browser = System.getProperty("browser", "chrome");
		WebDriver driver;
	//	 String gridUrl = System.getProperty("grid.url", "http://localhost:4444/wd/hub");
		 String gridUrl = System.getProperty("grid.url", "http://selenium-hub:4444/wd/hub");

		if (browser.equalsIgnoreCase("chrome")) {


			ChromeOptions options = new ChromeOptions();

			// 🔥 Required for Docker
			options.addArguments("--headless=new");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-gpu");
			options.addArguments("--window-size=1920,1080");

			//WebDriver driver = new ChromeDriver(options);


//			// ✅ ADD HERE (dynamic grid URL)
//			String gridUrl = System.getProperty("grid.url", "http://localhost:4444/wd/hub");

			// 🔥 CONNECT TO SELENIUM GRID
			driver = new RemoteWebDriver(new URL(gridUrl),
					options
					);
		}else {
			org.openqa.selenium.firefox.FirefoxOptions options =
					new org.openqa.selenium.firefox.FirefoxOptions();

		//	String gridUrl = System.getProperty("grid.url", "http://localhost:4444/wd/hub");

			driver = new RemoteWebDriver(new URL(gridUrl), options);

		}

		DriverManager.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		 Thread.sleep(10000); // 10 seconds pause
	}

	@AfterMethod
	public void tearDown() {
		if (DriverManager.getDriver() != null) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
