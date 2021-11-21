package com.cheskii.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ContractorsPage {
    private SelenideElement buttonCreateContractorRequest = $(By.xpath("//a[.='Создать контактное лицо']"));

    @Step("Клик на кнопку создания контактного лица")
    public void clickCreateContractorRequest() {
        buttonCreateContractorRequest.click();
    }
}
