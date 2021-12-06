package com.thinh.nguyen.chapter1.testcase2;

import com.thinh.nguyen.driver.SuiteInit;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class VerifyInvalidEmailWithoutSuffixDomain extends SuiteInit {

    @Epic("Chapter 1 : Automate 'User Registration' of an website with Selenium")
    @Story("Create user")
    @Feature("Display error when email is invalid email")
    @Test
    public void testInvalidEmail() throws Exception {
        driver.get("http://testautomationpractice.blogspot.com/");
        driver.switchTo().frame(0);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //First name
        driver.findElement(By.xpath("//input[@id='RESULT_TextField-1']")).sendKeys("Thinh");
        //Last name
        driver.findElement(By.xpath("//input[@id='RESULT_TextField-2']")).sendKeys("Nguyen");
        //Phone
        driver.findElement(By.xpath("//input[@id='RESULT_TextField-3']")).sendKeys("09999999");
        //Country
        driver.findElement(By.xpath("//input[@id='RESULT_TextField-4']")).sendKeys("VN");
        //City
        driver.findElement(By.xpath("//input[@id='RESULT_TextField-5']")).sendKeys("Ho Chi Minh");

        //Invalid Email
        driver.findElement(By.xpath("//input[@id='RESULT_TextField-6']")).sendKeys("amknow@know");

        //Enter email field
        driver.findElement(By.xpath("//input[@id='RESULT_TextField-6']")).sendKeys(Keys.ENTER);

        //Inject javascript to get validation message and check validation
        //String actual = (String) js.executeScript("return arguments[0].validationMessage;", driver.findElement(By.xpath("//input[@id='RESULT_TextField-6']")));
        assertEquals((String) js.executeScript("return arguments[0].validationMessage;", driver.findElement(By.xpath("//input[@id='RESULT_TextField-6']"))), "Please include an '@' in the email address. 'amknow' is missing an '@'.");
    }
}
