package com.cheskii.lesson8;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class AdditionalTestMethods {

    @After
    public void after(){
        Selenide.closeWebDriver();
    }
}
