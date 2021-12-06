package com.thinh.nguyen.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome extends ChromeDriver {

    private int executionSpeed = 1000; // mil secondH

    public Chrome(Capabilities desiredCapabilities) {
        super(desiredCapabilities);

    }

    @Override
    public WebElement findElement(By by){

        try {
            Thread.sleep(executionSpeed);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return by.findElement((SearchContext) this);
    }

}
