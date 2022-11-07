package seamlesslyS3.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static seamlesslyS3.utility.BrowserUtils.waitForClickability;
import static seamlesslyS3.utility.BrowserUtils.waitForPageToLoad;
import static seamlesslyS3.utility.Driver.driver;

public class LogOutPage extends BasePage{
    public LogOutPage(){
        PageFactory.initElements(driver(),this);
    }

    @FindBy(xpath = "//input[@id='user']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@id='submit-form']")
    private WebElement loginBtn;

    @FindBy(xpath = "//li[@data-id='logout']/a")
    private WebElement logOutBtn;

    @FindBy(xpath = "//div[@id='expand']")
    private WebElement profileBtn;

    public void goToLoginUserHomepage(){
        inputUsername.sendKeys("Employee41");
        inputPassword.sendKeys("Employee123");
        waitForClickability(loginBtn,10).click();
    }

    public void clickProfilBtn(){
        waitForClickability(profileBtn,10).click();
    }

    public void isDisabledLogOutBtn(){
        Assert.assertTrue(waitForClickability(logOutBtn,10).isDisplayed());
    }

    public void clickLogOutBtn(){
        waitForClickability(logOutBtn,5).click();
        waitForPageToLoad(10);
    }

    public void verifyLogOutUserHomepage(){

    }
}
