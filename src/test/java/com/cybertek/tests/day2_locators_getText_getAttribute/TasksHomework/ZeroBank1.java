package com.cybertek.tests.day2_locators_getText_getAttribute.TasksHomework;

/*TC #1: Zero Bank title verification1.Open Chrome browser
2.Go to http://zero.webappsecurity.com/login.html
3.Verify titleExpected: “Zero -Log in”
*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBank1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");

        String expectInResult = "Zero - Log in";
        String actualResult = driver.getTitle();

        if (actualResult.contains(expectInResult)){
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }

    }

}
