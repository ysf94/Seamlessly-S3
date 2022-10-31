package seamlesslyS3.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seamlesslyS3.pages.LoginPage;

public class clearlyPasswordView {

    LoginPage loginPage = new LoginPage();


    @When("Verify that visibility of the password input box is now text")
    public void verify_that_visibility_of_the_password_input_box_is_now_text() {
        loginPage.isPasswordViewText();
    }
    @Then("Verify that visibility of the password input box is dots again")
    public void verify_that_visibility_of_the_password_input_box_is_dots_again() {
        loginPage.isPasswordViewDot();
    }

    @And("Verify that user clicks password visibility button")
    public void verifyThatUserClicksPasswordVisibilityButton() {
        loginPage.verifyClickPasswordVisibilityBtn();
    }
}
