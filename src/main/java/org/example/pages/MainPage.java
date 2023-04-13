package org.example.pages;

import org.example.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private static final By HOME_BTN = By.cssSelector(".home");

    public boolean getHomeButton(String txt){
        wait.until(ExpectedConditions.presenceOfElementLocated(HOME_BTN));
        String homeButtonTxt = driver.findElement(HOME_BTN).getText();
        System.out.println(" =====> "+homeButtonTxt+" <===== ");
        return driver.findElement(HOME_BTN).getText().equalsIgnoreCase(txt);
    }

}
