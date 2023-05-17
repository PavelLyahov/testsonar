package framework.browser;

import framework.utils.LoggerUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Browser {
    private static final DriverSingleton singleton = DriverSingleton.getInstance();
    private static WebDriver driver;

    private Browser() {
    }

    public static WebDriver initializeWebDriver() {
        LoggerUtils.makeLog("Initialization of driver object");
        driver = singleton.getDriver();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public static void switchToFrameByXpath(String xpath){
        LoggerUtils.makeLog("Switch to frame by xpath: " + xpath);
        WaitUtils.waitForElementVisibility(By.xpath(xpath));
        WebElement frameElement = driver.findElement(By.xpath(xpath));
        driver.switchTo().frame(frameElement);
    }

    public static void returnToDefaultFrame(){
        LoggerUtils.makeLog("Return to default frame");
        driver.switchTo().defaultContent();
    }

    public static void quitWebDriver() {
        LoggerUtils.makeLog("Closing driver");
        driver.quit();
        singleton.setDriverNull();
    }
}