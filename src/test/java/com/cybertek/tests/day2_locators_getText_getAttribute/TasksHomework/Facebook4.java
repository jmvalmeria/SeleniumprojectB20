package com.cybertek.tests.day2_locators_getText_getAttribute.TasksHomework;

/*TC #4: Facebook header verification
1.Open Chrome browser
2.Go to https://www.facebook.com
3.Verify “Create a page” link href value contains text:
Expected: “registration_form”*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook4 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        //driver.findElement(By.id("u_0_2")).click();

        String expectInResult = "open-registration-form-button";
        String actualResult = driver.findElement(By.id("u_0_2")).getAttribute("data-testid");


        if (actualResult.contains(expectInResult)){
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }


    }
}
