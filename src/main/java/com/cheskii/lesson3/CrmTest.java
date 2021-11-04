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


public class CrmTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);

        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li/a"));

        WebElement expensesMenuItem = menuItems.stream().filter(e -> e.getText().equals("Расходы")).findFirst().get();

        Actions actions = new Actions(driver);
        actions.moveToElement(expensesMenuItem).build().perform();
        driver.findElement(By.xpath("//span[.='Заявки на расходы']")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[.='Создать заявку на расход']")).click();

        driver.findElement(By.name("crm_expense_request[description]")).sendKeys("test");

        Select selectBusinessUnit = new Select(driver.findElement(By.name("crm_expense_request[businessUnit]")));
        selectBusinessUnit.selectByVisibleText("Research & Development");

        Select expenditureSelect = new Select(driver.findElement(By.name("crm_expense_request[expenditure]")));
        expenditureSelect.selectByVisibleText("01101 - ОС: вычислительная техника инфраструктуры");

        driver.findElement(By.xpath("//input[contains(@id, 'datePlan') and @placeholder='Укажите дату']")).click();
        driver.findElement(By.xpath("//a[.='21']")).click();
        driver.findElement(By.xpath("//input[contains(@id, 'crm_expense_request_sumPlan-uid')]")).sendKeys("100");

        driver.findElement(By.xpath("//button[contains(., 'Сохранить и закрыть')]")).click();
        Thread.sleep(5000);
        driver.quit();

    }
    static void login(WebDriver driver) {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }

}
