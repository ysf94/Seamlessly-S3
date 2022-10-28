package seamlesslyS3.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;

import static seamlesslyS3.utility.BrowserUtils.waitFor;

public class Driver {

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    private Driver() {

    }

    public static WebDriver driver() {

        if (driverPool.get() == null || driverPool.get().toString().contains("null")) {

//           if we pass the driver from terminal then use that one
//           if we do not pass the driver from terminal then use the one in properties file
            String browser = System.getProperty("browser") != null ? System.getProperty("browser").toLowerCase() : ConfigurationReader.get("browser").toLowerCase();

            switch (browser) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--incognito");
                    WebDriver chromeDriver = new ChromeDriver(options);
                    driverPool.set(chromeDriver);
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
                case"remote-chrome":
                    try {
                        //assign your grid server address
                        String gridAddress = "3.208.8.137";
                        URL url = new URL("http://"+gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driverPool.set(new SafariDriver());
                    break;
            }

        }
        return driverPool.get();
    }

    public static void quitDriver(double seconds) {
        if (driverPool.get() != null && !driverPool.get().toString().contains("null")) {
            waitFor(seconds);
            driverPool.get().quit();
            driverPool.remove();
        }
    }
    public static void quitDriver() {
        if (driverPool.get() != null && !driverPool.get().toString().contains("null")) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }

    public static void closeDriver(double seconds) {
        if (driverPool.get() != null && !driverPool.get().toString().contains("null")) {
            waitFor(seconds);
            driverPool.get().close();
            driverPool.remove();
        }
    }
}
