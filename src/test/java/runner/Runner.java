package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.example.constants.Paths;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        features = {Paths.FEATURES},
//        tags = Paths.TAG,
        glue = {Paths.STEP_DEFINITIONS, Paths.HOOKS},
        monochrome = true,
        dryRun = false,
        plugin = {"pretty",
                "json:" + Paths.CUCUMBER_REPORTS + "report.json", // report json by default
                "junit:" + Paths.CUCUMBER_REPORTS + "report.xml", // report xml junit
                "html:" + Paths.CUCUMBER_REPORTS + "report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)

public class Runner {

}
