package com.thinh.nguyen.chapter1.testcase1;

import com.thinh.nguyen.driver.SuiteInit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import static org.testng.Assert.assertEquals;


public class VolunteerSignUpUnsuccessfully extends SuiteInit {

    @Epic("Chapter 1 : Automate 'User Registration' of an website with Selenium")
    @Story("Create user")
    @Feature("Display error when creating unsuccessfully")
    @Test
    public void testUnsuccessfully() throws Exception {
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
        //Email
        driver.findElement(By.xpath("//input[@id='RESULT_TextField-6']")).sendKeys("am@know.com");
        //Gender
        js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//input[@id='RESULT_RadioButton-7_0']")));
        //What days of the week are you consistently available? : Tuesday
        js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//input[@id='RESULT_CheckBox-8_2']")));
        //Best Time to Contact : Afternoon
        new Select(driver.findElement(By.xpath("//select[@name='RESULT_RadioButton-9']"))).selectByVisibleText("Afternoon");
        //Submit form
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Verify error message when creating user unsuccessfully
        assertEquals(driver.findElement(By.xpath("//*/text()[normalize-space(.)='An error has occurred']/parent::*")).getText(), "An error has occurred");
        assertEquals(driver.findElement(By.xpath("//div[@id='content']")).getText(), "The result storage capacity has been reached for this form. Your result was not created. Please contact the form owner.");
    }
}
