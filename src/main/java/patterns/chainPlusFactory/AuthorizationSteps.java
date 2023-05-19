package patterns.chainPlusFactory;

public class AuthorizationSteps {

    public static void verifyAuthorization() {
        String userId = PageFactory.getPage(LoginPage.class)
                .fillPassword()
                .clickAcceptButton()
                .getUserId();
        System.out.println("Here should be assert, verify id" + userId);
    }
}
