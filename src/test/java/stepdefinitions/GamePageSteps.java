package stepdefinitions;

import framework.utils.LoggerUtils;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.GamePage;

import java.util.ArrayList;
import java.util.List;


public class GamePageSteps {
    private final GamePage gamePage = new GamePage();

    @Then("^Game Page Is Open$")
    public void gamePageIsOpen() {
        Assert.assertTrue(gamePage.isFormOpen(), " is not open");
    }

    @Then("^There are \"([^\"]*)\"-1 characters in the \"([^\"]*)\" on Checkout page$")
    public void checkCharactersCountInField(String countCharacters, String fieldName) {
        LoggerUtils.makeLog(countCharacters + " - " + fieldName);
    }

    @Then("^The following fields are not filled in:$")
    public void checkList(List<String> storeName) {
        storeName.forEach(LoggerUtils::makeLog);
        storeName.forEach(System.out::println);
    }


}
