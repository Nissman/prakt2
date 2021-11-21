package com.cheskii.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class SubMenu {
    private SelenideElement contractorsSubMenuItem = $(By.xpath("//span[.='Контактные лица']"));
    private SelenideElement projectSubMenuItem = $(By.xpath("//span[.='Все проекты']"));

    @Step("Клик на подменю")
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
