package Tests;

import PageObjects.CartPage;
import PageObjects.ConfirmationPage;
import PageObjects.LandingPage;
import PageObjects.ProductListPage;
import TestComponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class productCartTest extends BaseTest {


    @Test(groups = {"Smoke"},dataProvider = "getData")
    public void addProduct(HashMap<String,String> map) throws IOException {
        String productName = map.get("productName");
        loginToApp(map.get("email"),map.get("password"));

        productListPage.addProductToCart(productName);

        CartPage cartPage = productListPage.clickCartLink();
        Boolean flag = cartPage.verifyProductinCartList(productName);
        Assert.assertTrue(flag);
        cartPage.checkout();
        ConfirmationPage confirmationPage = cartPage.placeOrder("apurvanaik42@academy.com", "ind", "India");
        Assert.assertEquals(confirmationPage.sucessText(), "THANKYOU FOR THE ORDER.");
        System.out.println("naik AP");


    }

   @DataProvider
   public Object[][] getData() throws IOException {
       List<HashMap<String,String>> list = jsonDataReader(System.getProperty("user.dir")+"\\src\\test\\java\\data\\addProduct.json");

       Object[][] data ={{list.get(1)}};

        //Object[][] data ={{"apurvanaik42@academy.com","Improve@1234"}};
        return data;
    }
}
