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

public class FramesEg {


    @Test
    public void framePrac() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        WebElement iFrameEle = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

        driver.switchTo().frame(iFrameEle);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement destn = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(source, destn).build().perform();


        driver.switchTo().defaultContent();
        WebElement acceptLink = driver.findElement(By.xpath("//a[contains(text(),'Accept')]"));
        acceptLink.click();


    }
}
