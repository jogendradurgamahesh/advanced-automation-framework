package tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import base.DriverManager;
import utils.RetryAnalyzer;

@Listeners(utils.TestListener.class)
public class LoginTest extends BaseTest {

//	@BeforeMethod
//	public void setUp() {
//	    setup();
//	}
//
//	@AfterMethod
//	public void cleanUp() {
//	    tearDown();
//	}
	
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginTest() {
//        setup();
        DriverManager.getDriver().get("https://opensource-demo.orangehrmlive.com/");
        Assert.assertTrue(true);
       // tearDown();
    }
}