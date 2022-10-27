package seamlesslyS3.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seamlesslyS3.pages.LoginPage;

public class LoginInvalidSteps {

    LoginPage loginPage = new LoginPage();

    @When("User clicks {string} {string}")
    public void user_clicks(String clickType,String messageText) {
        loginPage.userClicksBtn(clickType,messageText);
    }


    @Then("Verify that User sees {string}")
    public void verify_that_user_sees_wrong_username_or_password(String messageText) {
        loginPage.verifyErrorOrAlertMessage(messageText);
    }
}
