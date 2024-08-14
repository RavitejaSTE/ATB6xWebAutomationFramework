package com.thetestingacademy.tests;

import com.thetestingacademy.tests.qa.TestVWOLogin_PF_DM_QA;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLogin {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin.class);

    @Test
    public void testMethod() {

    WebDriver driver = new ChromeDriver();
        logger.info("Starting Test in Test Environment");
        driver.get("https://app.vwo.com");
        logger.info("Opening the URL");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");
        logger.info("Verifying the result");


        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("");

        WebElement passwordInputBox = driver.findElement(By.id("login-password"));
        passwordInputBox.sendKeys("");

        driver.findElement(By.id("js-login-btn")).click();

        try{
        Thread.sleep(3000);
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        String error_msg_text = error_msg.getText();
        String error_msg_attribute_dataqa = error_msg.getAttribute("data-qa");
        System.out.println(error_msg_attribute_dataqa);

        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");
        driver.quit();
        logger.info("Successfully Ran TestVWOLogin Test!!!");

    }
}