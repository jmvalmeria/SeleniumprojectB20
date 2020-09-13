package com.cybertek.tests.day2_locators_getText_getAttribute.TasksHomework;

/*TC #4: Zero Bank login title verification
1.Open Chrome browser
2.Go to http://zero.webappsecurity.com/login.html
3.Enter username: username
4.Enter password: password
5.Click to “Account Activity” link
6.Verify title changed to:Expected: “Zero –Account Activity”
7.Click to “Transfer Funds” link
8.Verify title changed to:Expected: “Zero –Transfer Funds”
9.Click to “Pay Bills” link
10.Verify title changed to:Expected: “Zero -Pay Bills”
11.Click to “My Money Map” link
12.Verify title changed to:Expected: “Zero –My Money Map”
13.Click to “Online Statements” link
14.Verify title changed to:Expected: “Zero –Online Statements”*/


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBank4 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");

        //1.Log-in
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password" + Keys.ENTER);


        //2.Account Activity
        driver.findElement(By.linkText("Account Activity")).click();
        String expetTitle1 = "Zero - Account Activity";
        String actualTitle1 = driver.getTitle();

        String resultTitle1 = (actualTitle1.equals(expetTitle1)) ? "Title Account Activity Pass!" : "Title Account Activity Failed!!!";
        System.out.println(resultTitle1);

        //3.Transfer Funds
        driver.findElement(By.linkText("Transfer Funds")).click();
        String expetTitle2 = "Zero - Transfer Funds";
        String actualTitle2 = driver.getTitle();

        String resultTitle2 = (actualTitle2.equals(expetTitle2)) ? "Title Transfer Funds Pass!" : "Title Transfer Funds Failed!!!";
        System.out.println(resultTitle2);

        //4.Pay Bills
        driver.findElement(By.linkText("Pay Bills")).click();
        String expetTitle3 = "Zero - Pay Bills";
        String actualTitle3 = driver.getTitle();

        String resultTitle3 = (actualTitle3.equals(expetTitle3)) ? "Title Pay Bills Pass!" : "Title Pay Bills Failed!!!";
        System.out.println(resultTitle3);

        //5.My Money Map
        driver.findElement(By.linkText("My Money Map")).click();
        String expetTitle4 = "Zero - My Money Map";
        String actualTitle4 = driver.getTitle();

        String resultTitle4 = (actualTitle4.equals(expetTitle4)) ? "Title My Money Map Pass!" : "Title My Money Map Failed!!!";
        System.out.println(resultTitle4);

        //6.My Money Map
        driver.findElement(By.linkText("Online Statements")).click();
        String expetTitle5 = "Zero - Online Statements";
        String actualTitle5 = driver.getTitle();

        String resultTitle5 = (actualTitle5.equals(expetTitle5)) ? "Title Online Statements Pass!" : "Title Online Statements Failed!!!";
        System.out.println(resultTitle5);

        driver.close();



    }
}
