package seamlesslyS3.pages;

import static seamlesslyS3.utility.BrowserUtils.sleep;
import static seamlesslyS3.utility.Driver.driver;

public class LogOutBackPageBtnPage {
    public void clicksBackBtnOnLoginPage(){
        sleep(3);
        driver().navigate().back();
        sleep(3);
    }
}
