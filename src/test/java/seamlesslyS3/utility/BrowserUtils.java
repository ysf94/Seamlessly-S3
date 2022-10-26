package seamlesslyS3.utility;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static seamlesslyS3.utility.Driver.driver;

public class BrowserUtils {

    private BrowserUtils() {
    }

    public static boolean isImageDisplayed(WebDriver driver, WebElement imageElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        return (boolean) javascriptExecutor.executeScript("return arguments[0].complete "
                + "&& typeof arguments[0].naturalWidth != 'undefined'"
                + "&& arguments[0].naturalWidth > 0", imageElement);
    }

    /**
     * @param element The WebElement to be hovered over.
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(driver());
        actions.moveToElement(element).perform();
    }

    public static void executeJsCommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver();
        jse.executeScript(command, element);
    }

    public static void executeJsCommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver();
        jse.executeScript(command);

    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    public static void scrollToTop() {
        ((JavascriptExecutor) driver()).executeScript(
                "window.scrollTo({" +
                        "top : 0," +
                        "left: 0," +
                        "behavior : 'smooth'" +
                        "})");
    }


    public static void scrollToBottom() {
        ((JavascriptExecutor) driver()).executeScript(
                "window.scrollTo({" +
                        "top : document.body.scrollHeight," +
                        "left: 0," +
                        "behavior : 'smooth'" +
                        "})");
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver()).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'end', inline: 'nearest'});", element);
    }

    public static void clickWithJS(WebElement element) {
        //((JavascriptExecutor) driver()).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'end', inline: 'nearest'});", element);
        ((JavascriptExecutor) driver()).executeScript("arguments[0].click();", element);
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitFor(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param milliseconds are equal to seconds * 1000
     *                     for example : give 3000 for 3 seconds
     */
    public static void waitFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void sleep(double seconds){
        try {
            Thread.sleep(((long)seconds) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(driver(), 10);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver(), 10);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver(), 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickability(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickability(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public static void openNewTabAndSwitch() {
        Set<String> handlesBeforeNewTab = driver().getWindowHandles();
        String currentHandle = driver().getWindowHandle();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver();
        jsExecutor.executeScript("window.open(' ','_blank');");
        WebDriverWait wait = new WebDriverWait(driver(), 10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(handlesBeforeNewTab.size() + 1));
        Set<String> currentHandles = driver().getWindowHandles();
        for (String tab : currentHandles) {
            if (!handlesBeforeNewTab.contains(tab) && !tab.equals(currentHandle)) {
                driver().switchTo().window(tab);
                waitForPageToLoad(5);
                break;
            }
        }
    }


    public static void openNewTabAndSwitch(String url) {
        Set<String> handlesBeforeNewTab = driver().getWindowHandles();
        String currentHandle = driver().getWindowHandle();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver();
        jsExecutor.executeScript("window.open(' ','_blank');");
        WebDriverWait wait = new WebDriverWait(driver(), 10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(handlesBeforeNewTab.size() + 1));
        Set<String> currentHandles = driver().getWindowHandles();
        for (String tab : currentHandles) {
            if (!handlesBeforeNewTab.contains(tab) && !tab.equals(currentHandle)) {
                driver().switchTo().window(tab);
                waitForPageToLoad(5);
                break;
            }
        }
        driver().get(url);
    }
    public static void goToUrl(String url){
        driver().get(url);
    }

    public static void refreshPage(){
        driver().navigate().refresh();
        waitForPageToLoad(20);
    }

    public static boolean isSameElementCss(WebElement origin, String cssSelector) {
        return (boolean) ((JavascriptExecutor) driver()).executeScript("return arguments[0].matches(arguments[1])", origin, cssSelector);
    }

    public static boolean isSameElementCss(String css1, String css2) {
        return (boolean) ((JavascriptExecutor) driver()).executeScript("return document.querySelector(arguments[0]).matches(arguments[1])", css1, css2);
    }

    public static boolean isSameElementXpathCss(String xpath, String css) {
        return (boolean) ((JavascriptExecutor) driver()).executeScript("return document.evaluate(arguments[0], document, null, XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.matches(arguments[1])", xpath, css);
    }
}
