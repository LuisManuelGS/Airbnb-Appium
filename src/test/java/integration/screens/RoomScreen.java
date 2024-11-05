package integration.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class RoomScreen extends Screen {

    private final ILabel translation = AqualityServices.getElementFactory().getLabel(By.xpath("//android.widget.Button[@content-desc=\"Close\"]/android.widget.ImageView"),"translation");
    private final ILabel name = AqualityServices.getElementFactory().getLabel(By.id("com.airbnb.android:id/header_row_title"),"name");
    private final ILabel price = AqualityServices.getElementFactory().getLabel(By.id("com.airbnb.android:id/n2_dls_action_footer_title"),"price");

    public RoomScreen() {
        super(By.xpath("//android.widget.GridView[@content-desc=\"pdp\"]/android.widget.FrameLayout[4]"), "title");
    }

    public void clickCloseTranslationOn() {
        translation.click();
    }

    public boolean isNameDisplayed() {
        return name.state().waitForDisplayed();
    }

    public boolean isPriceDisplayed() {
        return price.state().waitForDisplayed();
    }
}
