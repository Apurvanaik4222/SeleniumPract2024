package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {

    public static void main(String[] args) {

        //System.setProperty("webdriver.chrome.driver","C:\\Users\\91762\\IdeaProjects\\SeleniumPract2024\\src\\main\\java\\Executables\\chrome.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.google.com");
    }
}
