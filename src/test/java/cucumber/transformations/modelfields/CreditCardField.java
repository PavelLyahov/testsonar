package cucumber.transformations.modelfields;

public enum CreditCardField {
    CARD_NUMBER("cardNumber"),
    CVC("cvc"),
    EXPIRED_DATE("expireDate"),
    COUNTRY("country"),
    STATE("state"),
    ADDRESS("address"),
    CITY("city"),
    POSTAL_CODE("postalCode");

    private final String fieldName;

    CreditCardField(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getName() {
        return this.fieldName;
    }
}
