package com.cybertek.tests.day5_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Introduction {

    @BeforeClass
    public void setUpClass(){ //It runs only 1 at the beginning of class, it is the first method that runs, we usually use it to set
        System.out.println("Before class is running...");
    }

    @BeforeMethod //It runs 1 before each Test method is running
    public void setUpMethod(){
        System.out.println("Before Method is running...");
    }

    @AfterMethod //It runs 1 after each Test method had run
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

    @Test
    public void test3(){
        String str1 = "TestNG";
        String str2 = "TestNG";
        String str3 = "asdfasdf";

        Assert.assertTrue(str1.equals(str2));

        Assert.assertTrue(str1.equals(str3),"Str1 is not equal to Str3.");

        Assert.assertEquals(str1,str2, "Failure message just in case str1 is not equals to str2"); //Using another assertion method
    }
}
