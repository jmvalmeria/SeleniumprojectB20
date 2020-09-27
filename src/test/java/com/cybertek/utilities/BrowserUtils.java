package com.cybertek.utilities;

/*
In this class we will store utility methods that can be applied to any browser content.
Anytime you feel like you have a good logic that you can use in the future, create method
ot it and store it in this class.

Then call it in the future to use it.
*/

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    /**
    Accepts a list of Web Element
    @param list<WebElements>
    @return List<String>
    Method should be returning a list of Strings
    */

    public static List<String> getElementsText(List<WebElement> list){

        ArrayList<String> webelementsAsString = new ArrayList<>();
        for (WebElement each : list){
            webelementsAsString.add(each.getText());
        }

        return webelementsAsString;
    }
}
