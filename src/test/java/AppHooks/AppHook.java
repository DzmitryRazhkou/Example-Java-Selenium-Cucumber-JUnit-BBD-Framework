package AppHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.constants.Paths;
import org.example.utils.BrowserFactory;
import org.example.utils.ConfigReader;

import java.time.Duration;
import java.util.Properties;

public class AppHook {
    public static Properties prop;

    @Before(order = 0)
    public void beforeScenario() {
        readConfig();
        launchBrowser();
        openApp();
    }

    @After(order = 0)
    public void afterScenario() {
        BrowserFactory.getDriver().quit();
        BrowserFactory.removeDriver();
    }

    private static void launchBrowser() {
        BrowserFactory.Environment env = BrowserFactory.Environment.valueOf(prop.getProperty("ENVIRONMENT").trim().toUpperCase());
        BrowserFactory.Browser browser = BrowserFactory.Browser.valueOf(prop.getProperty("BROWSER").trim().toUpperCase());

        BrowserFactory.setDriver(env, browser, Boolean.parseBoolean(prop.getProperty("HEADLESS")));

        BrowserFactory.getDriver().manage().window().maximize();
        BrowserFactory.getDriver().manage().deleteAllCookies();
        BrowserFactory.getDriver().manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(Paths.PAGE_LOAD_TIMEOUT));
    }
    private static void readConfig(){
        prop = ConfigReader.initializeProperties();
        System.out.println(" =====> Read Properties Configuration File <===== ");
    }
    private static void openApp() {
        BrowserFactory.getDriver().get(prop.getProperty("baseUrl"));
    }
}
