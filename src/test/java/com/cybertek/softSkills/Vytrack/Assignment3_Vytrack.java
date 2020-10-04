package com.cybertek.softSkills.Vytrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/*User Story: As a truck driver I should be able to access Vehicle under Fleet module
* AC#5 (Given) Truck Driver
*      (When) type the right username and right password and hit the Log in button,
*       (Then) user should to land on Quick Launchpad page.
*/

public class Assignment3_Vytrack {

    public static void main(String[] args) {

        //1- set up the web driver
        WebDriverManager.chromedriver().setup();

        //2- create the instance of the chrome driver
        WebDriver driver = new ChromeDriver(); //This line open the browser
        driver.manage().window().maximize();

        //3- test if driver is working
        driver.get("https://qa2.vytrack.com/user/login");

        //4- It finds Username box and add user
        driver.findElement(By.id("prependedInput")).sendKeys("user174");

        //5- It finds Password box, add password and hit enter
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);

        //6- Variables
        String expectedInTitle = "Quick Launchpad";
        String actualTitle = driver.findElement(By.className("oro-subtitle")).getText();

        //7- Condition for the test
        if (actualTitle.contains(expectedInTitle)){
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }

    }
}
