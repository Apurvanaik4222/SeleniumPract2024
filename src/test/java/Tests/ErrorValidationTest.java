package Tests;

import TestComponent.BaseTest;
import TestComponent.RetyfailedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorValidationTest extends BaseTest {

    @Test(groups = "ErrorValidation",retryAnalyzer = RetyfailedTest.class)
    public void invalidLoginDetails(){
        loginToApp("apurvanaik42@academy.com","Improve@123467");
        Assert.assertEquals(landingPage.getErrorMsg(),"Incorrect email or password.");

    }
}
