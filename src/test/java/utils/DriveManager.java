package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriveManager {
    static WebDriver driver;

    public static WebDriver openBrowser(String brownser) {
        if (brownser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (brownser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (brownser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        return driver;
    }
}
