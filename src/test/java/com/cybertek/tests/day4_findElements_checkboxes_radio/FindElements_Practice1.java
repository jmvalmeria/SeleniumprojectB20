package com.cybertek.tests.day4_findElements_checkboxes_radio;

/*TC #0: FINDELEMENTS1.Open Chrome browser2.
Go to http://practice.cybertekschool.com/forgot_password
3.Print out the texts of all links
4.Print out how many total link*/


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElements_Practice1 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        driver.findElements(By.xpath("//body//a")); //It returns all the links

        //Shortcut to introduce local variable is Alt + Enter
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a")); //It returns all the links and store in a Array List

        //We are looping through the list of webElements we just create above
        for (WebElement each : listOfLinks){
            //Getting the test of each element in each iteration and printing the values
            System.out.println(each.getText());
        }

        //Print out how many total links
        System.out.println("Number of links " + listOfLinks.size());



    }

}
