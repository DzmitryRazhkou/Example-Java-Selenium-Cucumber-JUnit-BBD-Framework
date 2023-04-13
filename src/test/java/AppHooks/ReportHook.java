package AppHooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.example.utils.BrowserFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ReportHook {
    @After(order = 1)
    public void afterScenario_Screenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replace(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) BrowserFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }
}
