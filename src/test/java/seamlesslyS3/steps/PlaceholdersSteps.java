package seamlesslyS3.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seamlesslyS3.pages.LoginPage;

import static seamlesslyS3.utility.BrowserUtils.sleep;

public class PlaceholdersSteps {

    LoginPage loginPage = new LoginPage();

    @When("User clears in username box")
    public void userClearsInUsernameBox() {
        loginPage.clearUsernameBoxPlaceholder();
    }
    @When("Verify that username box is empty")
    public void verify_that_username_box_is_empty() {
        loginPage.isEmptyUsernameBox();
    }
    @When("Verify that see placeholder on username box")
    public void verify_that_see_placeholder_on_username_box() {
        loginPage.verifyUsernamePlaceholder();
    }
    @When("User clears in password box")
    public void userClearsInPasswordBox() {
        loginPage.clearPasswordBoxPlaceholder();
    }
    @When("Verify that password box is empty")
    public void verify_that_password_box_is_empty() {
        sleep(5);
        loginPage.isEmptyPasswordBox();
    }
    @Then("Verify that see placeholder on password box")
    public void verify_that_see_placeholder_on_password_box() {
        loginPage.verifyPasswordPlaceholder();
    }


}
