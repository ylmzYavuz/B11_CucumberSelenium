package com.eurotech.stepDefinitions;

import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {//Isim gut practice genel kabul görmüs isim

    @Before
    public void setUp(){
        //System.out.println("\tThis is coming from Before method");
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //findElement elementi bulana kadar 10 saniye bekleyecek
        Driver.get().manage().window().maximize();
    }
    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        //System.out.println("\tThis is coming from After method");
        Driver.closeDriver();
    }
    @Before("@db")
    public void setUpDB(){
        //System.out.println("\tConnecting DB");
    }
    @After("@db")
    public void tearDownDB(){
        //System.out.println("\tDisconnecting DB");
    }
}
