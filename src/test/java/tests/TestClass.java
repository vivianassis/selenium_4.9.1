package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.DriveManager;


public class TestClass {
    WebDriver driver;
    //DriveManager driveManager;  //--> não instanciar classe de utility <--

    @BeforeEach
    public void inicio(){
        //driveManager = new DriveManager();  -- Chamar direto o método quando classe é de utility
        driver = DriveManager.openBrowser("chrome");
    }

    @Test
    public void test(){
        driver.get("https://www.google.com");
    }

    @AfterEach
    public void fim(){
        driver.quit();
    }
}
