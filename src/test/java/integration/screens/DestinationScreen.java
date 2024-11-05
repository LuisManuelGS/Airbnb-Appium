package integration.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class DestinationScreen extends Screen {

    private final ILabel results = AqualityServices.getElementFactory().getLabel(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.airbnb.android:id/search_feed_container\"]/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View"), "Results");
    private final ILabel sharedRoom = AqualityServices.getElementFactory().getLabel(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.airbnb.android:id/search_feed_container\"]/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]"),"shared");

    public DestinationScreen() {
        super(By.xpath("//android.widget.TextView[@text=\"Any week · Add guests\"]"), "any week");
    }

    public boolean isResultsListDisplayed() {
        return results.state().waitForDisplayed();
    }

    public void clickSharedRoom(){
        sharedRoom.click();
    }

}
