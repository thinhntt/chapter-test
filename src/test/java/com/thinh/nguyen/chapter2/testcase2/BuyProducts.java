package com.thinh.nguyen.chapter2.testcase2;

import com.thinh.nguyen.driver.SuiteInit;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class BuyProducts extends SuiteInit {

    @Epic("Chapter 2 : Automate 'Buy Product' functionality of an e-commerce website with Selenium")
    @Story("Total Price is reflecting correctly if user changes quantity on 'Shopping Cart Summary' Page")
    @Feature("Order product")
    @Test
    public void testBuy() throws Exception {

        driver.get("http://practice.automationtesting.in/");
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Select "Selenium Ruby" and "Thinking in HTML" add to basket
        assertEquals(driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a/h3")).getText(), "Selenium Ruby");
        driver.findElement(By.xpath("//a[contains(@href, '/?add-to-cart=160')]")).click();
        Thread.sleep(5000);
        assertEquals(driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-1-0']/div/ul/li/a/h3")).getText(), "Thinking in HTML");
        driver.findElement(By.xpath("//a[contains(@href, '/?add-to-cart=163')]")).click();

        //Go to Cart
        driver.findElement(By.xpath("//a[@class='wpmenucart-contents']")).click();

        //Check product is selected: "Selenium Ruby", price, quantity and total price of "Selenium Ruby"
        assertEquals(driver.findElement(By.xpath("//tr[1][@class='cart_item']/td[3]/a")).getText(), "Selenium Ruby");
        assertEquals(driver.findElement(By.xpath("//tr[1][@class='cart_item']/td[4]")).getText(), "₹500.00");
        assertEquals(driver.findElement(By.xpath("//tr[1][@class='cart_item']/td[5]/div/input")).getAttribute("value"), "1");
        assertEquals(driver.findElement(By.xpath("//tr[1][@class='cart_item']/td[6]")).getText(), "₹500.00");

        //Change "Selenium Ruby" quantity and update basket
        driver.findElement(By.xpath("//div[@id='page-34']/div/div/form/table/tbody/tr/td[5]/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='page-34']/div/div/form/table/tbody/tr/td[5]/div/input")).sendKeys("2");
        driver.findElement(By.xpath("//input[@name='update_cart']")).click();
        Thread.sleep(5000);

        //Verify price, new quantity total price of "Selenium Ruby" after changing quantity
        assertEquals(driver.findElement(By.xpath("//tr[1][@class='cart_item']/td[4]")).getText(), "₹500.00");
        assertEquals(driver.findElement(By.xpath("//tr[1][@class='cart_item']/td[5]/div/input")).getAttribute("value"), "2");
        assertEquals(driver.findElement(By.xpath("//tr[1][@class='cart_item']/td[6]")).getText(), "₹1,000.00");

        //Check subtotal of order after changing quantity
        assertEquals(driver.findElement(By.xpath("//tr[1][@class='cart-subtotal']/td/span")).getText(), "₹1,400.00");

    }
}
