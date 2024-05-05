package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportNG {



    public static ExtentReports getExtentinstance(){

        String filePath =System.getProperty("user.dir")+"\\Reports\\index.html";
        ExtentSparkReporter reporter =new ExtentSparkReporter(filePath);
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setDocumentTitle("SeleniumPrac2024Reports");
        reporter.config().setTheme(Theme.DARK);
        ExtentReports extent=new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }


}
