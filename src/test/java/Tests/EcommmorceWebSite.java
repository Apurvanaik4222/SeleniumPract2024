package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class EcommmorceWebSite {

    @Test
    public void addProductsToCart() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        int k = 0;
        String[] products = {"Brocolli", "Beans", "Brinjal","Walnuts"};
        List<String> productsToBeAdded = Arrays.asList(products);

        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='products-wrapper']//div//h4"));

        for (int i = 0; i < productList.size(); i++) {
            String productName =productList.get(i).getText().split("-")[0].trim();

            if (productsToBeAdded.contains(productName)) {

                driver.findElements(By.xpath("//div[@class='products-wrapper']//div[@class='product-action']")).get(i).click();
                k++;

            }

            if (k == productsToBeAdded.size()) {
                break;

            }

        }

    }
}