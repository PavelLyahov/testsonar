package cucumber.transformations.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
    public String cardNumber;
    public String cvc;
    public String expireDate;
    public String country;
    public String state;
    public String address;
    public String city;
    public String postalCode;
}
