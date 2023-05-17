package pages.core;

import pages.MyAccountAuctionsForm;
import pages.MyAccountBidsForm;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum PageFactory {
    MY_ACCOUNT_BIDS(MyAccountBidsForm.class, "bids"),
    MY_ACCOUNT_AUCTION(MyAccountAuctionsForm.class, "auctions");

    private final Class<?> clazz;
    private final String cucumberName;

    PageFactory(Class<?> clazz, String cucumberName) {
        this.clazz = clazz;
        this.cucumberName = cucumberName;
    }

    public static Class<?> getPageClass(String cucumberName) {
        for (PageFactory page : PageFactory.values()) {
            if (page.cucumberName.equals(cucumberName.toLowerCase())) {
                return page.clazz;
            }
        }
        throw new IllegalArgumentException("No page found with cucumber name: " + cucumberName);
    }

    public static <T extends AccountActions> T getAccountForm(String formName) {
        Class<?> tClass = PageFactory.getPageClass(formName);
        Object obj = createInstanceOfType(tClass);
        return (T) obj;
    }

    public static <T extends BaseForm> T getForm(String formName) {
        Class<?> tClass = PageFactory.getPageClass(formName);
        Object obj = createInstanceOfType(tClass);
        return (T) obj;
    }

    private static <T> T createInstanceOfType(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Unable to create instance of " + clazz, e);
        }
    }
}
