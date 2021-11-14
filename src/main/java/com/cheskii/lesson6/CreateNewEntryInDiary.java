package com.cheskii.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.cheskii.lesson5.Helpers.clickWithJS;

public class CreateNewEntryInDiary extends BaseView{
    public CreateNewEntryInDiary(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "BlogsPosts[title]")
    private WebElement titleIn;
    public CreateNewEntryInDiary fillTitle (String title){
        titleIn.sendKeys(title);
        return this;
    }

    @FindBy(xpath = "//iframe[contains(@id,'message_ifr')]")
    private  WebElement frame;

    @FindBy(id = "tinymce")
    private WebElement message;

    public CreateNewEntryInDiary fillMessage (String mes){
        driver.switchTo().frame(frame);
        message.sendKeys(mes);
        driver.switchTo().defaultContent();
        return this;
    }

    public static final String byXpathRewriteButtonLocator = "//input[@id='rewrite']";
    @FindBy(xpath = byXpathRewriteButtonLocator)
    private WebElement rewriteButton;

    public CreateNewEntryInDiary clickRewriteButton() {
        clickWithJS(driver, rewriteButton);
        return this;
    }
}