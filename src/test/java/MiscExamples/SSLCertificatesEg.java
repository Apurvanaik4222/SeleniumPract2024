package MiscExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SSLCertificatesEg {

    @Test
    public void sslCertifcatePrac() throws InterruptedException {
        String YearVal = "2029";
        String monthVal = "December";
        String dayVal = "18";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options =new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       System.out.println(driver.getTitle());
    }
}
