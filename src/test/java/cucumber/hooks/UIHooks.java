package cucumber.hooks;

import framework.browser.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class UIHooks {
    @Before(value="@UIConfiguration")
    public void configureDriver(){
        Browser.initializeWebDriver();
        Browser.getDriver().manage().window().maximize();
    }

    @After(value="@UIConfiguration")
    public void cleanupDriver(){
        Browser.quitWebDriver();
    }
}
