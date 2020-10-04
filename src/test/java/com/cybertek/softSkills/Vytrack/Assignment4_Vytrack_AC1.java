package com.cybertek.softSkills.Vytrack;

/*AC#1 (Jesús)
(Given) Truck Driver logged in successfully.
(When) hover mouse pointer over module Fleet and click on Vehicles Odometers in the drop down menu,
(Then) all the Vehicle information should be displayed on a page called Vehicles Odometer.
*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4_Vytrack_AC1 {

    public static void main(String[] args) {

        //Set the driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Login
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user174");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);

        //Drop Down Menu
        driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]")).click();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            //e.printStackTrace();
        }

        //Click on Vehicle Odometer
        driver.findElement(By.linkText("Vehicle Odometer")).click();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            //e.printStackTrace();
        }

        //Verification part
        WebElement title = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        String expectTitle = "Vehicles Odometers";
        String actualTitle = title.getText();
        String resultTitle = (actualTitle.equals(expectTitle)) ? "The title of the page verification PASS!" : "The title of the page verification FAILED!!!";
        System.out.println(resultTitle);

    }

}
