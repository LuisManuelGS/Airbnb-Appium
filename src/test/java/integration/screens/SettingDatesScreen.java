package integration.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class SettingDatesScreen extends Screen {

    private final ILabel destination = AqualityServices.getElementFactory().getLabel(By.xpath("//android.widget.TextView[contains(@text, \"Paris\")]\n"),"Paris");
    private final ILabel checkIn = AqualityServices.getElementFactory().getLabel(By.xpath("//android.view.View[@content-desc=\"Search input\"]/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[6]"),"today");
    private final ILabel checkOut = AqualityServices.getElementFactory().getLabel(By.xpath("//android.widget.TextView[@text=\"7 days\"]"),"+ 7 days");
    private final IButton nextBtn = AqualityServices.getElementFactory().getButton(By.xpath("//android.view.View[@content-desc=\"Search input\"]/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[6]/android.widget.Button"),"Next");

    public SettingDatesScreen() {
        super(By.xpath("//android.widget.TextView[@text=\"Paris, France\"]"), "Destination");
    }

    public String getDestination() {
        return destination.getText();
    }

    public void checkInAndCheckOut(){
        checkIn.click();
        checkOut.click();
    }

    public void clickNextBtn() {
        nextBtn.click();
    }
}
