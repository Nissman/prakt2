package com.cheskii.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class CrmHomeTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 7);
        login(driver);
    }

    @ParameterizedTest
    @CsvSource({"sometest12114"})
    void createProjectTest(String projectName) {
        driver.get("https://crm.geekbrains.space/");
        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li/a"));
        WebElement expensesMenuItem = menuItems.stream().filter(e -> e.getText().equals("Проекты")).findFirst().get();
        Actions actions = new Actions(driver);
        actions.moveToElement(expensesMenuItem).build().perform();
        driver.findElement(By.xpath("//span[.='Все проекты']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Создать проект']")));
        driver.findElement(By.xpath("//a[.='Создать проект']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("crm_project[name]")));
        //наименование проекта
        driver.findElement(By.name("crm_project[name]")).sendKeys(projectName);
        //выбор организации
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='select2-results']/li/div[.=12323142342134]")));
        driver.findElement(By.xpath("//ul[@class='select2-results']/li/div[.=12323142342134]")).click();
        //выбор подразделения
        Select selectBusinessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        selectBusinessUnit.selectByVisibleText("Research & Development");
        //выбор куратора проекта
        Select selectCurator = new Select(driver.findElement(By.name("crm_project[curator]")));
        selectCurator.selectByVisibleText("Applanatest Applanatest Applanatest");
        //выбор руководителя проекта
        Select selectRp = new Select(driver.findElement(By.name("crm_project[rp]")));
        selectRp.selectByVisibleText("Applanatest Applanatest Applanatest");
        //выбор менеджера проекта
        Select selectManager = new Select(driver.findElement(By.name("crm_project[manager]")));
        selectManager.selectByVisibleText("Applanatest Applanatest Applanatest");
        driver.findElement(By.xpath("//button[contains(., 'Сохранить и закрыть')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert')]")));
        WebElement checkMessage = driver.findElement(By.xpath("//div[.='Проект сохранен']"));
        assertThat(checkMessage.getText()).isEqualTo("Проект сохранен");
    }

    @ParameterizedTest
    @CsvSource({"test411l,test411f,qa"})
    void createContactFaceTest(String lastName, String firstName, String jobTitle){
        driver.get("https://crm.geekbrains.space/");
        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li/a"));
        WebElement expensesMenuItem = menuItems.stream().filter(e -> e.getText().equals("Контрагенты")).findFirst().get();
        Actions actions = new Actions(driver);
        actions.moveToElement(expensesMenuItem).build().perform();
        driver.findElement(By.xpath("//span[.='Контактные лица']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Создать контактное лицо']")));
        driver.findElement(By.xpath("//a[.='Создать контактное лицо']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("crm_contact[lastName]")));
        //фамилия
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys(lastName);
        //имя
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys(firstName);
        //выбор организации
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='select2-results']/li/div[.=12323142342134]")));
        driver.findElement(By.xpath("//ul[@class='select2-results']/li/div[.=12323142342134]")).click();
        //должность
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys(jobTitle);
        driver.findElement(By.xpath("//button[contains(., 'Сохранить и закрыть')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert')]")));
        WebElement checkMessage = driver.findElement(By.xpath("//div[.='Контактное лицо сохранено']"));
        assertThat(checkMessage.getText()).isEqualTo("Контактное лицо сохранено");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    static void login(WebDriver driver) {
        driver.get("https://crm.geekbrains.space/");
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
