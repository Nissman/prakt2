package com.cheskii.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectPage extends BaseView{
    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_project[name]")
    private WebElement projectName;

    @Step("Заполнение поля 'Наименование'")
    public CreateProjectPage fillProjectName(String name) {
        projectName.sendKeys(name);
        return this;
    }

    private static final String organizationItemLocator ="//ul[@class='select2-results']/li/div[.=12323142342134]";
    @FindBy(xpath = "//span[.='Укажите организацию']")
    private WebElement organizationLocator;

    @Step("Клик на выпадающее меню 'Укажите организацию'")
    public CreateProjectPage touchOrganization() {
        organizationLocator.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(organizationItemLocator)));
        return this;
    }

    @FindBy(xpath = organizationItemLocator)
    private WebElement organizationItem;

    @Step("Клик на указанную организацию")
    public CreateProjectPage fillOrganization(){
        organizationItem.click();
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    private WebElement selectBusinessUnit;

    @Step("Выбор Подразделения")
    public CreateProjectPage selectBusinessUnit(String option) {
        new Select(selectBusinessUnit).selectByVisibleText(option);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    private WebElement selectProjectCurator;

    @Step("Выбор куратора проекта")
    public CreateProjectPage selectProjectCurator(String option) {
        new Select(selectProjectCurator).selectByVisibleText(option);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    private WebElement selectProjectRp;

    @Step("Выбор руководителя проекта")
    public CreateProjectPage selectProjectRp(String option) {
        new Select(selectProjectRp).selectByVisibleText(option);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    private WebElement selectProjectManager;

    @Step("Выбор менеджера проекта")
    public CreateProjectPage selectProjectManager(String option) {
        new Select(selectProjectManager).selectByVisibleText(option);
        return this;
    }

    public static final String byXpathSaveAndCloseButtonLocator = "//button[contains(., 'Сохранить и закрыть')]";
    @FindBy(xpath = byXpathSaveAndCloseButtonLocator)
    private WebElement saveAndCloseButton;

    @Step("Клик на кнопку 'Сохранить и закрыть'")
    public CreateProjectPage clickSaveAndCloseButton() {
        saveAndCloseButton.click();
        return this;
    }
}
