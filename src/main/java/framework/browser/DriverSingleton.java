package framework.browser;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

public class DriverSingleton {
    private static final DriverSingleton instance = new DriverSingleton();
    private WebDriver driver;

    private DriverSingleton() {
    }

    public static DriverSingleton getInstance() {
        return instance;
    }

    public WebDriver getDriver() {

        if (driver == null) {
            driver = WebDriverFactory.createDriver(DriverManagerType.CHROME);
        }
        return driver;
    }

    public void setDriverNull() {
        driver = null;
    }
}