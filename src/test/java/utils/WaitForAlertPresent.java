package utils;

import aquality.appium.mobile.application.AqualityServices;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.Alert;

@UtilityClass
public class WaitForAlertPresent {

    public void dismissAlert() {
        // Here, we wait until the alert is present.
        long timeout = System.currentTimeMillis() + 10000; // 10 seconds
        while (System.currentTimeMillis() < timeout) {
            try {
                Alert alert = AqualityServices.getApplication().getDriver().switchTo().alert();
                alert.dismiss();
                System.out.println("dismissed alert");
                break;
            } catch (Exception e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

}
