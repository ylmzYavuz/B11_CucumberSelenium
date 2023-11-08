package com.eurotech.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {//Isim gut practice genel kabul görmüs isim

    @Before
    public void setUp(){
        System.out.println("\tThis is coming from Before method");
    }
    @After
    public void tearDown(){
        System.out.println("\tThis is coming from After method");
    }
    @Before("@db")
    public void setUpDB(){
        System.out.println("\t Connecting DB");
    }
    @After("@db")
    public void tearDownDB(){
        System.out.println("\t Disconnecting DB");
    }
}
