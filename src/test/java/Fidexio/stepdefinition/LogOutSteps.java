package Fidexio.stepdefinition;

import Fidexio.pages.LogOut;
import Fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutSteps {

    LogOut logOut=new LogOut();

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        Assert.assertTrue(logOut.userId2.isDisplayed()); 
    }
    @When("user clicks on the username modul")
    public void user_clicks_on_the_username_modul() {
        logOut.userId2.click();
    }
    @Then("user click Log out options")
    public void user_click_log_out_options() {
       logOut.Logout.click();
    }
    @Then("user goes to the Login Page")
    public void user_goes_to_the_login_page() {
        String ExpectedUrl="https://qa.fidexio.com/web/login";
        //Driver.getDriver().getCurrentUrl().equals(ExpectedUrl);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ExpectedUrl));
    }

    @And("user click on the go back button")
    public void userClickOnTheGoBackButton() {
        Driver.getDriver().navigate().back();
    }

    @Then("user can not go to the homepage again")
    public void userCanNotGoToTheHomepageAgain() {
        String ExpectedUrl="https://qa.fidexio.com/web/login";

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ExpectedUrl));

    }
}
