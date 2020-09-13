package com.cybertek.tests.day2_locators_getText_getAttribute.TasksHomework;

/*TC #3: Facebook header verification
1.Open Chrome browser
2.Go to https://www.facebook.com
3.Verify header text is as expected:
Expected: “Connect with friends and the world around you on Facebook.”
*/


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook3 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        String expectInResult = "Connect with friends and the world around you on Facebook.";
        String actualResult = driver.findElement(By.className("_8eso")).getText();

        if (actualResult.contains(expectInResult)){
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }



    }
}
