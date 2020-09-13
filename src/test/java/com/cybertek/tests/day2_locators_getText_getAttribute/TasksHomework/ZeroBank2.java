package com.cybertek.tests.day2_locators_getText_getAttribute.TasksHomework;

/*TC #2: Zero Bank link text verification
1.Open Chrome browser
2.Go to http://zero.webappsecurity.com/login.html
3.Verify link text from top left:Expected: “Zero Bank”
4.Verify link href attribute value contains:Expected: “index.html”*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBank2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");

        String expectTopLink = "Zero Bank";
        String actualTopLink = driver.findElement(By.className("brand")).getText();

        String resultTop = (actualTopLink.equals(expectTopLink)) ? "Top Link Pass!" : "Top Link Failed!!!";
        System.out.println(resultTop);

        String expectTopUrl = "/index.html";
        String actualTopUrl = driver.findElement(By.className("brand")).getAttribute("href");

        String resultTopUrl = (actualTopUrl.contains(expectTopUrl)) ? "Top URL Link Pass!" : "Top URL Link Failed!!!";
        System.out.println(resultTopUrl);
    }


}
