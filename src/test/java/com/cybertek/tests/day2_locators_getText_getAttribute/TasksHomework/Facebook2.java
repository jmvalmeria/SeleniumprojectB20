package com.cybertek.tests.day2_locators_getText_getAttribute.TasksHomework;

/*TC #2: Facebook incorrect login title verification
1.Open Chrome browser
2.Go to https://www.facebook.com
3.Enter incorrect username
4.Enter incorrect password
5.Verify title changed to: Expected: “Log into Facebook | Facebook”*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        driver.findElement(By.id("email")).sendKeys("jjjajaja@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123456" + Keys.ENTER);

        String expectInResult = "Log into Facebook | Facebook";
        String actualResult = driver.getTitle();

        if (actualResult.contains(expectInResult)){
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }

    }

}
