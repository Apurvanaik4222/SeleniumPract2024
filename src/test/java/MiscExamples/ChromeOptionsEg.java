package MiscExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ChromeOptionsEg {


    @Test
    public void chromeOptionsPrac() throws InterruptedException {

        ChromeOptions options =new ChromeOptions();

        //Set Proxy
        Proxy proxy =new Proxy();
        proxy.setHttpProxy("https://8080");
        options.setExperimentalOption("proxy",proxy);

        //Diable pop-up
        options.setExperimentalOption("excludesSwitches", Arrays.asList("disable-popup-blocking"));

        //Set download Path
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("download.default_directory","//C/Personal/ApurvatTest");

        //Add extension
        options.addExtensions(new File("C/Personal/AddExtrension"));

    }
}
