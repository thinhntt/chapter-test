package com.thinh.nguyen.driver;

import com.google.common.collect.ImmutableMap;
import com.thinh.nguyen.listener.TestListener;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.thinh.nguyen.driver.Environment.allureEnvironmentWriter;

@Listeners(TestListener.class)

public class SuiteInit {

    public static WebDriver driver;
    public String baseUrl;
    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();

    @BeforeSuite
    public void setUp() throws MalformedURLException {

        if(System.getProperty("profileId").equalsIgnoreCase("production-chrome")){
            ChromeOptions options = new ChromeOptions();
            options.setCapability("resolution", "3840x2160");
            driver = new RemoteGrid(new URL("http://159.223.43.236:4444"), options);
        }

        if(System.getProperty("profileId").contains("local")){
            ChromeOptions options = new ChromeOptions();
            driver = new Chrome(options);
        }

        baseUrl = "https://google.com";
        //driver.manage().window().setSize(new Dimension(3840,2160));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);


    }

    @AfterSuite
    public void tearDown() {
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();

        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Platform", caps.getPlatform().name())
                        .put("Browser", caps.getBrowserName())
                        .put("Browser.Version", caps.getVersion())
                        .put("URL", baseUrl)
                        .build(), System.getProperty("allure.results.directory") );

        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
