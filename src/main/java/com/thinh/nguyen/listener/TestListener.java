package com.thinh.nguyen.listener;

import com.thinh.nguyen.driver.Chrome;
import com.thinh.nguyen.driver.SuiteInit;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Link;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult Result) {

        String currentUrl = SuiteInit.getDriver().getCurrentUrl();
        Allure.addLinks(new Link().withName("Trace url to find error").withUrl(currentUrl));
        Allure.addAttachment("Page Screenshot", new ByteArrayInputStream(((TakesScreenshot)SuiteInit.getDriver()).getScreenshotAs(OutputType.BYTES)));
        //Reporter.log("The trace url :"+ currentUrl);
        //ToDo
    }
}
