package com.cheskii.lesson6;

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

    public CreateContractorPage fillLastName(String name) {
        lastName.sendKeys(name);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    private WebElement firstName;

    public CreateContractorPage fillFirstName(String name) {
        firstName.sendKeys(name);
        return this;
    }

    private static final String organizationItemLocator ="//ul[@class='select2-results']/li/div[.=12323142342134]";
    @FindBy(xpath = "//span[.='Укажите организацию']")
    private WebElement organizationLocator;

    public CreateContractorPage touchOrganization() {
        organizationLocator.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(organizationItemLocator)));
        return this;
    }

    @FindBy(xpath = organizationItemLocator)
    private WebElement organizationItem;

    public CreateContractorPage fillOrganization(){
        organizationItem.click();
        return this;
    }

    @FindBy(name = "crm_contact[jobTitle]")
    private WebElement jobTitle;

    public CreateContractorPage fillJobTitle(String title) {
        jobTitle.sendKeys(title);
        return this;
    }

    public static final String byXpathSaveAndCloseButtonLocator = "//button[contains(., 'Сохранить и закрыть')]";
    @FindBy(xpath = byXpathSaveAndCloseButtonLocator)
    private WebElement saveAndCloseButton;

    public CreateContractorPage clickSaveAndCloseButton() {
        saveAndCloseButton.click();
        return this;
    }
}
