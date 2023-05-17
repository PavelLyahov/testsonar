package framework.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver createDriver(DriverManagerType driverType) {

        switch (driverType) {
            case CHROME: {
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                return new ChromeDriver(chromeOptions);
            }
        default: throw new IllegalArgumentException(
                    "The specified type of browser is not supported.");
        }

    }
}