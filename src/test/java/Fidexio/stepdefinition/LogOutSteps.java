package Fidexio.stepdefinition;

import Fidexio.pages.LogOut;
import Fidexio.pages.LoginPage;
import Fidexio.utilities.ConfigurationReader;
import Fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LogOutSteps {

    LogOut logOut=new LogOut();
    LoginPage loginPage=new LoginPage();

    @Given("user is on the homepage after login with valid credentials.")
    public void user_is_on_the_homepage() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.username.sendKeys("posmanager10@info.com");
        Thread.sleep(1000);
        loginPage.password.sendKeys("posmanager"+ Keys.ENTER);
    }
    @When("user clicks on the username modul")
    public void user_clicks_on_the_username_modul() throws InterruptedException {

        WebElement dropdown=Driver.getDriver().findElement(By.xpath("//span[@class='oe_topbar_name']"));
        //Select select=new Select(dropdown);
       //select.selectByVisibleText("Log out");
       logOut.userId2.click();
    }
    @Then("user click Log out options")
    public void user_click_log_out_options() {
       logOut.Logout.click();
    }
    @Then("user goes to the Login Page")
    public void user_goes_to_the_login_page() throws InterruptedException {
        String ExpectedUrl="https://qa.fidexio.com/web/login";
        //Driver.getDriver().getCurrentUrl().equals(ExpectedUrl);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ExpectedUrl));

       Thread.sleep(1000);
    }

    @And("user click on the go back button")
    public void userClickOnTheGoBackButton() {
        Driver.getDriver().navigate().back();
    }

    @Then("user can not go to the homepage again")
    public void userCanNotGoToTheHomepageAgain() {
      // String ExpectedUrl="https://qa.fidexio.com/web/login";

        //Assert.assertTrue(Driver.getDriver().getCurrentUrl().equalsIgnoreCase(ExpectedUrl));


       // String expectedMessage = "Odoo Session Expired";
        String actualMessage=Driver.getDriver().getTitle();
        String expectedMesage="Odoo Session Expired";
        if (actualMessage == expectedMesage){
            System.out.println("Test pass");
        }else {
            System.out.println("Test No Pass");
        }

    }
}
