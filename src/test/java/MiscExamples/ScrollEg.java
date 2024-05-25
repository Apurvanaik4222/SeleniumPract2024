package MiscExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ScrollEg {

    @Test
    public void calenderPrac() throws InterruptedException {
        String YearVal ="2029";
        String monthVal ="December";
        String dayVal="18";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,700)");
        Thread.sleep(3000);

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

        List<WebElement> list =driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody//tr//td[4]"));

        int sum =0;
        for(WebElement ele :list){
         sum =sum+Integer.parseInt(ele.getText());
        }

        int expectedVal = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
        Assert.assertEquals(sum,expectedVal);
        System.out.println("--------------------");



}}
