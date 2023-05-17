package cucumber.transformations.transformer;

import cucumber.transformations.modelfields.CreditCardField;
import cucumber.transformations.models.CreditCard;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CreditCardTransformer {

    @DataTableType
    public CreditCard creditCardTransformer(Map<String, String> row) {
        return new CreditCard(
                row.get(CreditCardField.CARD_NUMBER.getName()),
                row.get(CreditCardField.CVC.getName()),
                row.get(CreditCardField.EXPIRED_DATE.getName()),
                row.get(CreditCardField.COUNTRY.getName()),
                row.get(CreditCardField.STATE.getName()),
                row.get(CreditCardField.ADDRESS.getName()),
                row.get(CreditCardField.CITY.getName()),
                row.get(CreditCardField.POSTAL_CODE.getName())
        );
    }
}
