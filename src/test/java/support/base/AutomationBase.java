package support.base;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Muhammad Tafseer Haider
 */
public class AutomationBase {
    private static List<AutomationFactory> automationDriverPool = Collections.synchronizedList (new ArrayList<>());
    private static ThreadLocal<AutomationFactory> driverThread;

     public static void initiateAutomation() {
         driverThread = ThreadLocal.withInitial (() -> {
             AutomationFactory automationDriver = new AutomationFactory ();
             automationDriverPool.add (automationDriver);
             return automationDriver;
         });
    }

    public static WebDriver getDriver() {
        return driverThread.get ().getDriver ();
    }

   public static void closeAutomationDrivers() {
       for (AutomationFactory automationDriver : automationDriverPool)
       {
           automationDriver.quitDriver ();
       }
    }
}
