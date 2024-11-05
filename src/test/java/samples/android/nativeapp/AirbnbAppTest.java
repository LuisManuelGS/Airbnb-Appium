package samples.android.nativeapp;

import integration.screens.DestinationScreen;
import integration.screens.HomeScreen;
import integration.screens.RoomScreen;
import integration.screens.SettingDatesScreen;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.WaitForAlertPresent;

public class AirbnbAppTest extends BaseTest{

    HomeScreen homeScreen = new HomeScreen();
    SettingDatesScreen settingDatesScreen = new SettingDatesScreen();
    DestinationScreen destinationScreen = new DestinationScreen();
    RoomScreen roomScreen = new RoomScreen();

    private final String GO_TO = "Paris";
    private final String DESTINATION = "Paris, France";

    @Test
    public void test() throws InterruptedException {
        WaitForAlertPresent.dismissAlert();
        Assert.assertTrue(homeScreen.state().waitForDisplayed(),"Search options are not displayed");
        homeScreen.clickOnSearchBar();
        homeScreen.inputText(GO_TO);
        Assert.assertTrue(homeScreen.searchResults(),"Results are not displayed");
        homeScreen.clickFirstResult(0);
        Assert.assertEquals(settingDatesScreen.getDestination(), DESTINATION, "Destination does not match");
        settingDatesScreen.checkInAndCheckOut();
        settingDatesScreen.clickNextBtn();

    }

    //test case avoiding setting dates
    @Test
    public void test2() throws InterruptedException {
        WaitForAlertPresent.dismissAlert();
        Assert.assertTrue(homeScreen.state().waitForDisplayed(),"Search options are not displayed");
        homeScreen.clickOnSearchBar();
        homeScreen.clickFirstResult(0);
        Assert.assertTrue(destinationScreen.isResultsListDisplayed(),"Results are not displayed");
        destinationScreen.clickSharedRoom();
        roomScreen.clickCloseTranslationOn();
        Assert.assertTrue(roomScreen.isNameDisplayed(),"Name is not displayed");
        Assert.assertTrue(roomScreen.isPriceDisplayed(),"Price is not displayed");

    }

}
