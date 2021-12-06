package com.thinh.nguyen.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteGrid extends RemoteWebDriver {
    private int executionSpeed = 2000; // mil second

    public RemoteGrid(java.net.URL remoteAddress,Capabilities capabilities) {
        super(remoteAddress, capabilities);

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
