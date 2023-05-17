package cucumber.utilities;

import org.testng.asserts.SoftAssert;

public class SoftAssertUtil {
    private static ThreadLocal<SoftAssert> threadLocal = new ThreadLocal<>();

    public static SoftAssert getInstance() {
        if (threadLocal.get() == null) {
            threadLocal.set(new SoftAssert());
            return threadLocal.get();
        }
        return threadLocal.get();
    }
}
