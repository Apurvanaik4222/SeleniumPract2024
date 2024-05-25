package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BookingFlightEg {

    @Test
    public void bookFlight(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));

        //AutoSuggest DropDown
        WebElement autoSuggestDropDown =driver.findElement(By.xpath("//input[@id='autosuggest']"));
        autoSuggestDropDown.click();
        autoSuggestDropDown.sendKeys("ind");

        List<WebElement> countrySuggestions =driver.findElements(By.xpath("//ul[@id='ui-id-1']//li//a"));
       WebElement countrySel = countrySuggestions.stream().filter(country->country.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
        countrySel.click();

        //Checkboxes

        //No of checkboxes
        List<WebElement> noOfCheckBoxes =driver.findElements(By.xpath("//input[@type='checkbox']"));
        int size =noOfCheckBoxes.size();
        System.out.println("No of Checkboxes :" +size);

        //Click on Checkbox
        WebElement indianCheckbox =driver.findElement(By.xpath("//input[contains(@id,'ctl00_mainContent_chk_IndArm')]"));
        if(indianCheckbox.isDisplayed()&& !indianCheckbox.isSelected()){
            indianCheckbox.click();
        }





        //To and From
        WebElement dropDown =driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
        dropDown.click();

        WebElement from =driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[contains(text(),' Belagavi (IXG)')]"));
        from.click();
        WebElement to =driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[contains(text(),' Kochi (COK)')]"));
        to.click();


        //calender Current Date

        WebElement currentDate = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(" //td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']"))));
        currentDate.click();

        //Passenger Details

        WebElement passengerCheckbox =driver.findElement(By.xpath("//div[@id='divpaxinfo']"));
        passengerCheckbox.click();

        WebElement adult =driver.findElement(By.xpath("//span[@id='hrefIncAdt']"));
        WebElement child =driver.findElement(By.xpath("//span[@id='hrefIncChd']"));
        WebElement infant =driver.findElement(By.xpath("//span[@id='hrefIncInf']"));

        int k=1;
        int count =5;
        while(k<count){
            adult.click();

            k++;
        }
        child.click();
        infant.click();

        //Currency

        WebElement currencySel =driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
        Select select =new Select(currencySel);
        select.selectByVisibleText("USD");


        WebElement search =driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']"));
        search.click();

        driver.close();















    }
}
