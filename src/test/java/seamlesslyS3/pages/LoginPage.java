package seamlesslyS3.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static seamlesslyS3.utility.Driver.driver;

public class LoginPage extends BasePage{
    public LoginPage(){
        PageFactory.initElements(driver(),this);
    }


    @FindBy(xpath = "//input[@id='user']")
    private WebElement inputUsername;


    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;


    @FindBy(xpath = "//input[@id='submit-form']")
    private WebElement loginBtn;

    @FindBy(xpath = "//a[@id='nextcloud']")
    private WebElement pageLogo;

    public void typeUsername(String username){
        inputUsername.sendKeys(username);
    }

    public void typePassword(String password){
        inputPassword.sendKeys(password);
    }

    public void userClicks(String clickType) {
        if(clickType.equalsIgnoreCase("ENTER")){
    loginBtn.sendKeys(Keys.ENTER);
        } else if (clickType.equalsIgnoreCase("LoginBtn")) {
            loginBtn.click();
        } else {
            loginBtn.click();
        }

    }

    public void verifyIsDisplayedPageLogo(){
        Assert.assertTrue(pageLogo.isDisplayed());
    }
}
