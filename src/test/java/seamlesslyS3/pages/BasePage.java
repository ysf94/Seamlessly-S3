package seamlesslyS3.pages;

import org.openqa.selenium.support.PageFactory;

import static seamlesslyS3.utility.Driver.driver;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(driver(),this);
    }
}
