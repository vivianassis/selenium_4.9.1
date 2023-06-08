package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Hooks;
import utils.TestData;


import static utils.TestData.*;

public class TestClass extends Hooks {
    //--------testData.properties--------//
    private static String getData(String key) {
        return TestData.getData(key);
    }

    @Test
    public void commomLogin() {
        loginPage.login(getData("commonUser"), getData("pass"), 10);
    }

    @Test
    public void blockedLogin() {
        loginPage.login(getData("blockedUser"), getData("pass"), 10);
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        Assertions.assertTrue(errorElement.isDisplayed());
        Assertions.assertEquals(getData("lockedErrorMessage"), errorElement.getText());
    }

    @Test
    public void whrongUserLogin() {
        loginPage.login(getData("wrongUser"), getData("pass"), 10);
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        Assertions.assertTrue(errorElement.isDisplayed());
        Assertions.assertEquals(getData("wrongUserErrorMessage"), errorElement.getText());
    }

    @Test
    public void whrongPassLogin() {
        loginPage.login(getData("commonUser"), getData("wrongPass"), 10);
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        Assertions.assertTrue(errorElement.isDisplayed());
        Assertions.assertEquals(getData("wrongPassErrorMessage"), errorElement.getText());
    }

    @Test
    public void emptyUser() {
        loginPage.login(getData("emptyUser"), getData("pass"), 10);
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        Assertions.assertTrue(errorElement.isDisplayed());
        Assertions.assertEquals(getData("emptyUserErrorMessage"), errorElement.getText());
    }

    @Test
    public void emptyPass() {
        loginPage.login(getData("commonUser"), getData("emptyPass"), 10);
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        Assertions.assertTrue(errorElement.isDisplayed());
        Assertions.assertEquals(getData("emptyPassErrorMessage"), errorElement.getText());
    }
}