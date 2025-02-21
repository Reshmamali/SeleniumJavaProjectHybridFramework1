package org.example.pages;

import org.example.base.CommonToAllPage;
import org.example.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VWOLoginPage extends CommonToAllPage {

    WebDriver driver;

    public VWOLoginPage(WebDriver driver) {
        this.driver = driver;
    }


    // Step 1 - Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");



    // Step 2 - page Actions
    public String logToVWOInvalidCred(String user, String pwd) {
        driver.get(PropertyReader.readKey("url"));
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(signButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String error_msg = driver.findElement(error_message).getText();
        return error_msg;
    }

    public void logToVWOValidCred(String user, String pwd) {
        driver.get(PropertyReader.readKey("url"));
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(signButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

