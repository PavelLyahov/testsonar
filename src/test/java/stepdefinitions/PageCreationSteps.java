package stepdefinitions;

import constants.AccountItemsStatus;
import io.cucumber.java.en.When;
import pages.core.PageFactory;

public class PageCreationSteps {

    @When("^I set '(.*)' status on '(.*)' form on My Account page$")
    public void selectStatusOnMyAccountPageForm(AccountItemsStatus status, String form) {
        PageFactory.getAccountForm(form).selectItemStatus(status);
    }
}
