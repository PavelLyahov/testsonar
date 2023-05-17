package pages.core;

import framework.elements.BaseElement;

public abstract class BaseAccountForm extends BaseForm {

    protected BaseAccountForm(BaseElement element, String name) {
        super(element, name);
    }

    public abstract void selectStatus(String status);

}
