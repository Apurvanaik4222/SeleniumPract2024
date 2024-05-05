package TestComponent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ReportNG;

import java.io.File;
import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {
   ExtentReports extent = ReportNG.getExtentinstance();
   ExtentTest test;
   ThreadLocal<ExtentTest> threadLocal =new ThreadLocal<ExtentTest>();



    @Override
    public void onTestStart(ITestResult result) {
       test = extent.createTest(result.getMethod().getMethodName());
       threadLocal.set(test);


    }

    @Override
    public void onTestSuccess(ITestResult result) {
        threadLocal.get().log(Status.PASS,"Test Case Passed");


    }

    @Override
    public void onTestFailure(ITestResult result) {
        threadLocal.get().fail(result.getThrowable());
        String fPath =null;
        WebDriver driver =null;

        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            fPath =takeScreenShot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        threadLocal.get().addScreenCaptureFromPath(fPath,result.getMethod().getMethodName());

    }
    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

    }
}
