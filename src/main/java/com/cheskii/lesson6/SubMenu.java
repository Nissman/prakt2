package com.cheskii.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubMenu extends BaseView{
    public SubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Контактные лица']")
    public WebElement contractorsSubMenuItem;

    @FindBy(xpath = "//span[.='Все проекты']")
    public WebElement projectSubMenuItem;

    public void subMenuItemClick(String itemName) {
        switch (itemName){
            case "Контактные лица":
                contractorsSubMenuItem.click();
                break;
            case "Все проекты":
                projectSubMenuItem.click();
                break;
        }
    }
}
