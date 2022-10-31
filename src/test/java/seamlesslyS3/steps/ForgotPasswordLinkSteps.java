package seamlesslyS3.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seamlesslyS3.pages.LoginPage;
import seamlesslyS3.pages.ResetPasswordPage;

public class ForgotPasswordLinkSteps {

    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
    LoginPage loginPage = new LoginPage();

    @When("Forgot password? Verify visibility.")
    public void forgotPasswordVerifyVisibility() {
        resetPasswordPage.isDisplayedForgotPasswordLinkText();
    }

    @And("User clicks on Forgot password? link text")
    public void userClicksOnForgotPasswordLinkText() {
        resetPasswordPage.clickForgotPasswordLinkText();
    }

    @When("Verify that user goes to the reset password page")
    public void verify_that_user_goes_to_the_reset_password_page() {
        resetPasswordPage.verifyResetPasswordPage();
    }

    @When("User clicks reset button")
    public void user_clicks_reset_button() {
        resetPasswordPage.clickResetPasswordBtn();
    }

    @When("Verify that user sees reset message")
    public void verify_that_user_sees_reset_message() {
        resetPasswordPage.isDisplayedResetMessage();
    }

    @And("User clicks Back to login link text")
    public void userClicksBackToLoginLinkText() {
        resetPasswordPage.clickBackToLoginTextLink();
    }

    @Then("Verify that user goes back to the login page")
    public void verify_that_user_goes_back_to_the_login_page() {
        loginPage.isDisplayedLoginPage();
    }
}
