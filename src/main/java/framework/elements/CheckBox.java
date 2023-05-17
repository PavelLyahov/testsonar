package framework.elements;

import framework.browser.WaitUtils;
import framework.utils.LoggerUtils;
import org.openqa.selenium.By;

public class CheckBox extends BaseElement{
    public CheckBox(By locator, String name) {
        super(locator, name);
    }

    public boolean isSelected(){
        LoggerUtils.makeLog("Check the status of " + name);
        WaitUtils.waitForElementToBeClickable(locator);
        return find().isSelected();
    }

    public void select(){
        LoggerUtils.makeLog("Select " + name);
        WaitUtils.waitForElementToBeClickable(locator);
        if(!find().isSelected()){
            find().click();
        }
    }

    public void unselect(){
        LoggerUtils.makeLog("Unselect " + name);
        WaitUtils.waitForElementToBeClickable(locator);
        if(find().isSelected()){
            find().click();
        }
    }

    public void setState(boolean state){
        LoggerUtils.makeLog("Set " + state + " state for " + name);
        if(state){
            select();
        }
        else{
            unselect();
        }
    }
}
