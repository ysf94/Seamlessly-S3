package seamlesslyS3.steps;

import io.cucumber.java.en.When;
import seamlesslyS3.pages.LoginPage;

public class PasswordVisibilitySteps {

    LoginPage loginPage = new LoginPage();

    @When("Verify that the default visibility of the password input box is dot")
    public void Verify_that_the_default_visibility_of_the_password_input_box_is_dot() {
        loginPage.isPasswordViewDot();
    }

    @When("User clicks password visibility button")
    public void user_clicks_password_visibility_button() {
        loginPage.clickPasswordVisibilityBtn();
    }



}
