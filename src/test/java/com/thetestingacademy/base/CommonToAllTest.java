package com.thetestingacademy.base;

import com.thetestingacademy.driver.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class CommonToAllTest {
    // To call the Start the Webdriver
    // Down the WebDriver
    // Start Webdirver start

    @BeforeTest
    public void setUp(){
        DriverManager.init();
        //DriverManagerSelenoid.init();
    }

    @AfterTest
    public void tearDown(){
        DriverManager.down();
        //DriverManagerSelenoid.down();
    }

}
