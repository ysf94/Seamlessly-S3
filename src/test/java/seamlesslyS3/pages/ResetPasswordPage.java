package seamlesslyS3.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static seamlesslyS3.utility.BrowserUtils.*;

public class ResetPasswordPage extends BasePage{

    @FindBy(xpath = "//a[@id = 'lost-password']")
    protected WebElement forgotLinkText;

    @FindBy(xpath = "//div[@id = 'reset-password-wrapper']")
    protected WebElement resetPasswordBtn;


    @FindBy(xpath = "//a[normalize-space(text()) = 'Back to login']")
    protected WebElement backToLoginLinkText;

    @FindBy(xpath = "//div[@id='reset-password-wrapper']/following-sibling::p")
    protected WebElement warningMessage;


    public void isDisplayedForgotPasswordLinkText(){
        waitForPageToLoad(10);
        Assert.assertTrue(forgotLinkText.isDisplayed());
    }

    public void clickForgotPasswordLinkText(){
        waitForClickability(forgotLinkText,5).click();
    }

    public void verifyResetPasswordPage(){
        waitForPageToLoad(10);
        Assert.assertTrue(resetPasswordBtn.isDisplayed());
    }

    public void clickResetPasswordBtn(){
        waitForClickability(resetPasswordBtn,10).click();
    }

    public void isDisplayedResetMessage(){
        boolean resetMessage = waitForClickability(warningMessage,30).isDisplayed();
        Assert.assertTrue(resetMessage);
    }

    public void clickBackToLoginTextLink(){
        waitForClickability(backToLoginLinkText,10).click();
    }


}
