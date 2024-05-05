package PageObjects;

import AbstractComponents.AbstractCode;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractCode {

    WebDriver driver;
    public CartPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[@class='cartSection']//h3")
    List<WebElement> cartList;


    @FindBy(xpath = "//div[@class='subtotal cf ng-star-inserted']//button[@class='btn btn-primary']")
    WebElement checkoutBtn;

    @FindBy(xpath = "//input[contains(@class,'input txt text-validated ng-unt')]")
    WebElement emailIn;

    @FindBy(xpath = "(//input[contains(@class,'input txt text-validated')])[3]")
    WebElement country;

    @FindBy(xpath = "//button[contains(@class,'ta-item list-group-item ng-star-inserted')]//span")
    List<WebElement> countryList;

    @FindBy(xpath = "//a[contains(@class,'btnn action__su')]")
    WebElement placeOrder;

/*    WebElement emailIn  =driver.findElement(By.xpath("//input[contains(@class,'input txt text-validated ng-unt')]"));
        emailIn.sendKeys("apurvanaik42@academy.com");

    WebElement country  =driver.findElement(By.xpath("(//input[contains(@class,'input txt text-validated')])[3]"));
        country.sendKeys("Ind");

    List<WebElement> countryList = driver.findElements(By.xpath("//button[contains(@class,'ta-item list-group-item ng-star-inserted')]//span"));
    WebElement countrynew =countryList.stream().filter(country1->country1.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
        countrynew.click();


    WebElement placeOrder  =driver.findElement(By.xpath("//a[contains(@class,'btnn action__su')]"));
        actions.moveToElement(placeOrder).build().perform();

        placeOrder.click();*/


    public Boolean verifyProductinCartList(String productName){
        Boolean flag = cartList.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
return flag;
    }

    public void checkout(){
        try{
            checkoutBtn.click();
        }catch (ElementClickInterceptedException e){
            checkoutBtn.click();
        }

    }

    public ConfirmationPage placeOrder(String emailIdVal,String countryVal,String contryExpVal){
       waitforElementtoClickable(emailIn);
        //emailIn.clear();
        emailIn.sendKeys(emailIdVal);
        country.sendKeys(countryVal);
WebElement countryNew =countryList.stream().filter(country1->country1.getText().equalsIgnoreCase(contryExpVal)).findFirst().orElse(null);
        countryNew.click();
        actions.moveToElement(placeOrder).build().perform();
        placeOrder.click();
        return new ConfirmationPage(driver);

    }


}
