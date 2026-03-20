//package utils;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//public class TestListener implements ITestListener {
//    public void onTestFailure(ITestResult result) {
//        ScreenshotUtils.capture(result.getName());
//    }
//}



package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	   @Override
	    public void onTestStart(ITestResult result) {
	        ExtentTestManager.startTest(result.getName());
	    }
	
    @Override
    public void onTestFailure(ITestResult result) {
//        System.out.println("Test Failed: " + result.getName());
//        ScreenshotUtils.capture(result.getName());
    	
    	   ExtentTestManager.getTest().fail("Test Failed");

           String path = ScreenshotUtils.capture(result.getName());
           try {
               ExtentTestManager.getTest().addScreenCaptureFromPath(path);
           } catch (Exception e) {
               e.printStackTrace();
           }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //System.out.println("Test Passed: " + result.getName());
        ExtentTestManager.getTest().pass("Test Passed");
    }
    
    
    @Override
    public void onFinish(ITestContext context) {
        ExtentTestManager.flush();
    }
}