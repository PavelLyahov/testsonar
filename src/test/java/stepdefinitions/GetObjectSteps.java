package stepdefinitions;

import cucumber.transformations.models.User;
import cucumber.utilities.ClassUtils;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.lang.reflect.Field;


public class GetObjectSteps {

    @Then("^Get object:$")
    public void checkEditProfileFields(User user) {
        System.out.println(user);

        for (Field profileModelField : ClassUtils.getNotEmptyFields(user)) {

        }
    }
}
