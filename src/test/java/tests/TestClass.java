package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Hooks;

public class TestClass extends Hooks {
    //--------data--------//
    String commonUser = "standard-user";
    String blockedUser = "locked_out_user";
    String wrongUser = "ABC";
    String emptyUser = "";
    String pass = "secret_sauce";
    String wrongPass = "123";
    String emptyPass = "";

    //-------ErrorMessages-------//
    String lockedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
    String wrongUserErrorMessage = "Epic sadface: Username and password do not match any user in this service";
    String wrongPassErrorMessage = "Epic sadface: Username and password do not match any user in this service";
    String emptyUserErrorMessage = "Epic sadface: Username is required";
    String emptyPassErrorMessage = "Epic sadface: Password is required";

    @Test
    public void commomLogin() {
        loginPage.login(commonUser, pass, 10);
    }

    @Test
    public void blockedLogin() {
        loginPage.login(blockedUser, pass, 10);
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        Assertions.assertTrue(errorElement.isDisplayed());
        Assertions.assertEquals(lockedErrorMessage, errorElement.getText());
    }

    @Test
    public void whrongUserLogin() {
        loginPage.login(wrongUser, pass, 10);
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        Assertions.assertTrue(errorElement.isDisplayed());
        Assertions.assertEquals(wrongUserErrorMessage, errorElement.getText());
    }

    @Test
    public void whrongPassLogin() {
        loginPage.login(commonUser, wrongPass, 10);
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        Assertions.assertTrue(errorElement.isDisplayed());
        Assertions.assertEquals(wrongPassErrorMessage, errorElement.getText());
    }

    @Test
    public void emptyUser() {
        loginPage.login(emptyUser, pass, 10);
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        Assertions.assertTrue(errorElement.isDisplayed());
        Assertions.assertEquals(emptyUserErrorMessage, errorElement.getText());
    }

    @Test
    public void emptyPass() {
        loginPage.login(commonUser, emptyPass, 10);
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        Assertions.assertTrue(errorElement.isDisplayed());
        Assertions.assertEquals(emptyPassErrorMessage, errorElement.getText());
    }
}