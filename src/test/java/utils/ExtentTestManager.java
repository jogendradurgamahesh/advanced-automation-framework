package utils;

import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager implements ITestListener {

	  private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	    private static ExtentReports extent = ExtentManager.getInstance();

	    public static void startTest(String testName) {
	        test.set(extent.createTest(testName));
	    }

	    public static ExtentTest getTest() {
	        return test.get();
	    }

	    public static void flush() {
	        extent.flush();
	    }
}
