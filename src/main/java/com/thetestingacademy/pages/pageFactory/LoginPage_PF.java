package com.thetestingacademy.pages.pageFactory;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class LoginPage_PF extends CommonToAllPage {

    WebDriver driver;

    public LoginPage_PF(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //Page Locators

    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(id="#js-notification-box-msg")
    private WebElement error_message;

    //page Actions
    public String loginToVWOInvalidCreds() throws FileNotFoundException {
        enterInput(username, PropertyReader.readkey("Invalid_username"));
        enterInput(password, PropertyReader.readkey("invalid_password"));
        clickElement(signButton);
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        return error_message.getText();
    }

}
