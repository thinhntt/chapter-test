package com.thinh.nguyen.chapter2.testcase1;

import com.thinh.nguyen.driver.SuiteInit;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class BuyProduct extends SuiteInit {

    @Epic("Chapter 2 : Automate 'Buy Product' functionality of an e-commerce website with Selenium")
    @Story("Order product with delivery information")
    @Feature("Order product")
    @Test
    public void testBuy() throws Exception {

        driver.get("http://practice.automationtesting.in/");
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Select "Selenium Ruby" add to basket
        assertEquals(driver.findElement(By.xpath("//div[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a/h3")).getText(), "Selenium Ruby");
        driver.findElement(By.xpath("//a[contains(@href, '/?add-to-cart=160')]")).click();

        //Go to Cart
        driver.findElement(By.xpath("//a[@class='wpmenucart-contents']")).click();

        //Check product is selected: "Selenium Ruby"
        assertEquals(driver.findElement(By.xpath("//tr[1][@class='cart_item']/td[3]/a")).getText(), "Selenium Ruby");

        //Proceed Check Out
        driver.findElement(By.xpath("//a[contains(text(),'Proceed to Checkout')]")).click();

        //Enter Delivery Information
        driver.findElement(By.xpath("//input[@id='billing_first_name']")).sendKeys("Thinh");
        driver.findElement(By.xpath("//input[@id='billing_last_name']")).sendKeys("Nguyen");
        driver.findElement(By.xpath("//input[@id='billing_company']")).sendKeys("AMKNOW");
        driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("am@know.com");
        driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys("0999999999");
        {
            driver.findElement(By.xpath("//div[@id='s2id_billing_country']")).click();
            driver.findElement(By.xpath("//input[@id='s2id_autogen1_search']")).sendKeys("Vietnam");
            driver.findElement(By.xpath("//input[@id='s2id_autogen1_search']")).sendKeys(Keys.ENTER);
        }
        driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys("Nguyen Van Linh");
        driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys("70000");
        driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("Ho Chi Minh");

        //Proceed Order
        js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//input[@id='place_order']")));
        Thread.sleep(5000);

        //Check your order status by verify message: "Thank you. Your order has been received."
        assertEquals(driver.findElement(By.cssSelector("p.woocommerce-thankyou-order-received")).getText(), "Thank you. Your order has been received.");

        //Take a screenshot
        takeScreenshotEntirePage("src/test/java/com/thinh/nguyen/chapter2/testcase1/orderScreenshot.png");
    }

    public void takeScreenshotEntirePage(String pathname) throws IOException{
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File(pathname));
    }
}
