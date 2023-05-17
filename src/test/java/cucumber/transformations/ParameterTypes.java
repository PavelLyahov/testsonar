package cucumber.transformations;


import constants.AccountItemsStatus;
import constants.Colors;
import io.cucumber.java.ParameterType;

public class ParameterTypes {

    @ParameterType("Current|Past")
    public AccountItemsStatus accountItemsStatus(String accountItemsStatus) {
        return AccountItemsStatus.parse(accountItemsStatus);
    }

    @ParameterType(value = "Green")
    public Colors colors(String color) {
        return Colors.parse(color);
    }

    @ParameterType("with|without")
    public Boolean isWith(String value) {
        return value.equals("with");
    }

    @ParameterType(value = "presented|not presented")
    public boolean isPresented(String isPresented) {
        return isPresented.equals("presented");
    }

    @ParameterType(value = "disappears|appears|disappeared|appeared")
    public boolean isAppears(String appears) {
        return !appears.contains("disappear");
    }

    @ParameterType(value = "equals|isn't equals")
    public boolean isEquals(String isEquals) {
        return isEquals.equals("equals");
    }

    @ParameterType(value = "editable|isn't editable")
    public boolean isEditable(String isEditable) {
        return isEditable.equals("editable");
    }

    @ParameterType(value = "check|uncheck")
    public boolean isCheck(String check) {
        return check.equals("check");
    }

    @ParameterType(value = "empty|not empty")
    public boolean isEmpty(String check) {
        return check.equals("empty");
    }

    @ParameterType(value = "exist|not exist")
    public boolean isExist(String check) {
        return check.equals("exist");
    }

    @ParameterType(value = "min|max")
    public boolean isMin(String check) {
        return check.equals("min");
    }

    @ParameterType(value = "active|inactive")
    public boolean isActive(String appears) {
        return appears.equals("active");
    }

}
