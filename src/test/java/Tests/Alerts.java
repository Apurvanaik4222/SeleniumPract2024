package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts {

   @Test
   public void alterPrac() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement alert2 =driver.findElement(By.xpath("//input[@id='name']"));
        alert2.sendKeys("Apurva");

        WebElement alertBtn =driver.findElement(By.xpath("//input[@id='alertbtn']"));
       alertBtn.click();

        Alert alert  =driver.switchTo().alert();

        if (alert.getText().equalsIgnoreCase("Hello Apurva, share this practice page and share your knowledge")){
            alert.accept();
        }else
            alert.dismiss();





    }
}
