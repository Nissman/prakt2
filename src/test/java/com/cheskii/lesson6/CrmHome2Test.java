package com.cheskii.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;

public class CrmHome2Test {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 7);
        driver.get("https://crm.geekbrains.space/");
        login(driver);
    }

     @Test
     void createProjectTest(){
         selectBarItem(driver,"Проекты",  "Все проекты");
         new ProjectsPage(driver).clickCreateProjectRequest();
         new CreateProjectPage(driver)
                 .fillProjectName("test15113")
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
