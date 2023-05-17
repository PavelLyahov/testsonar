package framework.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    private static final DriverSingleton singleton = DriverSingleton.getInstance();
    private static final int WAITING_TIME = 30;

    private WaitUtils() {
    }

    public static void waitForElementToBeClickable(By locator) {

        new WebDriverWait(singleton.getDriver(), WAITING_TIME)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForElementVisibility(By locator) {

        return new WebDriverWait(singleton.getDriver(), WAITING_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementInvisibility(By locator) {

        new WebDriverWait(singleton.getDriver(), WAITING_TIME)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

}