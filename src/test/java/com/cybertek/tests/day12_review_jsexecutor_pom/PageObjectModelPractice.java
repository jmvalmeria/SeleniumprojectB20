package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;

public class PageObjectModelPractice {

    @Test
    public void login_to_smartbear(){
        LoginPage loginPage = new LoginPage();
        Driver.getDriver().get("");
        loginPage.usernameInput.sendKeys("anyusername");
    }

}
