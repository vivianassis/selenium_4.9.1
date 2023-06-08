package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class Hooks{
    public WebDriver driver;
    public LoginPage loginPage;
    //DriveManager driveManager;  //--> não instanciar classe de utility <--


    @BeforeEach
    public void setup(){
        //driveManager = new DriveManager();  -- Chamar direto o método quando classe é de utility
        driver = DriveManager.openBrowser("chrome");
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }
    @AfterEach
    public void close(){
        driver.quit();
    }
}

