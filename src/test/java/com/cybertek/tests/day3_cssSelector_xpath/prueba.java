package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class prueba {
    public static void main(String[] args) {

        WebDriver driver1 = WebDriverFactory.getDriver("chrome");
        driver1.get("http://www.google.com/");

        WebDriver driver2 = WebDriverFactory.getDriver("firefox");
        driver2.get("http://www.google.com/");

        WebDriver driver3 =WebDriverFactory.getDriver("edge");
        driver3.get("http://www.google.com/");
    }
}
