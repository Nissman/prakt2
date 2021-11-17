package com.cheskii.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectsPage extends BaseView{
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    private final String byXpathButtonCreateProjectRequestLocator = "//a[.='Создать проект']";
    @FindBy(xpath = byXpathButtonCreateProjectRequestLocator)
    private WebElement buttonCreateProjectRequest;

    @Step("Клик на кнопку созданя проекта")
    public CreateProjectPage clickCreateProjectRequest() {
        webDriverWait.until(ExpectedConditions.visibilityOf(loader));
        webDriverWait.until(ExpectedConditions.invisibilityOf(loader));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(byXpathButtonCreateProjectRequestLocator)));
        buttonCreateProjectRequest.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CreateProjectPage.byXpathSaveAndCloseButtonLocator)));
        return new CreateProjectPage(driver);
    }
}
