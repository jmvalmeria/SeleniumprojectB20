package com.cybertek.tests.day11_utils_review_actions.OfficeHoursReviewActions;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPractice {

    @Test
    public void p2_double_click_test(){
        /*
        TC #16: Double Click Test
        1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        2. Switch to iframe.
        3. Double click on the text "Double-click me to change my text color."
        4. Assert: Text's "style" attribute value contains "red".
        */

        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Driver.getDriver().switchTo().frame("iframeResult");

        //Double click on the text "Double-click me to change my text color."
        WebElement textToDoubleClick = Driver.getDriver().findElement(By.id("demo"));

        //Creatian actions instance to be able to use methods that come with it
        Actions actions = new Actions(Driver.getDriver());

        //Using actions instance, and doubleClick method to doubleClick
        actions.doubleClick(textToDoubleClick).perform();

        //4. Assert: Text's "style" attribute value contains "red".
        String expected = "red";
        String actual = textToDoubleClick.getAttribute("style"); //color: red;

        Assert.assertTrue(actual.contains(expected));
    }


    @Test
    public void p3_drag_and_drop(){
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //2. Drag and drop the small circle to bigger circle.
        //Locating Circles
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        BrowserUtils.wait(3);

        Actions actions = new Actions(Driver.getDriver());
        //DragAdnDrop method expects to arguments:
        //1) Which WebElement you want to drag: source
        //2) Where do you want to drop it?: target
        actions.dragAndDrop(smallCircle,bigCircle).perform();

        //3. Assert: -Text in big circle changed to: “You did great!
        String expected = "You did great!";
        String actual = bigCircle.getText();

        Assert.assertTrue(actual.equals(expected));

        Driver.closeDriver();

    }

    @Test
    public void p3_drag_and_drop_LONGERWAY(){
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //2. Drag and drop the small circle to bigger circle.
        //Locating Circles
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        BrowserUtils.wait(3);

        Actions actions = new Actions(Driver.getDriver());
        //DragAdnDrop method expects to arguments:
        //1) Which WebElement you want to drag: source
        //2) Where do you want to drop it?: target
        actions.clickAndHold(smallCircle).perform();
        BrowserUtils.wait(2);

        actions.moveToElement(bigCircle).perform();
        BrowserUtils.wait(2);

        actions.release();
        //3. Assert: -Text in big circle changed to: “You did great!
        String expected = "You did great!";
        String actual = bigCircle.getText();

        Assert.assertTrue(actual.equals(expected));

        Driver.closeDriver();

    }

    @Test
    public void p4_context_click_test(){
        //TC #17: Context Click – HOMEWORK
        //1. Go to https://the-internet.herokuapp.com/context_menu
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        Driver.getDriver().manage().window().maximize();

        //2. Right click to the box.
        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(box).perform();

        //3. Alert will open.
        Alert alert = Driver.getDriver().switchTo().alert();

        //4. Accept alert
        BrowserUtils.wait(2);
        alert.accept();

        //No assertion needed for this practice.
    }

}
