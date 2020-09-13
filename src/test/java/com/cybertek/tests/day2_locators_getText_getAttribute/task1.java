package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class task1 {

    /*TC #1:	Google Title Verification
1.Open	Chrome	browser
2.Go to https://www.google.com
Verify title:
Expected:	Google*/

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup(); //Web-Driver
        WebDriver driver = new ChromeDriver(); //Instance
        driver.get("https://www.google.com"); // go to Google
        System.out.println(driver.getTitle()); //It gets the Title

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }

    }

}
