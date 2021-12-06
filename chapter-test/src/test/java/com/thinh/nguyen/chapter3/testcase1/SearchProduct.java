package com.thinh.nguyen.chapter3.testcase1;

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

import java.security.Key;

import static org.testng.Assert.assertEquals;

public class SearchProduct extends SuiteInit{

    @Epic("Chapter 3 : Automate 'Search Product' functionality of an e-commerce website")
    @Story("Search product")
    @Feature("Searching")
    @Test
    public void testSearchProduct() throws Exception{
        driver.get("http://practice.automationtesting.in/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);

        //Hover to search box
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//input[@id='s']"))).perform();
        driver.findElement(By.xpath("//input[@name='s']")).click();
        Thread.sleep(2000);

        //Enter "Selenium" and press Enter
        driver.findElement(By.xpath("//input[@id='s']")).sendKeys("Selenium");
        driver.findElement(By.xpath("//input[@id='s']")).sendKeys(Keys.ENTER);

        //Validate the result – “Selenium Ruby”
        Thread.sleep(2000);
        assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(),"SEARCH RESULTS FOR: SELENIUM");
        assertEquals(driver.findElement(By.xpath("//div[@class='post-content']/div/h2/a")).getText(),"Selenium Ruby");

        //Hover to search box
        actions.moveToElement(driver.findElement(By.xpath("//input[@id='s']"))).perform();
        driver.findElement(By.xpath("//input[@name='s']")).click();
        Thread.sleep(2000);

        //Clear search box and search for “Python”
        driver.findElement(By.xpath("//input[@id='s']")).clear();
        driver.findElement(By.xpath("//input[@id='s']")).sendKeys("Python");
        driver.findElement(By.xpath("//input[@id='s']")).sendKeys(Keys.ENTER);

        //Validate the result – “Sorry, nothing found.”
        Thread.sleep(2000);
        assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(),"SEARCH RESULTS FOR: PYTHON");
        assertEquals(driver.findElement(By.xpath("//div[@id='content']/p")).getText(),"Sorry, nothing found.");
    }
}
