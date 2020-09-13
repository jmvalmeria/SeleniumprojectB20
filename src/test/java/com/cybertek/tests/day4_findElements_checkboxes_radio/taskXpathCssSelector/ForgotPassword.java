package com.cybertek.tests.day4_findElements_checkboxes_radio.taskXpathCssSelector;

/*TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cybertek School” text
4. Verify all WebElements are displayed. */


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //cssSelector
        System.out.println("This are the cssSelector elements:");
        System.out.println("=================================================");

        WebElement aHome = driver.findElement(By.cssSelector("a[class='nav-link']"));
        String expectAHome = "Home";
        String actualAHome = aHome.getText();
        String resultAHome = (actualAHome.equals(expectAHome)) ? "The home link verification PASS!" : "The home link verification FAILED!!!";
        System.out.println(resultAHome);


        WebElement forgotH2 = driver.findElement(By.tagName("h2"));
        String expectForgotH2 = "Forgot Password";
        String actualForgotH2 = forgotH2.getText();
        String resultForgotH2 = (actualForgotH2.equals(expectForgotH2)) ? "The header of the page verification PASS!" : "The header of the page verification FAILED!!!";
        System.out.println(resultForgotH2);


        WebElement emailLabel = driver.findElement(By.cssSelector("label[for='email']"));
        String expectEmailLabel = "E-mail";
        String actualEmailLabel = emailLabel.getText();
        String resultEmailLabel = (actualEmailLabel.equals(expectEmailLabel)) ? "The E-mail text verification PASS!" : "The E-mail text verification FAILED!!!";
        System.out.println(resultEmailLabel);

        WebElement inputBox = driver.findElement(By.cssSelector("input[name='email']"));
        String expectInputBox = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$";
        String actualInputBox = inputBox.getAttribute("pattern");
        String resultInputBox = (actualInputBox.equals(expectInputBox)) ? "The Box E-mail verification PASS!" : "The E-mail text verification FAILED!!!";
        System.out.println(resultInputBox);


        WebElement footer = driver.findElement(By.cssSelector("div[class='large-4 large-centered columns']"));
        String expectFooter = "Powered by Cybertek School";
        String actualFooter = footer.getText();
        String resultFooter = (actualFooter.equals(expectFooter)) ? "The Footer text verification PASS!" : "The Footer text verification FAILED!!!";
        System.out.println(resultFooter);

        System.out.println("=================================================");
        System.out.println();

        //XPATH
        System.out.println("This are the XPATH elements:");
        System.out.println("=================================================");

        WebElement aHomeXpath = driver.findElement(By.xpath("//a[@class='nav-link']"));
        String expectAHomeXpath = "Home";
        String actualAHomeXpath = aHomeXpath.getText();
        String resultAHomeXpath = (actualAHomeXpath.equals(expectAHomeXpath)) ? "The home link verification PASS!" : "The home link verification FAILED!!!";
        System.out.println(resultAHomeXpath);


        WebElement forgotH2Xpath = driver.findElement(By.xpath("//div[@id='content']/div/h2"));
        String expectForgotH2Xpath = "Forgot Password";
        String actualForgotH2Xpath = forgotH2Xpath.getText();
        String resultForgotH2Xpath = (actualForgotH2Xpath.equals(expectForgotH2Xpath)) ? "The header of the page verification PASS!" : "The header of the page verification FAILED!!!";
        System.out.println(resultForgotH2Xpath);


        WebElement emailLabelXpath = driver.findElement(By.xpath("//label[@for='email']"));
        String expectEmailLabelXpath = "E-mail";
        String actualEmailLabelXpath = emailLabelXpath.getText();
        String resultEmailLabelXpath = (actualEmailLabelXpath.equals(expectEmailLabelXpath)) ? "The E-mail text verification PASS!" : "The E-mail text verification FAILED!!!";
        System.out.println(resultEmailLabelXpath);

        WebElement inputBoxXpath = driver.findElement(By.xpath("//input[@name='email']"));
        String expectInputBoxXpath = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$";
        String actualInputBoxXpath = inputBoxXpath.getAttribute("pattern");
        String resultInputBoxXpath = (actualInputBoxXpath.equals(expectInputBoxXpath)) ? "The Box E-mail verification PASS!" : "The E-mail text verification FAILED!!!";
        System.out.println(resultInputBoxXpath);

        WebElement footerXpath = driver.findElement(By.xpath("//div[@class='large-4 large-centered columns']"));
        String expectFooterXpath = "Powered by Cybertek School";
        String actualFooterXpath = footerXpath.getText();
        String resultFooterXpath = (actualFooterXpath.equals(expectFooterXpath)) ? "The Footer text verification PASS!" : "The Footer text verification FAILED!!!";
        System.out.println(resultFooterXpath);

        System.out.println("=================================================");
        System.out.println();

    }

}
