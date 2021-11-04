package com.cheskii.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class DiaryHomeTest {
    public static void main(String[] args) throws InterruptedException {
      newEntryPositive();
      delete();
      newEntryNegativeA();
      newEntryNegativeB();
    }
    static void newEntryPositive() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://diary.ru/");
        login(driver);
        driver.findElement(By.xpath("//span[.='Новая запись']/ancestor::a")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'message_ifr')]")));
        driver.findElement(By.id("tinymce")).sendKeys("test");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//input[@value='Опубликовать']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
    static void delete() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://diary.ru/");
        login(driver);
        driver.findElement(By.xpath("//span[.='Мой дневник']/ancestor::a")).click();
        driver.findElement(By.xpath("//a[@title='Удалить']")).click();
        driver.findElement(By.xpath("//button[.='Да']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
    static void newEntryNegativeA() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://diary.ru/");
        login(driver);
        driver.findElement(By.xpath("//span[.='Новая запись']/ancestor::a")).click();
        driver.findElement(By.xpath("//input[@value='Опубликовать']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
    static void newEntryNegativeB() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://diary.ru/");
        login(driver);
        driver.findElement(By.xpath("//span[.='Новая запись']/ancestor::a")).click();
        driver.findElement(By.name("BlogsPosts[title]")).sendKeys("test");
        driver.findElement(By.xpath("//input[@value='Опубликовать']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
    static void login(WebDriver driver) {
        Cookie cookie = new Cookie("_identity_", "57987af32af0bacbee7107d174279b935e04066d40fab61b6748d497b7df9733a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3558806%2C%22W-5Z9KxBlvPMz88QsEhRRwxAT7yJlOGP%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }
}
