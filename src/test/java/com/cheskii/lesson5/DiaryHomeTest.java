package com.cheskii.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.cheskii.lesson5.Helpers.clickWithJS;
import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DiaryHomeTest {
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

    @Order(1)
    @ParameterizedTest
    @CsvSource({"test"})
    void newEntryPositiveTest(String text){
        driver.findElement(By.xpath("//span[.='Новая запись']/ancestor::a")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'message_ifr')]")));
        driver.findElement(By.id("tinymce")).sendKeys(text);
        driver.switchTo().defaultContent();
        clickWithJS(driver, driver.findElement(By.xpath("//input[@id='rewrite']")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='day-header']")));
        WebElement check = (driver.findElement(By.xpath("//div[@class='post-inner']")));
        assertThat(check.getText()).isEqualTo(text);
    }

    @Order(2)
    @Test
    void deleteTest(){
        driver.findElement(By.xpath("//span[.='Мой дневник']/ancestor::a")).click();
        driver.findElement(By.xpath("//a[@title='Удалить']")).click();
        driver.findElement(By.xpath("//button[.='Да']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Нет записей']")));
        WebElement check = driver.findElement(By.xpath("//div[.='Нет записей']"));
        assertThat(check.getText()).isEqualTo("Нет записей");
    }

    @Test
    void newEntryNegativeATest(){
        driver.findElement(By.xpath("//span[.='Новая запись']/ancestor::a")).click();
        clickWithJS(driver, driver.findElement(By.xpath("//input[@id='rewrite']")));
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        String s = driver.switchTo().alert().getText();
        assertThat(s).isEqualTo("Вы не ввели текст сообщения");
    }

    @Test
    void newEntryNegativeBTest(){
        driver.findElement(By.xpath("//span[.='Новая запись']/ancestor::a")).click();
        driver.findElement(By.name("BlogsPosts[title]")).sendKeys("test");
        clickWithJS(driver, driver.findElement(By.xpath("//input[@id='rewrite']")));
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        String s = driver.switchTo().alert().getText();
        assertThat(s).isEqualTo("Вы не ввели текст сообщения");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    static void login(WebDriver driver) {
        driver.get("https://diary.ru/");
        Cookie cookie = new Cookie("_identity_", "9f44bed173f03329d0ccc70ee549702481f104486aedef2e3c9e0f47d060072da%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A48%3A%22%5B3558806%2C%22W-5Z9KxBlvPMz88QsEhRRwxAT7yJlOGP%22%2C900%5D%22%3B%7D");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }
}
