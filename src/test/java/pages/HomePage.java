package pages;

import framework.elements.Button;
import org.openqa.selenium.By;
import pages.core.BaseForm;

public class HomePage extends BaseForm {
    private final Button nextPageLink = new Button(By.xpath("//a[@class='start__link']"), "Start link");

    public HomePage() {
        super(new Button(By.xpath("//a[@class='start__link']"), "Start link"), "Home page");
    }

    public void clickNextPageLink() {
        nextPageLink.click();
    }
}
