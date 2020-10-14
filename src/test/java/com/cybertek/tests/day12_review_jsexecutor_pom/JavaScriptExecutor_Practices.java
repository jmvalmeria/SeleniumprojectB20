package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutor_Practices {

    @Test
    public void scroll_using_jexecutor_1(){
        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");

        //Create instance of JSExecutor and cast our driver type to it.
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

        //use execute script method
        BrowserUtils.wait(1);

        for (int i = 0; i < 10; i++) {
            BrowserUtils.wait(i);
            js.executeScript("window.scrollBy(0,500)");
        }


    }

    @Test
    public void scroll_using_jexecutor_2(){
        Driver.getDriver().get("http://practice.cybertekschool.com/large");

        //locating cyberteck school link
        WebElement link = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        WebElement homelink = Driver.getDriver().findElement(By.linkText("Home"));


        //Create instance of JSExecutor and cast our driver type to it.
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

        //use scrollIntoView function from JavaScript to scroll to a specific web element
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].scrollIntoView(true)", link);

        BrowserUtils.wait(2);
        js.executeScript("arguments[0].scrollIntoView(true)", homelink);


    }

}
