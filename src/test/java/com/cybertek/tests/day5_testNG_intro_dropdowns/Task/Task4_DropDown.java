package com.cybertek.tests.day5_testNG_intro_dropdowns.Task;

/*TC#4: Selecting value from multiple select dropdown
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/dropdown
3.Select all the options from multiple select dropdown.
4.Print out all selected values.
5.Deselect all values.*/

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task4_DropDown {

    WebDriver driver;

    @BeforeMethod
    public void setUpBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void selectMultipleDropDown() throws InterruptedException {
        Select selectPLanguage = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        //3.Select all the options from multiple select dropdown.
        for (int i = 0; i < 6; i++){
            selectPLanguage.selectByIndex(i);
            Thread.sleep(1000);
        }

        //4.Print out all selected values.
        List<WebElement> progLanguage = selectPLanguage.getAllSelectedOptions();

        for(WebElement each : progLanguage){
            System.out.println(each.getText());
        }

        //5.Deselect all values.
        selectPLanguage.deselectAll();

    }
}
