package stepdefinitions;


import framework.browser.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MainSteps {

    @Given("^'(.*)' address is opened$")
    @When("^I go to '(.*)'$")
    public void goToAddress(String address) {
        Browser.getDriver().get(address);
    }

}
