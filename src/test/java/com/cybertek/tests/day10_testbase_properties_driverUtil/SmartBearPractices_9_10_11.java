package com.cybertek.tests.day10_testbase_properties_driverUtil;

import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.SmartBearUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class SmartBearPractices_9_10_11 extends TestBase {

    /*
    TC #9: SmartBear delete order
    1. Open browser and login to SmartBear
    2. Delete “Mark Smith” from the list
    3. Assert it is deleted from the list
     */
    @Test
    public void p9_delete_order_task() throws IOException {
        //Creating properties object to be able to read properties file
        Properties properties = new Properties();
        //Opening the file in JVM memory using FileInputStream
        FileInputStream file = new FileInputStream("configuration.properties");
        //Loading the file into properties object
        properties.load(file);
        String url = properties.getProperty("smartbearUrl"); //--> It returns to us a URL from Configuration Properties

        driver.get(url);
        SmartBearUtilities.loginToSmartBear(driver);
        WebElement markSmitCheckBox = driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]"));
        markSmitCheckBox.click();

        BrowserUtils.wait(1);
        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteButton.click();

        //SmartBearUtilities.verifyOrder(driver,"Mark Smith"); //It had been create in th SmartBearUtilities

        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        for (WebElement each : namesList) {
            Assert.assertFalse(each.getText().equals("Mark Smith"));
        }

    }

}
