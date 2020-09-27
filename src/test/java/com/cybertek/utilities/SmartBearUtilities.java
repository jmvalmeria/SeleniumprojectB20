package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {

    public static void loginToSmartBear(WebDriver driver){
        WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        usernameInput.sendKeys("Tester");
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();
    }

    /*@Param Method: verifyOrder
    • Create a method named verifyOrder in SmartBearUtils class.
    • Method takes WebDriver object and String(name).
    • Method should verify if given name exists in orders.
    • This method should simply accepts a name(String), and assert whether given name is in the list or not.
    • Create a new TestNG test to test if the method is working as expected.*/

    public static void verifyOrder(WebDriver driver, String name){
    /*PRACTICE #4: Method: verifyOrder
    •Create a method named verifyOrder in SmartBearUtils class.
    •Method takes WebDriver object and String(name).
    •Method should verify if given name exists in orders.
    •This method should simply accepts a name(String), and assert whether given name is in the list or not.
    •Create a new TestNG test to test if the method is working as expected.*/
        List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        for (WebElement each : nameList){
            if(each.getText().equals(name)){
                Assert.assertTrue(true);
                return;
            }
        }

        Assert.fail(""+name+" does not exist in orders list! Verification FAILED!!!");
    }

    public static void printNamesAndCities(WebDriver driver){
        //Practice #5: Method: printNamesAndCities
        //•Create a method named printNamesAndCitiesin SmartBearUtils class.
        //•Method takes WebDriver object.
        //•This method should simply print all the names in the List of All Orders.
        //•Create a new TestNG test to test if the method is working as expected.
        //•Output should be like:
        //•Name1: name , City1: city
        //•Name2: name , City2: city

        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[2]"));
        List<WebElement> citiesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[7]"));

        int index = 1;
        for (int i = 0; i < namesList.size(); i++){
            System.out.println("Name"+index+": "+namesList.get(i).getText()+" , City"+index+": "+citiesList.get(i).getText());
            index++;
        }
    }


}
