package MiscExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CalenderEg {
    @Test
    public void calenderPrac() throws InterruptedException {
        String YearVal ="2029";
        String monthVal ="December";
        String dayVal="18";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);

        WebElement datebox = driver.findElement(By.xpath("//div[contains(@class,'react-date-picker--closed')]"));
        datebox.click();

        WebElement monthTxt = driver.findElement(By.xpath("//span[contains(@class,'react-calendar__navig')]"));
        monthTxt.click();
        monthTxt.click();


//Selecting Year
        List<WebElement> years = driver.findElements(By.xpath("//button[contains(@class,'react-calendar__tile react-calendar')]"));
        for (WebElement year:years){
           if(year.getText().equalsIgnoreCase(YearVal)){
               year.click();
               break;
           }
        }

        //Selecting month

        List<WebElement> months = driver.findElements(By.xpath("//button[contains(@class,'react-calendar__tile react-calendar')]"));
        for (WebElement month:months){
            String val =month.getText();
            System.out.println(val);
            if(val.equalsIgnoreCase(monthVal)){
                month.click();
                break;

            }

        }

        //Selecting day

        List<WebElement> days = driver.findElements(By.xpath("//button[contains(@class,'react-calendar__tile react-calendar')]//abbr"));
        for (WebElement day:days){
            if(day.getText().equalsIgnoreCase(dayVal)){
                day.click();
                break;

            }
        }


        List<WebElement> selectedDate = driver.findElements(By.xpath("//input[contains(@class,'react-date-picker__inputGroup__input react-date-picker__inputGroup')]"));
        for(int i=0;i<selectedDate.size();i++){
            System.out.println(selectedDate.get(i).getAttribute("value"));
        }








    }}
