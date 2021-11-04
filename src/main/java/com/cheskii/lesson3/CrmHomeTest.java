package com.cheskii.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CrmHomeTest {
    public static void main(String[] args) throws InterruptedException {
        String projectName ="sometest04123";
        String lastName = "test411l";
        String firstName = "test411f";
        String jobTitle = "qa";
        createProject(projectName);
        createContactFace(lastName, firstName, jobTitle);
    }
    static void createProject(String projectName) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);
        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li/a"));
        WebElement expensesMenuItem = menuItems.stream().filter(e -> e.getText().equals("Проекты")).findFirst().get();
        Actions actions = new Actions(driver);
        actions.moveToElement(expensesMenuItem).build().perform();
        driver.findElement(By.xpath("//span[.='Все проекты']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[.='Создать проект']")).click();
        Thread.sleep(5000);
        //наименование проекта
        driver.findElement(By.name("crm_project[name]")).sendKeys(projectName);
        //выбор организации
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        Thread.sleep(2000);
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
        Thread.sleep(7000);
        driver.quit();
    }
    static void createContactFace(String lastName, String firstName, String jobTitle) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);
        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li/a"));
        WebElement expensesMenuItem = menuItems.stream().filter(e -> e.getText().equals("Контрагенты")).findFirst().get();
        Actions actions = new Actions(driver);
        actions.moveToElement(expensesMenuItem).build().perform();
        driver.findElement(By.xpath("//span[.='Контактные лица']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[.='Создать контактное лицо']")).click();
        Thread.sleep(5000);
        //фамилия
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys(lastName);
        //имя
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys(firstName);
        //выбор организации
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(" //ul[@class='select2-results']/li/div[.=12323142342134]")).click();
        //должность
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys(jobTitle);
        driver.findElement(By.xpath("//button[contains(., 'Сохранить и закрыть')]")).click();
        Thread.sleep(7000);
        driver.quit();
    }
    static void login(WebDriver driver) {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
