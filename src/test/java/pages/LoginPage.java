package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitsSeleniumActions;

public class LoginPage extends WaitsSeleniumActions {
    WebDriver driver;

    //constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //elements
    public static final By userfield = By.id("user-name");
    public static final By passfield = By.id("password");
    public static final By btnLogin = By.id("login-button");


    //methods
    public void login(String user, String password, int wait){
        sendKeys(driver,userfield,user,wait);
        sendKeys(driver,passfield,password,wait);
        click(driver,btnLogin,wait);
    }
}
