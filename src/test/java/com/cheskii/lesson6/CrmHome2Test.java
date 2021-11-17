package com.cheskii.lesson6;

import com.cheskii.lesson7.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;

@Story("CRM Geekbrains")
public class CrmHome2Test {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBrowser() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new CustomLogger());
        webDriverWait = new WebDriverWait(driver, 7);
        driver.get("https://crm.geekbrains.space/");
        login(driver);
    }

     @Test
     @TmsLink("для примера")
     @Description("Проверка успешного создания нового проекта")
     @Feature("Проекты")
     @DisplayName("Создание нового проекта")
     void createProjectTest(){
         selectBarItem(driver,"Проекты",  "Все проекты");
         new ProjectsPage(driver).clickCreateProjectRequest();
         new CreateProjectPage(driver)
                 .fillProjectName("test17112")
                 .touchOrganization()
                 .fillOrganization()
                 .selectBusinessUnit("Research & Development")
                 .selectProjectCurator("Applanatest Applanatest Applanatest")
                 .selectProjectRp("Applanatest Applanatest Applanatest")
                 .selectProjectManager("Applanatest Applanatest Applanatest")
                 .clickSaveAndCloseButton();
         webDriverWait.until(ExpectedConditions.invisibilityOf(new BaseView(driver).loader));
         assertThat(driver.findElement(By.xpath("//div[.='Проект сохранен']")).getText()).isEqualTo("Проект сохранен");
    }

    @Test
    @Description("Проверка успешного создания контактного лица")
    @Feature("Контактны лица")
    @DisplayName("Добавление контактного лица")
    void createContactFaceTest(){
        selectBarItem(driver,"Контрагенты",  "Контактные лица");
        new ContractorsPage(driver).clickCreateContractorRequest();
        new CreateContractorPage(driver)
                .fillLastName("test1511l")
                .fillFirstName("test1511f")
                .touchOrganization()
                .fillOrganization()
                .fillJobTitle("qa")
                .clickSaveAndCloseButton();
        webDriverWait.until(ExpectedConditions.invisibilityOf(new BaseView(driver).loader));
        assertThat(driver.findElement(By.xpath("//div[.='Контактное лицо сохранено']")).getText()).isEqualTo("Контактное лицо сохранено");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    static void selectBarItem(WebDriver driver, String menu, String subMenu){
        new MainPage(driver).navigationBar.openNavBarItem(menu);
        new SubMenu(driver).subMenuItemClick(subMenu);
    }

    static void login(WebDriver driver){
        new LoginPage(driver).fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin();
    }
}
