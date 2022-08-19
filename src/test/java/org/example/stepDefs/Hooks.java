package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver = null;
    @Before
    public static void OpenBrowser()
    {
        //1-set System property
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");

        //2- Create new object from Webdriver
        driver = new ChromeDriver();

        //3- configurations
        //3.1-Maximize window
        driver.manage().window().maximize();

        //3.2- implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //4-Navigate to url
        driver.get("https://demo.nopcommerce.com/");


    }

    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }

}
