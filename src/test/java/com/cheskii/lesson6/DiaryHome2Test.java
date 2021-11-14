package com.cheskii.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DiaryHome2Test {
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
        driver.get("https://diary.ru/");
        login(driver);
    }

    @Order(1)
    @ParameterizedTest
    @CsvSource({"test"})
    void newEntryPositiveTest(String text){
        new DiaryMainPage(driver).newEntryClick();
        new CreateNewEntryInDiary(driver)
                .fillMessage(text)
                .clickRewriteButton();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='day-header']")));
        assertThat(driver.findElement(By.xpath("//div[@class='post-inner']")).getText()).isEqualTo(text);
    }

    @Order(2)
    @Test
    void deleteTest(){
        new DiaryMainPage(driver).myDiaryClick();
        new DiaryPage(driver)
                .deleteEntryClick()
                .confirmClick();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Нет записей']")));
        assertThat(driver.findElement(By.xpath("//div[.='Нет записей']")).getText()).isEqualTo("Нет записей");
    }

    @Test
    void newEntryNegativeATest() {
        new DiaryMainPage(driver).newEntryClick();
        new CreateNewEntryInDiary(driver)
                .clickRewriteButton();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        String s = driver.switchTo().alert().getText();
        assertThat(s).isEqualTo("Вы не ввели текст сообщения");
           }

    @Test
    void newEntryNegativeBTest(){
        new DiaryMainPage(driver).newEntryClick();
        new CreateNewEntryInDiary(driver)
                .fillTitle("test")
                .clickRewriteButton();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        String s = driver.switchTo().alert().getText();
        assertThat(s).isEqualTo("Вы не ввели текст сообщения");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    static void login(WebDriver driver) {
        Cookie cookie = new Cookie("_identity_", "57987af32af0bacbee7107d174279b935e04066d40fab61b6748d497b7df9733a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3558806%2C%22W-5Z9KxBlvPMz88QsEhRRwxAT7yJlOGP%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }
}
