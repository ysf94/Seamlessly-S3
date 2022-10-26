package seamlesslyS3.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seamlesslyS3.pages.LoginPage;

import static seamlesslyS3.utility.Driver.driver;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("User goes to Seamlessly login page")
    public void user_goes_to_seamlessly_login_page() {
        driver().get("https://qa.seamlessly.net/index.php/login");
    }
    @When("User types username as {string}")
    public void user_types_username_as(String username) {
        loginPage.typeUsername(username);
    }
    @When("User enters password as {string}")
    public void user_enters_password_as(String password) {
        loginPage.typePassword(password);
    }
    @When("User clicks {string}")
    public void user_clicks(String buttonType) {
        loginPage.userClicks(buttonType);
    }
    @Then("Verify that User lands on user dashboard")
    public void verify_that_user_lands_on_user_dashboard() {
        loginPage.verifyIsDisplayedPageLogo();
    }

}
