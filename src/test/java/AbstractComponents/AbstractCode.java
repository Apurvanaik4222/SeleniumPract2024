package AbstractComponents;

import PageObjects.CartPage;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractCode {
    public WebDriverWait wait;

    public WebDriver driver;
    public Actions actions;
    public AbstractCode(WebDriver driver){
        this.driver=driver;
         wait =new WebDriverWait(driver, Duration.ofSeconds(5));
        actions =new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@class='btn btn-custom']//i[@class='fa fa-shopping-cart']")
    WebElement cartLink;

    public void waitforElementtoClickable(WebElement ele){
        wait.until(ExpectedConditions.elementToBeClickable(ele));

    }

    public CartPage clickCartLink(){

        try{
            cartLink.click();
        }catch (ElementClickInterceptedException e){
            cartLink.click();
        }
        return  new CartPage(driver);
    }
}
