package utils;

import aquality.appium.mobile.application.AqualityServices;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.ContextAware;
import java.util.Set;

@UtilityClass
public class Context {

    private final ContextAware appiumdriver = (ContextAware) AqualityServices.getApplication().getDriver();

    public void contexts() {

        //get the current context
        String currentContext = appiumdriver.getContext();
        System.out.println(currentContext);

        // get a list of all contexts
        Set<String> contextNames  = appiumdriver.getContextHandles();
        System.out.println(String.join("\n", contextNames));

        // get a list of all contexts
        //the app is only using NATIVE_APP
        Set<String> availableContexts = appiumdriver.getContextHandles();
        for(String context : availableContexts) {
            System.out.println("context : " + context );
        }
    }
}
