package framework.elements;

import framework.browser.WaitUtils;
import framework.utils.LoggerUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TextField extends BaseElement{

    public TextField(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String text) {
        LoggerUtils.makeLog("Send " + text + " to " + name);
        WebElement textField = WaitUtils.waitForElementVisibility(locator);
        textField.sendKeys(text == null? "" : text);
    }

    public void clearText() {
        LoggerUtils.makeLog("Clear text from  " + name);
        WebElement textField = WaitUtils.waitForElementVisibility(locator);
        textField.clear();
    }

    public void clearTextWithKeys() {
        LoggerUtils.makeLog("Clear text with ctrl+a+backspace from " + name);
        WebElement textField = WaitUtils.waitForElementVisibility(locator);
        click();
        textField.sendKeys(Keys.CONTROL + "a");
        textField.sendKeys(Keys.BACK_SPACE);
    }

    public void sendTextWithClipboard(String text) {
        LoggerUtils.makeLog("Send " + text + " via clipboard to " + name);
        WebElement textField = WaitUtils.waitForElementVisibility(locator);
        textField.click();
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        textField.sendKeys(Keys.CONTROL + "v");
    }
}
