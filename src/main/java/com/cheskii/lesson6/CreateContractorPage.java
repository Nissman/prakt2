package com.cheskii.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateContractorPage extends BaseView{
    public CreateContractorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_contact[lastName]")
    private WebElement lastName;

    @Step("Заполнение поля 'Фамилия'")
    public CreateContractorPage fillLastName(String name) {
        lastName.sendKeys(name);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    private WebElement firstName;

    @Step("Заполнение поля 'Имя'")
    public CreateContractorPage fillFirstName(String name) {
        firstName.sendKeys(name);
        return this;
    }

    private static final String organizationItemLocator ="//ul[@class='select2-results']/li/div[.=12323142342134]";
    @FindBy(xpath = "//span[.='Укажите организацию']")
    private WebElement organizationLocator;

    @Step("Клик на выпадающее меню 'Укажите организацию'")
    public CreateContractorPage touchOrganization() {
        organizationLocator.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(organizationItemLocator)));
        return this;
    }

    @FindBy(xpath = organizationItemLocator)
    private WebElement organizationItem;

    @Step("Клик на указанную организацию")
    public CreateContractorPage fillOrganization(){
        organizationItem.click();
        return this;
    }

    @FindBy(name = "crm_contact[jobTitle]")
    private WebElement jobTitle;

    @Step("Заполнение поля 'Должность'")
    public CreateContractorPage fillJobTitle(String title) {
        jobTitle.sendKeys(title);
        return this;
    }

    public static final String byXpathSaveAndCloseButtonLocator = "//button[contains(., 'Сохранить и закрыть')]";
    @FindBy(xpath = byXpathSaveAndCloseButtonLocator)
    private WebElement saveAndCloseButton;

    @Step("Клик на кнопку 'Сохранить и закрыть'")
    public CreateContractorPage clickSaveAndCloseButton() {
        saveAndCloseButton.click();
        return this;
    }
}
