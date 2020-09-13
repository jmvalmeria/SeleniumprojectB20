package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class task2 {

    /*TC #2: Cybertek verifications
1. Open Chrome browser
2. Go to https://practice.cybertekschool.com
3. Verify URL contains
	Expected: cybertekschool
4. Verify title:
	Expected: Practice*/

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        String expectedInUrl = "cybertekschool";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedInUrl)){
            System.out.println("URL verification PASSED!");
        } else {
            System.out.println("URL verification FAILED!!!");
        }

        if(driver.getTitle().equals("Practice")){
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }


    }

}
