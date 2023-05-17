package stepdefinitions;

import constants.AccountItemsStatus;
import io.cucumber.java.en.When;

public class TransformAccountStatus {

    @When("Status '{accountItemsStatus}'")
    public void transformAccountStatus(AccountItemsStatus accountItemsStatus) {
        System.out.println(accountItemsStatus);
//        System.out.println(form);
    }
}
