package com.cybertek.tests.day4_findElements_checkboxes_radio.taskXpathCssSelector;

/*TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH and/orCSS Selector LOCATOR FOR ALL WEBELEMENT LOCATORS*/


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddRemoveElements {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        //cssSelector
        WebElement buttonAdd = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        buttonAdd.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) { }

        WebElement buttonDelete = driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
        String expectButtonDelete = "Delete";
        String actualButtonDelete = buttonDelete.getText();
        String resultButtonDelete = (actualButtonDelete.equals(expectButtonDelete)) ? "The Button Delete verification PASS!" : "The Button Delete verification FAILED!!!";
        System.out.println(resultButtonDelete);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) { }

        buttonDelete.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) { }


        if (buttonDelete.isDisplayed()){ //Returns if element is Display in the page
            System.out.println("The Button Delete is display, verification FAILS!!!");
        } else {
            System.out.println("The Button Delete is NOT display, verification PASS!");
        }


    }

}
