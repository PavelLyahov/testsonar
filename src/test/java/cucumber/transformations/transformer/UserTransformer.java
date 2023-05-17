package cucumber.transformations.transformer;

import cucumber.transformations.models.User;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class UserTransformer {

    @DataTableType
    public User userTransformer(Map<String, String> row) {
        return new User(
                row.get("firstName"),
                row.get("lastName"),
                row.get("email"),
                row.get("password")
        );
    }

}
