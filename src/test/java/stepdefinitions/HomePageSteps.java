package stepdefinitions;

import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;

public class HomePageSteps {
    private final HomePage homePage = new HomePage();

    public void homePageIsOpen() {
        Assert.assertTrue(homePage.isFormOpen(), " is not open");
    }

    @When("^I click next$")
    public void goToTheGamePage() {
        homePage.clickNextPageLink();
    }
}
