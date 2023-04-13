package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.example.pages.MainPage;
import org.example.utils.BrowserFactory;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static AppHooks.AppHook.prop;

public class LoginPageSteps {
    LoginPage loginPage = new LoginPage(BrowserFactory.getDriver());
    MainPage mainPage = new MainPage(BrowserFactory.getDriver());
    Faker faker = new Faker();

    @Given("User navigates login Page")
    public void user_navigates_login_page() {
        String baseUrl = prop.getProperty("baseUrl");
        loginPage.getURL(baseUrl);
    }

    @When("User types correct credentials")
    public void user_types_correct_credentials(DataTable correctCredentials) {
        List<Map<String, String>> correctCredentialsList = correctCredentials.asMaps();
        String email = correctCredentialsList.get(0).get("email");
        String psw = correctCredentialsList.get(0).get("password");
        loginPage.doLogin(email, psw);
    }

    @Then("User successfully logs in {string}")
    public void user_successfully_logs_in(String homeButtonTxt) {
        Assert.assertTrue(mainPage.getHomeButton(homeButtonTxt));
    }

    @Then("User navigates on the main page")
    public void user_navigates_on_the_main_page() {
        System.out.println(BrowserFactory.getDriver().getTitle());
    }

    @When("User types incorrect credentials")
    public void user_types_incorrect_credentials(DataTable incorrectCredentials) {
        List<Map<String, String>> incorrectCredentialsList = incorrectCredentials.asMaps();
        String email = incorrectCredentialsList.get(0).get("email");
        String psw = incorrectCredentialsList.get(0).get("password");
        loginPage.doLogin(email, psw);
    }

    @Then("Pop up error is showed up")
    public void pop_up_error_is_showed_up() {
        Assert.assertTrue(loginPage.isDisplayedErrorFrame());
    }

    @When("User clicks on the registration button")
    public void user_clicks_on_the_registration_button() {
        loginPage.clickRegistrationBtn();
    }

    @When("User types email for registration")
    public void user_types_email_for_registration() {
        String email = faker.internet().emailAddress();
        loginPage.sendRegistrationEmail(email);
    }

    @Then("Successful registration message should be {string}")
    public void successful_registration_message_should_be(String successfulMessage) {
        Assert.assertTrue(loginPage.successfulMessageIsDisplayed(successfulMessage));
    }
}
