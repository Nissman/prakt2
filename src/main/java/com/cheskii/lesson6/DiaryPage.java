package com.cheskii.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DiaryPage extends BaseView{
    public DiaryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Удалить']")
    private WebElement delete;

    @Step("Удаление записи в дневнике")
    public DiaryPage deleteEntryClick(){
        delete.click();
        return this;
    }

    @FindBy(xpath ="//div[@class='modal-content']" )
    private WebElement modalContent;

    @FindBy(xpath = "//button[.='Да']")
    private WebElement confirm;

    @Step("Подтверждение удаления записи")
    public DiaryPage confirmClick(){
        webDriverWait.until(ExpectedConditions.visibilityOf(modalContent));
        confirm.click();
        return this;
    }
}
