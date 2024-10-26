package utils;

import aquality.appium.mobile.actions.TouchActions;
import aquality.appium.mobile.application.AqualityServices;
import io.appium.java_client.AppiumDriver;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import java.sql.SQLException;

@UtilityClass
public class Scroll {

    private final AppiumDriver driver = AqualityServices.getApplication().getDriver();

    public void scrollDown() throws SQLException {
        Dimension size = driver.manage().window().getSize();

        int startX = size.getWidth() / SettingsTestData.getCoordinates().getMidpointOfScreenWidth();
        int startY = (int) (size.getHeight() * SettingsTestData.getCoordinates().getScreenHeight80Percent());
        int endY = (int) (size.getHeight() * SettingsTestData.getCoordinates().getScreenHeight25Percent());

        TouchActions touchActions = new TouchActions();
        touchActions.swipe(new Point(startX, startY), new Point(startX, endY));
        touchActions.swipe(new Point(startX, startY), new Point(startX, endY));
        touchActions.swipe(new Point(startX, startY), new Point(startX, endY));
    }

    public void scrollUp() {
        Dimension size = driver.manage().window().getSize();

        int startX = size.getWidth() / SettingsTestData.getCoordinates().getMidpointOfScreenWidth();
        int startY = (int) (size.getHeight() * SettingsTestData.getCoordinates().getScreenHeight25Percent());
        int endY = (int) (size.getHeight() * SettingsTestData.getCoordinates().getScreenHeight80Percent());

        TouchActions touchActions = new TouchActions();

        touchActions.swipe(new Point(startX, startY), new Point(startX, endY));
        touchActions.swipe(new Point(startX, startY), new Point(startX, endY));
        touchActions.swipe(new Point(startX, startY), new Point(startX, endY));
    }
}
