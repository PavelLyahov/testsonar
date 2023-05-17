package pages.core;

import framework.elements.BaseElement;

public abstract class BaseForm {
    private BaseElement element;
    private  String name;

    protected BaseForm(BaseElement element, String name) {
        this.element = element;
        this.name = name;
    }

    public boolean isFormOpen() {
        System.out.println("Open");
        return true;
    }
    public BaseForm waitForFormOpen() {
        System.out.println("Wait");
        return this;
    }
}
