package com.thetestingacademy.tests;

import com.thetestingacademy.pages.pageFactory.pageObjectModel.LoginPage_POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLogin_POM {

    WebDriver driver = new ChromeDriver();
    LoginPage_POM loginPagePom;

    @Test
    public void testLoginNegativeVWO1(){
        driver.manage().window().maximize();
        loginPagePom = new LoginPage_POM(driver);
        String error_msg_text = loginPagePom.loginToVWOInvalidCreds("admin@gmail.com", "admin");
        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");
        driver.quit();
    }

    @Test
    public void testLoginNegativeVWO2(){
        driver.manage().window().maximize();
        loginPagePom = new LoginPage_POM(driver);
        String error_msg_txt = loginPagePom.loginToVWOInvalidCreds("ravitejabj@gmail.com", "ravi123");
        Assert.assertEquals(error_msg_txt, "Your email, password, IP address or location did not match");
        driver.quit();
    }

}
