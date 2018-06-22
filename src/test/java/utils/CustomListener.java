package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import scenarios.BaseTest;

public class CustomListener implements ITestListener {

    private Logger logger = Logger.getLogger(getClass());

    public void onTestStart(ITestResult result) {
        logger.info("Test method '" + result.getName()+ "' STARTED");
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Test method '" + result.getName() + "' PASSED");
    }

    public void onTestFailure(ITestResult result) {
        logger.info("Test method '" + result.getName() + "' FAILED");
        ScreenshotUtils.captureScreenshot(BaseTest.getDriver(), result);
    }

    public void onTestSkipped(ITestResult result) {
        logger.info("Test method '" + result.getName() + "' SKIPPED");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info("Test method '" + result.getName() + "' correspond threshold of success rate");
    }

    public void onStart(ITestContext iTestContext) {
        logger.info("Test class '" + iTestContext.getName()+ "' STARTED");
    }

    public void onFinish(ITestContext iTestContext) {
        logger.info("Test class '" + iTestContext.getName()+  "' FINISHED");
    }
}
