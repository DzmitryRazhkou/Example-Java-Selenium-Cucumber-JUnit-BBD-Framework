package org.example.basePage;

import org.example.constants.Paths;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Paths.WEB_DRIVER_WAIT_TIMEOUT));
    }

    public void getURL(String url) {
        driver.get(url);
    }
}
