package support.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static support.base.DriverOptions.CHROME;


/**
 * @author Muhammad Tafseer Haider
 */
public class AutomationFactory {
    protected WebDriver driver;

    private DriverOptions selectedDriverOption;
    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");

    public AutomationFactory() {
        DriverOptions driverOption = CHROME;
        String browser = System.getProperty("browserType", driverOption.toString().toUpperCase());
        try {
            driverOption = DriverOptions.valueOf(browser.toUpperCase());
        } catch (IllegalArgumentException ignored) {
            System.err.println("Unknown driver specified, defaulting to '" + driverOption + "'...");
        } catch (NullPointerException ignored) {
            System.err.println("No driver specified, defaulting to '" + driverOption + "'...");
        }
        selectedDriverOption = driverOption;
    }

    public WebDriver instantiateDriver(DriverOptions driverOption) {
        System.out.println(" ");
        System.out.println("Current Operating System: " + operatingSystem);
        System.out.println("Current Architecture: " + systemArchitecture);
        System.out.println("Browser Selected: " + selectedDriverOption);
        System.out.println(" ");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        driver = driverOption.getWebDriverObject(desiredCapabilities);

        return driver;
    }

    public WebDriver getDriver() {
        if (null == driver) {
            instantiateDriver(selectedDriverOption);
        }

        return driver;
    }

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
}
