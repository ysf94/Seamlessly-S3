package seamlesslyS3.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seamlesslyS3.pages.LogOutBackPageBtnPage;
import seamlesslyS3.pages.LoginPage;

public class LogOutBackPageBtnSteps {

    @When("User clicks to back button")
    public void user_clicks_to_back_button() {
        new LogOutBackPageBtnPage().clicksBackBtnOnLoginPage();
    }
    @Then("Verify that you are on the login page")
    public void verify_that_you_are_on_the_login_page() {
        new LoginPage().isDisplayedLoginPage();
    }

}
