package com.cybertek.tests.day5_testNG_intro_dropdowns.Task;

/* TC#2: Selecting state from State dropdown and verifyingresult
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/dropdown
3.Select Illinois4.Select Virginia
5.Select California
6.Verify final selected option is California.
Use all Select options.(visible text, value, index)*/

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task2_Selecting_State {

    WebDriver driver;

    //TC#2: Selecting state from State dropdown and verifyingresult
    //1.Open Chrome browser

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2.Go to http://practice.cybertekschool.com/dropdown
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void dropDown_test1() throws InterruptedException {
        Select simpleDropDown = new Select(driver.findElement(By.id("state")));

        //3.Select Illinois
        Thread.sleep(2000);
        simpleDropDown.selectByVisibleText("Illinois");
        String actualSelectedOption1 = simpleDropDown.getFirstSelectedOption().getText();
        String expectedSelectedOption1 = "Illinois";

        Assert.assertEquals(actualSelectedOption1,expectedSelectedOption1, "Illinois is not selected");
        //4.Select Virginia
        Thread.sleep(2000);
        simpleDropDown.selectByVisibleText("Virginia");
        String actualSelectedOption2 = simpleDropDown.getFirstSelectedOption().getText();
        String expectedSelectedOption2 = "Virginia";

        Assert.assertEquals(actualSelectedOption2,expectedSelectedOption2, "Virginia is not selected");
        //5.Select California
        Thread.sleep(2000);
        simpleDropDown.selectByVisibleText("California");
        String actualSelectedOption3 = simpleDropDown.getFirstSelectedOption().getText();
        String expectedSelectedOption3 = "California";

        Assert.assertEquals(actualSelectedOption3,expectedSelectedOption3, "California is not selected");
        //6.Verify final selected option is California.
        if (actualSelectedOption3.equals(expectedSelectedOption3)){
            System.out.println("The final selected option is "+actualSelectedOption3+"\nFinal selection PASSED!");
        } else {
            System.out.println("The final selected option is "+actualSelectedOption3+"\nFinal selection FAILED!!!");
        }
        //Use all Select options.(visible text, value, index)*/
    }

    @Test
    public void dropDown_test2() throws InterruptedException {
        Select simpleDropDown = new Select(driver.findElement(By.cssSelector("select#state")));

        //3.Select Illinois
        Thread.sleep(2000);
        simpleDropDown.selectByValue("IL");
        String actualSelectedOption1 = simpleDropDown.getFirstSelectedOption().getText();
        String expectedSelectedOption1 = "Illinois";

        Assert.assertEquals(actualSelectedOption1,expectedSelectedOption1, "Illinois is not selected");
        //4.Select Virginia
        Thread.sleep(2000);
        simpleDropDown.selectByValue("VA");
        String actualSelectedOption2 = simpleDropDown.getFirstSelectedOption().getText();
        String expectedSelectedOption2 = "Virginia";

        Assert.assertEquals(actualSelectedOption2,expectedSelectedOption2, "Virginia is not selected");
        //5.Select California
        Thread.sleep(2000);
        simpleDropDown.selectByValue("CA");
        String actualSelectedOption3 = simpleDropDown.getFirstSelectedOption().getText();
        String expectedSelectedOption3 = "California";

        Assert.assertEquals(actualSelectedOption3,expectedSelectedOption3, "California is not selected");
        //6.Verify final selected option is California.
        if (actualSelectedOption3.equals(expectedSelectedOption3)){
            System.out.println("The final selected option is "+actualSelectedOption3+"\nFinal selection PASSED!");
        } else {
            System.out.println("The final selected option is "+actualSelectedOption3+"\nFinal selection FAILED!!!");
        }
        //Use all Select options.(visible text, value, index)*/
    }

    @Test
    public void dropDown_test3() throws InterruptedException {
        Select simpleDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3.Select Illinois
        Thread.sleep(2000);
        simpleDropDown.selectByIndex(14);
        String actualSelectedOption1 = simpleDropDown.getFirstSelectedOption().getText();
        String expectedSelectedOption1 = "Illinois";

        Assert.assertEquals(actualSelectedOption1,expectedSelectedOption1, "Illinois is not selected");
        //4.Select Virginia
        Thread.sleep(2000);
        simpleDropDown.selectByIndex(47);
        String actualSelectedOption2 = simpleDropDown.getFirstSelectedOption().getText();
        String expectedSelectedOption2 = "Virginia";

        Assert.assertEquals(actualSelectedOption2,expectedSelectedOption2, "Virginia is not selected");
        //5.Select California
        Thread.sleep(2000);
        simpleDropDown.selectByIndex(5);
        String actualSelectedOption3 = simpleDropDown.getFirstSelectedOption().getText();
        String expectedSelectedOption3 = "California";

        Assert.assertEquals(actualSelectedOption3,expectedSelectedOption3, "California is not selected");
        //6.Verify final selected option is California.
        if (actualSelectedOption3.equals(expectedSelectedOption3)){
            System.out.println("The final selected option is "+actualSelectedOption3+"\nFinal selection PASSED!");
        } else {
            System.out.println("The final selected option is "+actualSelectedOption3+"\nFinal selection FAILED!!!");
        }
        //Use all Select options.(visible text, value, index)*/
    }
}
