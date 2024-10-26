package integration.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import java.util.List;

public class HomeScreen extends Screen {

    //private final IButton searchBar = AqualityServices.getElementFactory().getButton(By.xpath("//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.airbnb.android:id/search_input_bar\"]/android.view.View/android.view.View/android.view.View/android.widget.Button"),"Search Bar");
    private final IButton searchBar = AqualityServices.getElementFactory().getButton(AppiumBy.androidUIAutomator("new UiSelector().text(\"Where to?\")"),"Search Bar");
    private final ILabel searchDestination = AqualityServices.getElementFactory().getLabel(By.xpath("//android.widget.TextView[@text=\"Search destinations\"]"),"Search destinations");
    private final ITextBox typeDestination = AqualityServices.getElementFactory().getTextBox(By.xpath("//android.widget.EditText"),"Type destination");
    private final By RESULTS = By.xpath("(//android.view.View[@content-desc=\"Search input\"])[2]/android.view.View/android.view.View/android.view.View");
   // private final List<ILabel> results = AqualityServices.getElementFactory().findElements(By.xpath("(//android.view.View[@content-desc=\"Search input\"])[2]/android.view.View/android.view.View/android.view.View") ,ElementType.LABEL);
    private final ILabel results = AqualityServices.getElementFactory().getLabel(By.xpath("(//android.view.View[@content-desc=\"Search input\"])[2]/android.view.View/android.view.View/android.view.View") ,"results");
    private final ILabel firstResult = AqualityServices.getElementFactory().getLabel(By.xpath("(//android.view.View[@content-desc=\"Search input\"])[2]/android.view.View/android.view.View/android.view.View/android.view.View[1]"),"first match");

    public HomeScreen() {
        super(By.xpath("//android.view.ViewGroup[@content-desc=\"Categories\"]/android.view.View/android.view.View"), "Categories");
    }

    public void clickOnSearchBar() {
        searchBar.click();
        searchDestination.click();
    }

    public void inputText(String text) {
        typeDestination.clearAndType(text);
    }

    public boolean searchResults() {
        return results.state().waitForDisplayed();
    }

    public void clickFirstResult() throws InterruptedException {
        firstResult.click();
        //results.get(1).click();
        //getResultsSugestionList().get(0).click();
    }

    private List<ILabel> getResultsSugestionList() {
        return AqualityServices.getElementFactory().findElements(RESULTS, "results", ElementType.LABEL);
    }
}
