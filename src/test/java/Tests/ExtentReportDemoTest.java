package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;

public class ExtentReportDemoTest {
    ExtentReports extent;
    WebDriver driver;


    @BeforeTest
    public void config(){
        String filePath =System.getProperty("user.dir")+"\\Reports\\index.html";
        ExtentSparkReporter reporter =new ExtentSparkReporter(filePath);
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setDocumentTitle("SeleniumPrac2024Reports");
        reporter.config().setTheme(Theme.DARK);
        extent=new ExtentReports();
        extent.attachReporter(reporter);
    }

    @Test
    public void launchApplication(){
      ExtentTest test = extent.createTest("launchApplication");


        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("https://www.google.com");
        test.log(Status.PASS,"Test Case Passes");
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        extent.flush();

    }
}
