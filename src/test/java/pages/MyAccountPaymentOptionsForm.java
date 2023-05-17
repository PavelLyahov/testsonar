package pages;


import cucumber.transformations.modelfields.CreditCardField;
import cucumber.transformations.models.CreditCard;
import cucumber.utilities.ClassUtils;
import framework.browser.Browser;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextField;
import framework.utils.LoggerUtils;
import org.openqa.selenium.By;
import pages.core.BaseForm;

import java.lang.reflect.Field;
import java.util.List;

public class MyAccountPaymentOptionsForm extends BaseForm {

    private final Button addNewCardButton = new Button(By.xpath("//button[text()='Add a new card']"), "Add A New Card button");
    private final Button editSubscriptionButton = new Button(By.xpath("//a[text()='Edit subscription payments']"), "Edit Subscription Payments button");

    private final TextField cardNumberTextField = new TextField(By.xpath("//input[contains(@class, 'card-number-input')]"), "Card number text field");
    private final Label validCardNumberLabel = new Label(By.xpath("//input[contains(@class, 'card-number-input') and not (contains(@class, 'invalid'))]"), "Valid card number label");
    private final Label invalidCardNumberLabel = new Label(By.xpath("//input[contains(@class, 'card-number-input') and contains(@class, 'invalid')]"), "Invalid card number label");

    private final TextField expireDateTextField = new TextField(By.xpath("//input[@name='cc-exp']"), "Expire date text field");
    private final Label validDateLabel = new Label(By.xpath("//input[@name='cc-exp' and @aria-invalid='false']"), "Valid Date label");
    private final Label invalidDateLabel = new Label(By.xpath("//input[@name='cc-exp' and @aria-invalid='true']"), "Valid card number label");

    private final TextField cvcTextField = new TextField(By.xpath("//input[@aria-placeholder = 'CVN']"), "CVC date text field");
    private final Label validCVCLabel = new Label(By.xpath("//input[@aria-placeholder='CVN' and @aria-invalid='false']"), "Valid CVC label");
    private final Label invalidCVCLabel = new Label(By.xpath("//input[@aria-placeholder='CVN' and @aria-invalid='true']"), "Invalid CVC label");

    private final Button countryArrowButton = new Button(By.xpath("//div[contains(@class, 'form-group') and descendant::div[@class='Select-input']]//span[contains(@class, 'arrow-zone')]"),
            "Country arrow button");

    private final TextField addressTextField = new TextField(By.xpath("//input[@placeholder='Address']"), "Address text field");
    private final Label validAddressLabel = new Label(By.xpath("//div[contains(@class,'undefined')]//input[@placeholder='Address']"), "Valid Address label");
    private final Label invalidAddressLabel = new Label(By.xpath("//div[contains(@class,'error')]//input[@placeholder='Address']"), "Invalid Address label");

    private final TextField cityTextField = new TextField(By.xpath("//input[@name='addressCity']"), "City country text field");
    private final Label validCityLabel = new Label(By.xpath("//div[contains(@class,'undefined')]//input[@name='addressCity']"), "Valid City label");
    private final Label invalidCityLabel = new Label(By.xpath("//div[contains(@class,'has-error')]//input[@name='addressCity']"), "Invalid City label");

    private final TextField stateTextField = new TextField(By.xpath("//input[@name='province']"), "State text field");
    private final Button stateArrowButton = new Button(By.xpath("//div[contains(@class, 'form-group') and descendant::div[text()='Province' or text()='State']]//span[contains(@class, 'arrow-zone')]"),
            "Country arrow button");

    private final TextField postalCodeTextField = new TextField(By.xpath("//input[@name='postalCode']"), "Postal Code text field");
    private final Label validPostalCodeLabel = new Label(By.xpath("//div[contains(@class,'space')]//input[@name='postalCode']"), "Valid Postal Code label");
    private final Label invalidPostalCodeLabel = new Label(By.xpath("//div[contains(@class,'has-error')]//input[@name='postalCode']"), "Invalid Postal Code label");

    private final Button saveCardCardButton = new Button(By.xpath("//button[text()='Save card']"), "Save Card Card button");
    private final Button confirmDeleteCardButton = new Button(By.xpath("//button[contains(text(), 'Delete Card')]"), "Confirm Delete Card button");
    private final Button cancelButton = new Button(By.xpath("//div[@class='modal-footer']//button[text()='Cancel']"), "Cancel button");

    private final String addedCardLoc = "//*[text() =\"%s\"]//ancestor::div[contains(@style, 'margin')]//*[contains(text(), 'Credit Card')]";
    private final String deleteCardLoc = "//*[text() =\"%s\"]//ancestor::div[contains(@style, 'margin')]//*[contains(text(), 'Delete')]";
    private final String makePrimaryCardLoc = "//*[text() =\"%s\"]//ancestor::div[contains(@style, 'margin')]//*[contains(text(), 'Primary')]";
    private final String countryAndStateFromListLoc = "//*[text() =\"%s\" and not (@class='Select-value-label')]";
    private final String currentCountryAndStateLoc = "//*[text() =\"%s\" and @class='Select-value-label']";
    private final String errorMessageLoc = "//div[contains (@class, 'form-group')]//label[contains(@class, 'control-label') and text()='%s']";

    private final String cardNumberFrameLoc = "//iframe[contains(@title, 'card number')]";
    private final String cvcFrameLoc = "//iframe[contains(@title, 'security code')]";

    public MyAccountPaymentOptionsForm() {
        super(new Label(By.xpath("//div[@class='purchasesHeader']//*[contains(text(), 'Payment Options')]"),
                "Payment Options"), "Payment Options Page");
    }

    public void createNewCard(CreditCard creditCard, boolean withSaving) {
        addNewCardButton.click();
        saveCardCardButton.waitForDisplayed();

        for (Field field : ClassUtils.getNotEmptyFields(creditCard)) {

            switch (CreditCardField.valueOf(field.getName())) {
                case CARD_NUMBER: {
                    enterCardNumber(creditCard.getCardNumber());
                    break;
                }
                case CVC: {
                    enterExpiredDate(creditCard.getExpireDate());
                    break;
                }
            }
        }
    }

    public void enterCardNumber(String cardNumber) {
        Browser.switchToFrameByXpath(cardNumberFrameLoc);
        cardNumberTextField.sendTextWithClipboard(cardNumber);
        Browser.returnToDefaultFrame();
    }

    public void enterExpiredDate(String expiredDate) {
        Browser.switchToFrameByXpath(cardNumberFrameLoc);
        cardNumberTextField.sendTextWithClipboard(expiredDate);
        Browser.returnToDefaultFrame();
    }

    public void printCreditCard(CreditCard creditCard, boolean withSaving) {
        System.out.println("withSaving: " + withSaving);

        try {
            for (Field cardModelField : creditCard.getClass().getDeclaredFields()) {
                if (cardModelField.get(creditCard) != null) {
                    switch (cardModelField.getName()) {
                        case "cardNumber":
                            System.out.println(creditCard.getCardNumber());
                            break;
                        case "expireDate":
                            System.out.println(creditCard.getExpireDate());
                            break;
                        case "cvc":
                            System.out.println(creditCard.getCvc());
                            break;
                        case "country":
                            System.out.println(creditCard.getCountry());
                            break;
                        case "address":
                            System.out.println(creditCard.getAddress());
                            break;
                        case "city":
                            System.out.println(creditCard.getCity());
                            break;
                        case "state":
                            System.out.println(creditCard.getState());
                            break;
                        case "postalCode":
                            System.out.println(creditCard.getPostalCode());
                            break;
                        default:
                            throw new IllegalArgumentException("Field name is not correct");
                    }
                }
            }
        } catch (IllegalAccessException e) {
            LoggerUtils.makeWarningLog("Exception while getting models from DataTable " + e.getMessage());
        }

    }

    public boolean checkFieldCorrection(String field, boolean isCorrect) {

        System.out.println(field);
        System.out.println(isCorrect);
        return true;
    }

//    public boolean checkFieldCorrection(String field, boolean isCorrect) {
//        boolean isStatusCorrect;
//        switch (field.toLowerCase()) {
//            case "card number":
//                Browser.switchToFrameByXpath(cardNumberFrameLoc);
//                if (isCorrect) {
//                    validCardNumberLabel.waitForDisplayed();
//                    isStatusCorrect = validCardNumberLabel.isElementDisplayed();
//                } else {
//                    invalidCardNumberLabel.waitForDisplayed();
//                    isStatusCorrect = invalidCardNumberLabel.isElementDisplayed();
//                }
//                Browser.returnToDefaultFrame();
//                return isStatusCorrect;
//            case "mm/yy":
//                if (isCorrect) {
//                    validDateLabel.waitForDisplayed();
//                    isStatusCorrect = validDateLabel.isElementDisplayed();
//                } else {
//                    invalidDateLabel.waitForDisplayed();
//                    isStatusCorrect = invalidDateLabel.isElementDisplayed();
//                }
//                return isStatusCorrect;
//            case "cvc":
//                Browser.switchToFrameByXpath(cvcFrameLoc);
//                if (isCorrect) {
//                    validCVCLabel.waitForDisplayed();
//                    isStatusCorrect = validCVCLabel.isElementDisplayed();
//                } else {
//                    invalidCVCLabel.waitForDisplayed();
//                    isStatusCorrect = invalidCVCLabel.isElementDisplayed();
//                }
//                Browser.returnToDefaultFrame();
//                return isStatusCorrect;
//            case "address":
//                if (isCorrect) {
//                    validAddressLabel.waitForDisplayed();
//                    isStatusCorrect = validAddressLabel.isElementDisplayed();
//                } else {
//                    invalidAddressLabel.waitForDisplayed();
//                    isStatusCorrect = invalidAddressLabel.isElementDisplayed();
//                }
//                return isStatusCorrect;
//            case "city":
//                if (isCorrect) {
//                    validCityLabel.waitForDisplayed();
//                    isStatusCorrect = validCityLabel.isElementDisplayed();
//                } else {
//                    invalidCityLabel.waitForDisplayed();
//                    isStatusCorrect = invalidCityLabel.isElementDisplayed();
//                }
//                return isStatusCorrect;
//            case "postal code":
//                if (isCorrect) {
//                    validPostalCodeLabel.waitForDisplayed();
//                    isStatusCorrect = validPostalCodeLabel.isElementDisplayed();
//                } else {
//                    invalidPostalCodeLabel.waitForDisplayed();
//                    isStatusCorrect = invalidPostalCodeLabel.isElementDisplayed();
//                }
//                return isStatusCorrect;
//            default:
//                throw new IllegalArgumentException("Field name is not correct");
//        }
//    }

    public String getFieldValue(String field) {
        switch (field) {
            case "cardNumber":
                String cardNumberValue;
                Browser.switchToFrameByXpath(cardNumberFrameLoc);
                cardNumberValue = cardNumberTextField.getAttribute("value");
                Browser.returnToDefaultFrame();
                return cardNumberValue;
            case "expireDate":
                return expireDateTextField.getAttribute("value");
            case "cvc":
                String cvcValue;
                Browser.switchToFrameByXpath(cvcFrameLoc);
                cvcValue = cvcTextField.getAttribute("value");
                Browser.returnToDefaultFrame();
                return cvcValue;
            default:
                throw new IllegalArgumentException("Field name is not correct");
        }
    }

    public void openAddCardForm() {
        addNewCardButton.click();
    }

    public void waitForAppearingCard(String cardNumber) {
        getAddedCardLabel(cardNumber).waitForDisplayed();
    }

    public void waitForDisappearingCard(String cardNumber) {
        getAddedCardLabel(cardNumber).waitForInvisible();
    }

    public void makeCardPrimary(String cardNumber) {
        new Button(By.xpath(String.format(makePrimaryCardLoc, cardNumber)), "Make Primary card button").click();
    }

    public boolean isCardDisplayed(String cardNumber) {
        return getAddedCardLabel(cardNumber).isElementDisplayed();
    }

    public void deleteCard(String cardNumber) {
        new Label(By.xpath(String.format(deleteCardLoc, cardNumber)), "Delete card label").click();
        confirmDeleteCardButton.click();
        confirmDeleteCardButton.waitForInvisible();
    }

    public boolean isAddNewCardButtonVisible() {
        return addNewCardButton.isElementDisplayed();
    }

    public boolean isCardNumberIncorrect() {
        Browser.switchToFrameByXpath(cardNumberFrameLoc);
        invalidCardNumberLabel.waitForDisplayed();
        boolean isIncorrect = invalidCardNumberLabel.isElementDisplayed();
        Browser.returnToDefaultFrame();
        return isIncorrect;
    }

    public boolean isEditSubscriptionButtonVisible() {
        return editSubscriptionButton.isElementDisplayed();
    }

    public void cancelAddCreditCardForm() {
        cancelButton.click();
    }

    public boolean isErrorMessageVisible(String message) {
        Label errorMessageLabel = new Label(By.xpath(String.format(errorMessageLoc, message)), message + " label");
        errorMessageLabel.waitForDisplayed();
        return errorMessageLabel.isElementDisplayed();
    }

    private Label getAddedCardLabel(String numberOfCard) {
        return new Label(By.xpath(String.format(addedCardLoc, numberOfCard)), numberOfCard + " credit card");
    }
}