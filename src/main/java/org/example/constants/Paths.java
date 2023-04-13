package org.example.constants;

public final class Paths {

    private Paths() throws Exception {
        throw new Exception();
    }

    private static final String CONFIG_MAIN = "src/test/resources/";
    private static final String CONFIG_PATH = "config/config.properties";

    public static final long PAGE_LOAD_TIMEOUT = 10;
    public static final long WEB_DRIVER_WAIT_TIMEOUT = 10;
    public static final String CONFIG = CONFIG_MAIN + CONFIG_PATH;

    public static final String TEST_RESOURCES = "src/test/resources/";
    public static final String FEATURES = TEST_RESOURCES + "features";
    public static final String HOOKS = "AppHooks";
    public static final String TAG = "@Smoke";
    public static final String CUCUMBER_REPORTS = "reports/cucumber-reports/";
    public static final String STEP_DEFINITIONS = "stepDefinitions";
}
