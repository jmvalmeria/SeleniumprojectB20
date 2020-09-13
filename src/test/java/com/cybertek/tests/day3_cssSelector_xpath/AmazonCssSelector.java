package com.cybertek.tests.day3_cssSelector_xpath;

/*TC #3: Amazon link number verification
1. Open Chrome browser
2. Go to https://www.amazon.com
3. Enter search term (use cssSelectorto locate search box)
4. Verify title contains search term*/

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonCssSelector {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");
        //WebElement searchBox = driver.findElement(By.cssSelector("input[name='field-keywords']"));
        WebElement searchBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        searchBox.sendKeys("wood spoon" + Keys.ENTER);

        String expetTitle = "wood spoon";
        String actualResult = driver.getTitle();

        if(actualResult.contains(expetTitle)){
            System.out.println("Title verification Pass!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }




    }

}
