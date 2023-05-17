package pages;


import constants.AccountItemsStatus;
import framework.elements.Button;
import framework.elements.Label;
import framework.utils.LoggerUtils;
import org.openqa.selenium.By;
import pages.core.AccountActions;
import pages.core.BaseAccountForm;
import pages.core.BaseForm;

public class MyAccountBidsForm extends BaseForm implements AccountActions {
    private final Button currentBidsButton = new Button(By.id("currentRadioBtn"), "Current Bids Button");
    private final Button pastBidsButton = new Button(By.id("pastRadioBtn"), "Past Bids Button");
    private final Label noCurrentBidsLabel = new Label(By.xpath("//*[text() = \"You have no \" and text()=\" bids.\"]//span[text()='Current']"),
            "No Current Bids Label");
    private final Label noPastBidsLabel = new Label(By.xpath("//*[text() = \"You have no \" and text()=\" bids.\"]//span[text()='Past']"),
            "No Past Bids Label");

    public MyAccountBidsForm() {
        super(new Label(By.xpath("//h1[contains(text(), 'Bids')]"), "Bids header label"), "User Bids form");
    }

    @Override
    public void selectItemStatus(AccountItemsStatus status) {
        switch (status) {
            case CURRENT:
                System.out.println("MyAccountBidsForm  current");
                break;
            case PAST:
                System.out.println("MyAccountBidsForm  pas");
                break;
            default:
                throw new IllegalArgumentException("Status is not correct");
        }
    }

    public boolean isBidsListEmpty(String status) {
        switch (status.toLowerCase()) {
            case "current":
                noCurrentBidsLabel.waitForDisplayed();
                return noCurrentBidsLabel.isElementDisplayed();
            case "past":
                noPastBidsLabel.waitForDisplayed();
                return noPastBidsLabel.isElementDisplayed();
            default:
                throw new IllegalArgumentException("Status is not correct");
        }
    }
}
