package com.cybertek.tests.day5_testNG_intro_dropdowns;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Introduction {

    @BeforeMethod //It runs 1 before each method is running
    public void setUpMethod(){
        System.out.println("Before Method is running...");
    }

    @AfterMethod //It runs 1 after each method is running
    public void tearDownMethod(){
        System.out.println("After method is running...");
    }

    @Test
    public void test1(){
        System.out.println("Test1 is running...");
    }

    @Test
    public void test2(){
        System.out.println("Test2 is running...");
    }
}
