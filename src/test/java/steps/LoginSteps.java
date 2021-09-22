package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.base.AutomationBase;
import support.pages.LoginPage;
import support.utils.AppLauncher;

/**
 * @author Muhammad Tafseer Haider
 */
public class LoginSteps extends AutomationBase{

    AppLauncher applauncher = new AppLauncher(getDriver());
    LoginPage loginPage = new LoginPage(getDriver());


    @Given("I am at the login page of the Para Bank Application")
    public void navigateToParabankApplication()
    {
        applauncher.navigateToParaBankApplication();
    }

    @When("I enter valid credentials")
    public void typeValidCredentials()
    {
        loginPage.typeUsername("tautester");
        loginPage.typePassword("password");
        loginPage.submit();
    }

    @Then("I should be taken to the Overview page")
    public void verifyOverviewPage()
    {
        loginPage.validateOverviewPage();
    }

}
