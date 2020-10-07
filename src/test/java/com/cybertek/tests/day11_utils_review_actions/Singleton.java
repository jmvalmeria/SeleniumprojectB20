package com.cybertek.tests.day11_utils_review_actions;

public class Singleton {

    //Making the constructor private, so we limit creating objects from this class
    private Singleton(){

    }

    //Making the String private so that we can only reach this using getter method
    private static String word;

    public static String getWord(){
        if(word==null){
            System.out.println("First time call. Word object is null. " + "Assigning value to it now!");
            word = "something";

        }else{
            System.out.println("Word already has a value");
        }

        return word;
    }

}
