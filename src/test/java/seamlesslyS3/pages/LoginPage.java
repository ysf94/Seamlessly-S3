package seamlesslyS3.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static seamlesslyS3.utility.BrowserUtils.*;
import static seamlesslyS3.utility.Driver.driver;

public class LoginPage extends BasePage {
    public LoginPage() {
        PageFactory.initElements(driver(), this);
    }


    @FindBy(xpath = "//input[@id='user']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@id='submit-form']")
    private WebElement loginBtn;

    @FindBy(xpath = "//a[@id='nextcloud']")
    private WebElement pageLogo;

    @FindBy(xpath = "//p[normalize-space(text())='Wrong username or password.']")
    private WebElement errorMessageText;

    @FindBy(xpath = "//p[@class='warning throttledMsg']")
    private WebElement warningMessage;

    @FindBy(xpath = "//a[@Class='toggle-password']")
    private WebElement passwordVisibilityBtn;


    public void typeUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void typePassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void userClicksBtn(String clickType) {

        if (clickType.equalsIgnoreCase("ENTER")) {
            loginBtn.sendKeys(Keys.ENTER);
        } else if (clickType.equalsIgnoreCase("LoginBtn")) {
            loginBtn.click();
        } else {
            loginBtn.click();
        }
    }

    public void userClickBtn(String clickType, String messageText) {
        boolean isDisableWarningMessage = warningMessage.isDisplayed();
        if (clickType.equalsIgnoreCase("ENTER")) {
            loginBtn.sendKeys(Keys.ENTER);
        } else if (clickType.equalsIgnoreCase("LoginBtn")) {
            loginBtn.click();
        } else {
            loginBtn.click();
        }

        if (isDisableWarningMessage & messageText.contains("Wrong username or password")){
            sleep(2);
            driver().navigate().back();
        }
    }

    public void verifyIsDisplayedPageLogo() {
        Assert.assertTrue(pageLogo.isDisplayed());
    }

    public void verifyErrorOrAlertMessage(String messageText) {

        if (messageText.contains("Wrong username or password.")) {

                sleep(2);
                Assert.assertTrue(waitForVisibility(errorMessageText, 3).getText().contains(messageText));
            }
         else if (messageText.contains("Please fill out this field")) {
            if (waitForVisibility(inputUsername, 1).getAttribute("validationMessage").contains(messageText)) {
                Assert.assertTrue(inputUsername.getAttribute("validationMessage").contains(messageText));
            } else if (waitForVisibility(inputPassword, 1).getAttribute("validationMessage").contains(messageText)) {
                Assert.assertTrue(inputPassword.getAttribute("validationMessage").contains(messageText));
            }
        }
        sleep(3);
    }

    public void isPasswordViewDot(){
        String actualViewPassword = inputPassword.getAttribute("type");
        String expectedViewPasswordDot = "password";

        Assert.assertEquals(actualViewPassword,expectedViewPasswordDot);
    }

    public void isPasswordViewText(){
        String actualViewPassword = inputPassword.getAttribute("type");
        String expectedViewPasswordText = "text";

        Assert.assertEquals(actualViewPassword,expectedViewPasswordText);
    }

    public void clickPasswordVisibilityBtn(){
        sleep(2);
        waitForClickability(passwordVisibilityBtn,10).click();
        sleep(2);
    }

    public void verifyClickPasswordVisibilityBtn(){
        sleep(2);
        waitForClickability(passwordVisibilityBtn,10).click();
        sleep(2);

        String actualViewPassword = inputPassword.getAttribute("type");
        String expectedViewPasswordText = "text";

        if (actualViewPassword.equalsIgnoreCase(expectedViewPasswordText)) {
            Assert.assertEquals(actualViewPassword, expectedViewPasswordText);
        }else {
            Assert.assertFalse(actualViewPassword.contains(expectedViewPasswordText));
        }
        passwordVisibilityBtn.click();
    }

    public void isDisplayedLoginPage(){
       Assert.assertTrue(waitForClickability(inputUsername,10).isDisplayed());
       Assert.assertTrue(waitForClickability(inputPassword,10).isDisplayed());



    }

}

