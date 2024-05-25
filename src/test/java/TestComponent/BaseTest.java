package TestComponent;

import PageObjects.LandingPage;
import PageObjects.ProductListPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import  java.util.List;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

public class BaseTest {
    public   WebDriver driver;
    public  LandingPage landingPage;
    public   ProductListPage productListPage;

    public WebDriver intializeDriver() throws IOException {
        //Added test Comment09

        String browserName =System.getProperty("browser")!=null? System.getProperty("browser"):getPropertyValue("browser");
       if(browserName.contains("chrome")){
           ChromeOptions options =new ChromeOptions();

           if(browserName.contains("headless")){
               options.addArguments("headless");

           }

           WebDriverManager.chromedriver().setup();
           driver =new ChromeDriver(options);
           driver.manage().window().setSize(new Dimension(1440,900));
       }
       else if(browserName.equalsIgnoreCase("firefox")){
           WebDriverManager.firefoxdriver().setup();
           driver =new FirefoxDriver();
       }
       else if (browserName.equalsIgnoreCase("edge")) {
           WebDriverManager.edgedriver().setup();
           driver =new EdgeDriver();
       }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
        Actions actions =new Actions(driver);
        return driver;


    }

    public String getPropertyValue(String key) throws IOException {
        Properties properties =new Properties();
        FileInputStream fileInputStream =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Globalconfig.properties");
        properties.load(fileInputStream);
       return properties.get(key).toString();

    }

    @BeforeTest(alwaysRun = true)
    public void launchApplication() throws IOException {
       driver = intializeDriver();
        driver.get("https://rahulshettyacademy.com/client/");
         landingPage =new LandingPage(driver);

    }

    public ProductListPage loginToApp(String userName,String password){
        productListPage =landingPage.Login(userName,password);
        return new ProductListPage(driver);

    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }



    public List<HashMap<String, String>> jsonDataReader(String filePath) throws IOException {

        //Read Json to string Format
       String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

        ObjectMapper objectMapper =new ObjectMapper();
       List<HashMap<String,String>> list = objectMapper.readValue(jsonContent, new TypeReference<List< HashMap<String,String>>>(){

        });

       return list;
    }

    public String takeScreenShot(String testCaseName,WebDriver driver) throws IOException {

       TakesScreenshot screenshot = (TakesScreenshot)driver;
      File source = screenshot.getScreenshotAs(OutputType.FILE);
      File dest =new File(System.getProperty("user.dir")+"\\Reports\\"+testCaseName+".png");
      FileUtils.copyFile(source,dest);
      return System.getProperty("user.dir")+"\\Reports\\"+testCaseName+".png";
    }


    public void getDate(){

        Date date =new Date();
        SimpleDateFormat format =new SimpleDateFormat("dd_mm_yyyy_hh_MM_ss");
      //String date =  format(date);
    }



}
