package patterns.chainPlusFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PageFactory {

    public static <T> T getPage (Class<T> pageClass) {
        T page = instantiatePage(pageClass);
        return page;
    }

    private static <T> T instantiatePage(Class<T> pageClassToProxy) {
        try {
            try {
                Constructor<T> constructor = pageClassToProxy.getConstructor();
                return constructor.newInstance();
            } catch (NoSuchMethodException var3) {
                return pageClassToProxy.newInstance();
            }
        } catch (InstantiationException var4) {
            throw new RuntimeException(var4);
        } catch (IllegalAccessException var5) {
            throw new RuntimeException(var5);
        } catch (InvocationTargetException var6) {
            throw new RuntimeException(var6);
        }
    }

}
