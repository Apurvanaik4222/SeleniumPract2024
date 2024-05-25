package MiscExamples;

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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DisplayAllLinks {

    @Test
    public void linkPrac() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println(allLinks.size());
        for (WebElement link : allLinks) {
            System.out.println(link.getText());
        }

        System.out.println("---------------------------------------------------------");
        WebElement footersection = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
        List<WebElement> footerLinks = footersection.findElements(By.tagName("a"));
        System.out.println(footerLinks.size());

        for (WebElement link : footerLinks) {
            System.out.println(link.getText());
        }


        System.out.println("---------------------------------------------------------");

        WebElement footersection1 = footersection.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        List<WebElement> footerLinks1 = footersection1.findElements(By.tagName("a"));
        System.out.println(footerLinks1.size());

        for (WebElement link : footerLinks1) {

            String keyAction = Keys.chord(Keys.CONTROL, Keys.ENTER);
            link.sendKeys(keyAction);
        }

        Thread.sleep(5000);

        Set<String> windowHandles =driver.getWindowHandles();
        Iterator<String> itr =windowHandles.iterator();

        while (itr.hasNext()){
            driver.switchTo().window(itr.next());
            System.out.println(driver.getTitle());
        }

    }
}
