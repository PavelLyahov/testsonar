package pages;

import constants.AccountItemsStatus;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;
import pages.core.AccountActions;
import pages.core.BaseAccountForm;
import pages.core.BaseForm;

public class MyAccountAuctionsForm extends BaseForm implements AccountActions {

    private final Button currentAuctionsButton = new Button(By.id("currentAuctionsRadio"), "Current Auctions Button");
    private final Button pastAuctionsButton = new Button(By.id("pastAuctionsRadio"), "Past Auctions Button");
    private final Label noAuctionsLabel = new Label(By.xpath("//*[text() = 'You do not have any upcoming auctions saved.']"),
            "No Auctions Label");

    public MyAccountAuctionsForm() {
        super(new Label(By.xpath("//h1[contains(text(), 'Auctions')]"), "Auctions header label"),
                "User Auctions form");
    }

    @Override
    public void selectItemStatus(AccountItemsStatus status) {
        switch (status) {
            case CURRENT:
                currentAuctionsButton.click();
                break;
            case PAST:
                pastAuctionsButton.click();
                break;
            default:
                throw new IllegalArgumentException("Status is not correct");
        }
    }

    public boolean isAuctionsListEmpty() {
        noAuctionsLabel.waitForDisplayed();
        return noAuctionsLabel.isElementDisplayed();
    }
}
