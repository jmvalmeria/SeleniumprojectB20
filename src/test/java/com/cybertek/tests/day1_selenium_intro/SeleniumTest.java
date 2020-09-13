package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException{

        //1- set up the web driver
        WebDriverManager.chromedriver().setup();

        //2- create the instance of the chrome driver
        WebDriver driver = new ChromeDriver(); //This line open the browser
        driver.manage().window().maximize();

        //3- test if driver is working
        driver.get("https://www.google.com");

        System.out.println("The title of the page is: " + driver.getTitle());
        System.out.println("Actual URL: " + driver.getCurrentUrl());

        Thread.sleep(1000);
        driver.navigate().back();

        Thread.sleep(1000);
        driver.navigate().forward();

        Thread.sleep(1000);
        driver.navigate().refresh();

        driver.navigate().to("https://www.facebook.com");
        System.out.println(driver.getPageSource());

        driver.close(); //Close the last browser
        driver.quit(); //It is going to close all the browsers


    }

}
