package pages;


import framework.elements.Label;
import org.openqa.selenium.By;
import pages.core.BaseForm;

public class GamePage extends BaseForm {
    private final Label timer = new Label(By.xpath("//div[contains(@class,'timer--white')]"), "Timer");

    public GamePage() {
        super(new Label(By.xpath("//div[contains(@class,'timer--white')]"), "Timer"), "Game page");
    }

    public String getTimerInitialValue() {
        return timer.getText();
    }
}
