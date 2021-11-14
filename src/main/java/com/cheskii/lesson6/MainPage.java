package com.cheskii.lesson6;

import org.openqa.selenium.WebDriver;

public class MainPage extends BaseView{
    NavigationBar navigationBar;

    public MainPage(WebDriver driver){
        super(driver);
        navigationBar = new NavigationBar(driver);
    }
}
