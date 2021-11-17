package com.cheskii.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContractorsPage extends BaseView{
    public ContractorsPage(WebDriver driver) {
        super(driver);
    }

    private final String byXpathButtonCreateContractorRequestLocator = "//a[.='Создать контактное лицо']";
    @FindBy(xpath = byXpathButtonCreateContractorRequestLocator)
    private WebElement buttonCreateContractorRequest;

    @Step("Клик на кнопку создания контактного лица")
    public CreateProjectPage clickCreateContractorRequest() {
        webDriverWait.until(ExpectedConditions.visibilityOf(loader));
        webDriverWait.until(ExpectedConditions.invisibilityOf(loader));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(byXpathButtonCreateContractorRequestLocator)));
        buttonCreateContractorRequest.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CreateProjectPage.byXpathSaveAndCloseButtonLocator)));
        return new CreateProjectPage(driver);
    }
}
