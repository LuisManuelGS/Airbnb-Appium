package samples.android.nativeapp;

import aquality.appium.mobile.application.AqualityServices;
import integration.screens.HomeScreen;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AirbnbAppTest extends BaseTest{

    HomeScreen homeScreen = new HomeScreen();

    private final String DESTINATION = "Paris";


    @Test
    public void test() throws InterruptedException {
        Thread.sleep(5000);
        Alert alert = AqualityServices.getApplication().getDriver().switchTo().alert();
        alert.dismiss();
        Assert.assertTrue(homeScreen.state().waitForDisplayed(),"Search options are not displayed");


        Assert.assertTrue(homeScreen.state().waitForDisplayed(),"Search options are not displayed");
        homeScreen.clickOnSearchBar();
        homeScreen.inputText(DESTINATION);
        Assert.assertTrue(homeScreen.searchResults(),"Results are not displayed");
        Thread.sleep(5000);
        homeScreen.clickFirstResult();
    }
}
