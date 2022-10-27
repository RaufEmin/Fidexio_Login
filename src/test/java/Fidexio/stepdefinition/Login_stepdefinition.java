package Fidexio.stepdefinition;

import Fidexio.pages.LoginPage;
import Fidexio.utilities.ConfigurationReader;
import Fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Login_stepdefinition {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user enters valid username {string}")
    public void user_enters_valid_username (String userName) {
        loginPage.username.sendKeys(userName);

    }
    @When("user enters valid password {string}")
    public void user_enters_valid_password(String passWord) {
        loginPage.password.sendKeys(passWord);

    }
    @When("user click on the login button")
    public void userClickOnTheLoginButton() {
        loginPage.Loginbutton.click();
    }
   
    @When("user can see their {string}")
    public void user_can_see_their(String userID) {
        Assert.assertTrue("not match",loginPage.userId.getText().equals(userID));

    }
    @When("Posmanager enters valid username and invalid password")
    public void posmanager_enters_valid_username_and_invalid_password() {
        loginPage.username.sendKeys(ConfigurationReader.getProperty("ValidusernamePost"));
        loginPage.password.sendKeys("hjhhjhj");
        loginPage.Loginbutton.click();
    }
    @Then("user wrong Login password message is displayed")
    public void user_wrong_login_password_message_is_displayed() {
       Assert.assertTrue(loginPage.WrongMessage.isDisplayed());
    }
    @When("SalesManager enters invalid username and valid password")
    public void sales_manager_enters_invalid_username_and_valid_password() {
        loginPage.username.sendKeys("hghg");
        loginPage.password.sendKeys("posmanager");
        loginPage.Loginbutton.click();
    }
    @When("user enter valid username")
    public void user_enter_valid_username() {
        loginPage.username.sendKeys(ConfigurationReader.getProperty("ValidusernamePost"));

    }
    @Then("Please fill out this field message is displayed")
    public void please_fill_out_this_field_message_is_displayed() {
          Assert.assertTrue(loginPage.fillAlert.isDisplayed());
    }
    @Then("user input valid password")
    public void user_input_valid_password() {
        loginPage.password.sendKeys(ConfigurationReader.getProperty("validPasswordPos"));

    }
    @Then("user sees password in bullet sign by default")
    public void user_sees_password_in_bullet_sign_by_default() {
        Assert.assertTrue(loginPage.bullet.isDisplayed());
    }


    @And("user enter valid password and user presses Enter Key on the  keyboard")
    public void userEnterValidPasswordAndUserPressesEnterKeyOnTheKeyboard() {
        loginPage.password.sendKeys("posmanager"+Keys.ENTER);
    }

    @Then("user  is on the home page")
    public void userIsOnTheHomePage() {
        Assert.assertTrue(loginPage.userId.isDisplayed());
    }
}
