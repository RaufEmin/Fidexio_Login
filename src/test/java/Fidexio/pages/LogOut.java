package Fidexio.pages;

import Fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {
    public LogOut(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement userId2;


    @FindBy(xpath = "//a[@data-menu='logout']")
    public WebElement Logout;


    @FindBy(xpath = "//h4[@class='modal-title']")
     public  WebElement OddoMessage;


}
