package com.cheskii.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiaryMainPage extends BaseView{
    public DiaryMainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[.='Новая запись']/ancestor::a")
    private WebElement newEntry;

    @FindBy(xpath = "//span[.='Мой дневник']/ancestor::a")
    private WebElement myDiary;

    public void newEntryClick(){
        newEntry.click();
    }

    public void myDiaryClick(){
        myDiary.click();
    }
}
