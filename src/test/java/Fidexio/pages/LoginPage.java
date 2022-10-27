package Fidexio.pages;

import Fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement Loginbutton;

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement userId;

    @FindBy(xpath ="//p[@class='alert alert-danger']")
        public WebElement WrongMessage;

    @FindBy(xpath = "//input[contains(@required,'required')]")
    public WebElement  fillAlert;

    @FindBy(xpath = "//input[contains(@required,'required')]")
    public WebElement  bullet;


}
