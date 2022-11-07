package seamlesslyS3.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seamlesslyS3.pages.LogOutPage;
import seamlesslyS3.pages.LoginPage;

public class LogOutSteps {

    LogOutPage logOutPage = new LogOutPage();

    @Given("User goes to user homepage")
    public void userGoesToUserHomepage() {
        logOutPage.goToLoginUserHomepage();
    }

    @When("User clicks profile button")
    public void userClicksProfileButton() {
        logOutPage.clickProfilBtn();
    }

    @And("User sees Log out Button")
    public void userSeesLogOutButton() {
        logOutPage.isDisabledLogOutBtn();
    }

    @And("User clicks Log out button")
    public void userClicksLogOutButton() {
        logOutPage.clickLogOutBtn();
    }

    @Then("Verify that user is logged out of the user homepage")
    public void verifyThatUserIsLoggedOutOfTheUserHomepage() {
        new LoginPage().isDisplayedLoginPage();
    }


}
