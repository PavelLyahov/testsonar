package stepdefinitions;

import cucumber.transformations.models.CreditCard;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MyAccountPaymentOptionsForm;

public class CreditCardSteps {

    @When("^I create a new card with the fallowing parameters '(with|without)' saving on Payment Options page:$")
    public void fillSignUpForm(boolean withSaving, CreditCard creditCard) {
        MyAccountPaymentOptionsForm paymentOptionsPage = new MyAccountPaymentOptionsForm();
        paymentOptionsPage.waitForFormOpen();
        paymentOptionsPage.createNewCard(creditCard, withSaving);
    }

    @Then("^'(.*)' field has '(correct|incorrect)' data on Payment Options form$")
    public void checkCorrectData(String field, boolean isCorrect) {
        Assert.assertTrue(new MyAccountPaymentOptionsForm().checkFieldCorrection(field, isCorrect),
                field + " field has not correction status");
    }
}
