package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import support.base.AutomationBase;


/**
 * @author Muhammad Tafseer Haider
 */
public class WebHooks extends AutomationBase {

    @Before
    public void beforeScenario() {
        initiateAutomation();
    }

    @After
    public void afterScenario() {
        closeAutomationDrivers();
    }
}
