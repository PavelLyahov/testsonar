package framework.elements;


import framework.browser.Browser;
import framework.browser.DriverSingleton;
import framework.browser.WaitUtils;
import framework.utils.LoggerUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class BaseElement {
    protected static final DriverSingleton singleton = DriverSingleton.getInstance();
    protected final By locator;
    protected final String name;

    BaseElement(By locator, String name) {

        this.locator = locator;
        this.name = name;
    }

    public void waitForDisplayed() {
        LoggerUtils.makeLog("Wait for displaying of " + name);
        WaitUtils.waitForElementVisibility(locator);
    }

    public void waitForInvisible() {
        LoggerUtils.makeLog("Wait for invisibility of " + name);
        WaitUtils.waitForElementInvisibility(locator);
    }

    public void click() {
        LoggerUtils.makeLog("Click on " + name);
        WaitUtils.waitForElementToBeClickable(locator);
        find().click();
    }

    public String getAttribute(String attribute){
        LoggerUtils.makeLog("Get " + attribute + " attribute of " + name);
        WaitUtils.waitForElementVisibility(locator);
        return find().getAttribute(attribute);
    }

    public void focus() {
        LoggerUtils.makeLog("Focus on " + name);
        WaitUtils.waitForElementToBeClickable(locator);
        new Actions(Browser.getDriver()).moveToElement(find()).perform();
    }

    public String getText() {
        LoggerUtils.makeLog("Get text of " + name);
        WaitUtils.waitForElementVisibility(locator);
        return find().getText();
    }

    public void scroll() {
        LoggerUtils.makeLog("Scroll to " + name);
        WaitUtils.waitForElementVisibility(locator);
        ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", find());
    }

    public boolean isElementDisplayed(){
        LoggerUtils.makeLog("Check that " + name + " is displayed");
        return Browser.getDriver().findElements(locator).size() > 0;
    }

    protected WebElement find() {
        return Browser.getElement(locator);
    }

    public By getLocator() {
        return locator;
    }
}