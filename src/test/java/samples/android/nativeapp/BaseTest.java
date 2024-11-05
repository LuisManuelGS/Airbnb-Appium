package samples.android.nativeapp;

import aquality.appium.mobile.application.AqualityServices;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        AqualityServices.getApplication();
    }

    @AfterMethod
    public void tearDown() {
        AqualityServices.getApplication().quit();
    }
}
