package com.cybertek.tests.day4_findElements_checkboxes_radio;

/*TC #0: FINDELEMENTS1.Open Chrome browser
2.Go to https://www.merriam-webster.com/
3.Print out the texts of all links
4.Print out how many link is missing text
5.Print out how many link has text
6.Print out how many total link*/


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MerriamWebster_links {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.merriam-webster.com/");
        driver.manage().window().maximize();

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        int linksWithoutText = 0;
        int linksWithText = 0;

        for (WebElement eachLink : listOfLinks){
            String textOfEachLink = eachLink.getText();

            System.out.println(textOfEachLink);

            if (textOfEachLink.isEmpty()){ //Condition to identify the empty links
                linksWithoutText++;
            }else{
                linksWithText++;
            }
        }

        System.out.println("linkWithoutText = " + linksWithoutText);
        System.out.println("linksWithText = " + linksWithText);
        System.out.println("Total Links in the page = " + listOfLinks.size());


    }

}
