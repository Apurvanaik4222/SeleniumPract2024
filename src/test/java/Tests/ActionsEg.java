package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsEg {

    @Test
    public void actionsPrac() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions =new Actions(driver);
        WebElement ele = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(ele).build().perform();

        WebElement checkbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        actions.moveToElement(checkbox).click().keyDown(Keys.SHIFT).sendKeys("iphone").doubleClick().build().perform();

        //RightClick

        actions.moveToElement(ele).contextClick().build().perform();


}}
