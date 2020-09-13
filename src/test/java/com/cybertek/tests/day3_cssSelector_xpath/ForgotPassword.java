package com.cybertek.tests.day3_cssSelector_xpath;

/*TC #3: PracticeCybertek/ForgotPassword URL verification
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/forgot_password
3.Enter any email into input box
4.Click on Retrieve password
5.Verify URL contains: Expected: “email_sent”
6.Verify textbox displayed the content as expected.Expected: “Your e-mail’s been sent!”*/

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

    public static void main(String[] args) {

       //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        //This is the way to call out method in the utility class
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.findElement(By.name("email")).sendKeys("jjjpppnn@gmail.com");
        driver.findElement(By.id("form_submit")).click();

        String expetURL = "email_sent";
        String actualURL = driver.getCurrentUrl();

        String resultURL = (actualURL.contains(expetURL)) ? "Url verification Pass!" : "Url verification Failed!!!";
        System.out.println(resultURL);

        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message")); //Other way to create a kind of variable call WebElement
        String expetTitle = "Your e-mail's been sent!";
        String actualTitle = confirmationMessage.getText();

        String resultTitle = (actualTitle.equals(expetTitle)) ? "Title Email verification Pass!" : "Title Email verification Failed!!!";
        System.out.println(resultTitle);


        //Verify if the web element is displayed or not


    }
}
