package com.cybertek.tests.day2_locators_getText_getAttribute.TasksHomework;
/*TC #1: Facebook title verification1.Open Chrome browser
2.Go to https://www.facebook.com
3.Verify title: Expected: “Facebook -Log In or Sign Up”
*/


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        String expectInResult = "Facebook - Entrar o registrarse";
        String actualResult = driver.getTitle();

        if (actualResult.contains(expectInResult)){
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }

    }
}
