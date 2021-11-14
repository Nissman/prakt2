package com.cheskii.lesson6;

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

    public DiaryPage deleteEntryClick(){
        delete.click();
        return this;
    }

    @FindBy(xpath ="//div[@class='modal-content']" )
    private WebElement modalContent;

    @FindBy(xpath = "//button[.='Да']")
    private WebElement confirm;

    public DiaryPage confirmClick(){
        webDriverWait.until(ExpectedConditions.visibilityOf(modalContent));
        confirm.click();
        return this;
    }
}
