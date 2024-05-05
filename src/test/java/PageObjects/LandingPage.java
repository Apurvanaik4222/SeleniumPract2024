package PageObjects;

import AbstractComponents.AbstractCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractCode {

    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='userPassword']")
    WebElement password;

    @FindBy(xpath = "//input[@id='login']")
    WebElement submit;

    @FindBy(xpath = "//*[@id='toast-container']/div/div")
    WebElement loginErrorMsg;

    public ProductListPage Login(String userNameVal,String passwordVal)
    {
        userName.sendKeys(userNameVal);
        password.sendKeys(passwordVal);
        submit.click();
       return new ProductListPage(driver);

    }

    public String getErrorMsg(){
        waitforElementtoClickable(loginErrorMsg);
        return loginErrorMsg.getText();

    }
}
