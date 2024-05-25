package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowEg {


    @Test
    public void actionsPrac() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions =new Actions(driver);
        WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Free Access ')]"));
        link.click();
       Set<String> windowHadles = driver.getWindowHandles();
       Iterator<String> itr =windowHadles.iterator();

      String parentWindow =itr.next();
      String childWindow =itr.next();

      driver.switchTo().window(childWindow);
        WebElement passString = driver.findElement(By.xpath("//p[@class='im-para red']"));
       String passVal = passString.getText().split("at")[1].trim().split(" ")[0];

       driver.switchTo().window(parentWindow);
        WebElement passCheckBox = driver.findElement(By.id("username"));
        passCheckBox.click();
        passCheckBox.sendKeys(passVal);







    }}
