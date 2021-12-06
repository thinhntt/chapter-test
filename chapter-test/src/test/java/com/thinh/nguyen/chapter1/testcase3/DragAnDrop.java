package com.thinh.nguyen.chapter1.testcase3;

import com.thinh.nguyen.driver.SuiteInit;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
public class DragAnDrop extends SuiteInit {

    @Epic("Chapter 1 : Automate 'User Registration' of an website with Selenium")
    @Story("Drag and Drop")
    @Feature("Drag item and drop item")
    @Test
    public void testDragAndDrop() throws Exception {
        driver.get("http://testautomationpractice.blogspot.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);

        //Check drag and drop available
        assertEquals(driver.findElement(By.xpath("//div[@id='draggable']")).getText(), "Drag me to my target");
        assertEquals(driver.findElement(By.xpath("//div[@id='droppable']")).getText(), "Drop here");

        //Drag "from" drop "to"
        {
            Actions builder = new Actions(driver);
            WebElement from = driver.findElement(By.xpath("//div[@id='draggable']"));
            WebElement to = driver.findElement(By.xpath("//div[@id='droppable']"));
            builder.dragAndDrop(from, to).build().perform();
        }

        //Verify item is dropped
        assertEquals(driver.findElement(By.xpath("//div[@id='droppable']")).getText(), "Dropped!");
    }
}
