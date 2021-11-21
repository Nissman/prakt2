package com.cheskii.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateContractorPage {
  private SelenideElement lastName = $(By.name("crm_contact[lastName]"));

    @Step("Заполнение поля 'Фамилия'")
    public CreateContractorPage fillLastName(String name) {
        lastName.sendKeys(name);
        return this;
    }

    private SelenideElement firstName = $(By.name("crm_contact[firstName]"));

    @Step("Заполнение поля 'Имя'")
    public CreateContractorPage fillFirstName(String name) {
        firstName.sendKeys(name);
        return this;
    }

    private SelenideElement organizationLocator = $(By.xpath("//span[.='Укажите организацию']"));

    @Step("Клик на выпадающее меню 'Укажите организацию'")
    public CreateContractorPage touchOrganization() {
        organizationLocator.click();
        return this;
    }

    public SelenideElement organizationItem = $(By.xpath("//ul[@class='select2-results']/li/div[.=12323142342134]"));

    @Step("Клик на указанную организацию")
    public CreateContractorPage fillOrganization(){
        organizationItem.click();
        return this;
    }

    private SelenideElement jobTitle = $(By.name("crm_contact[jobTitle]"));

    @Step("Заполнение поля 'Должность'")
    public CreateContractorPage fillJobTitle(String title) {
        jobTitle.sendKeys(title);
        return this;
    }

    private SelenideElement saveAndCloseButton = $(By.xpath("//button[contains(., 'Сохранить и закрыть')]"));

    @Step("Клик на кнопку 'Сохранить и закрыть'")
    public CreateContractorPage clickSaveAndCloseButton() {
        saveAndCloseButton.click();
        return this;
    }

    public SelenideElement successMessage = $(By.xpath("//div[.='Контактное лицо сохранено']"));
}
