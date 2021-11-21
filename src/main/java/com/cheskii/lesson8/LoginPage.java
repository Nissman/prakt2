package com.cheskii.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage {
    private SelenideElement inputLogin = $(By.id("prependedInput"));
    private SelenideElement inputPassword = $(By.id("prependedInput2"));
    private SelenideElement buttonLogin = $(By.id("_submit"));

    @Step("Заполняем поле логин")
    public LoginPage fillLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
            }

    @Step("Заполняем поле пароль")
    public LoginPage fillPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
            }

    @Step("Клик на кнопку входа")
    public void submitLogin() {
        buttonLogin.click();
    }

}
