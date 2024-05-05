package PageObjects;

import AbstractComponents.AbstractCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductListPage extends AbstractCode {

    WebDriver driver;
    public ProductListPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='card-body']")
    List<WebElement> productList;

    @FindBy(xpath = "//div[@id='toast-container']")
    WebElement toastEle;

    @FindBy(xpath = "//div[@id='toast-container']")
    WebElement test;

    By productListEle =By.xpath("h5");
    By cartLink = By.xpath("button[@class='btn w-10 rounded']");

    public WebElement displayProductList(String productName){
        WebElement prod =productList.stream().filter(product->product.findElement(productListEle).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        return prod;
    }

    public void addProductToCart(String productName){
        WebElement prod  = displayProductList(productName);
        prod.findElement(cartLink).click();
        waitforElementtoClickable(toastEle);
        clickCartLink();
    }

}
