package pages.core;

import pages.MyAccountAuctionsForm;
import pages.MyAccountBidsForm;

import java.lang.reflect.InvocationTargetException;

public class FormProvider {
    private BaseForm form;

    public FormProvider(String formName) {
        try {
            form = getFormClass(formName).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public BaseForm getForm() {
        return this.form;
    }

    private  Class<? extends BaseForm> getFormClass(String formName) {
        switch (formName.toLowerCase()){
            case "bids":
                return MyAccountBidsForm.class;
            case "auctions":
                return MyAccountAuctionsForm.class;
            default:
                throw new IllegalArgumentException("Form name is not correct");
        }
    }
}
