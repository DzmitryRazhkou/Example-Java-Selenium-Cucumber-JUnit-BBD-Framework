package org.example.pages;

import org.example.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By EMAIL_FIELD = By.cssSelector("input[type='email']");
    private static final By PSW_FIELD = By.cssSelector("input[type='password']");
    private static final By LOGIN_BTN = By.cssSelector("button");
    private static final By ERROR_FRAME = By.cssSelector(".error");
    private static final By REGISTRATION_BTN = By.cssSelector("#hel");
    private static final By EMAIL_FIELD_REGISTRATION_PAGE = By.cssSelector("#email");
    private static final By REGISTER_BTN = By.cssSelector("#button");
    private static final By REGISTRATION_SUCCESSFUL_MSG = By.cssSelector("h3");
    private static final By LOGOUT_BT = By.cssSelector("i[class='fa fa-sign-out']");

    private WebElement getEmail() {
        wait.until(ExpectedConditions.presenceOfElementLocated(EMAIL_FIELD));
        return driver.findElement(EMAIL_FIELD);
    }

    private WebElement getPsw() {
        wait.until(ExpectedConditions.presenceOfElementLocated(PSW_FIELD));
        return driver.findElement(PSW_FIELD);
    }

    private WebElement getLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN));
        return driver.findElement(LOGIN_BTN);
    }

    public void doLogin(String email, String psw) {
        getEmail().sendKeys(email);
        getPsw().sendKeys(psw);
        getLoginButton().click();
    }

    private WebElement getErrorFrame() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ERROR_FRAME));
        return driver.findElement(ERROR_FRAME);
    }

    public boolean isDisplayedErrorFrame() {
        try {
            System.out.println(" =====> The Error Frame is Displayed <===== ");
            return getErrorFrame().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" =====> Provide Another Locator <===== ");
            return false;
        }
    }

    private WebElement getRegistrationBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(REGISTRATION_BTN));
        return driver.findElement(REGISTRATION_BTN);
    }

    private WebElement getEmailRegistrationField() {
        wait.until(ExpectedConditions.elementToBeClickable(EMAIL_FIELD_REGISTRATION_PAGE));
        return driver.findElement(EMAIL_FIELD_REGISTRATION_PAGE);
    }

    private WebElement getRegistrationSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(REGISTER_BTN));
        return driver.findElement(REGISTER_BTN);
    }

    private WebElement getSuccessfulMsg() {
        wait.until(ExpectedConditions.elementToBeClickable(REGISTRATION_SUCCESSFUL_MSG));
        return driver.findElement(REGISTRATION_SUCCESSFUL_MSG);
    }

    public void clickRegistrationBtn() {
        getRegistrationBtn().click();
    }

    public void sendRegistrationEmail(String email) {
        getEmailRegistrationField().sendKeys(email);
        getRegistrationSubmit().click();
    }

    public boolean successfulMessageIsDisplayed(String msg) {
        try {
            System.out.println(" =====> " + getSuccessfulMsg() + " <===== ");
            return getSuccessfulMsg().isDisplayed() && getSuccessfulMsg().getText().equalsIgnoreCase(msg);
        } catch (TimeoutException y) {
            System.out.println(" =====> Provide Another Locator <===== ");
            return false;
        }
    }
}
