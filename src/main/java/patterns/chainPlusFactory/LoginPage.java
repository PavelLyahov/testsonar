package patterns.chainPlusFactory;

public class LoginPage {
    private String passwordField = "I am password field";
    private String acceptButton = "I am button";

    public LoginPage fillPassword() {
        System.out.println("I fill pass " + passwordField);
        return PageFactory.getPage(LoginPage.class);
    }

    public UserAccountPage clickAcceptButton() {
        System.out.println("I click on button " + acceptButton);
        return PageFactory.getPage(UserAccountPage.class);
    }

}
