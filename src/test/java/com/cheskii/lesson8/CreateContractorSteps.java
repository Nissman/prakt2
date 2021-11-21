package com.cheskii.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;

public class CreateContractorSteps {
    @Given("^I am authorized$")
    public void iAmAuthorized() {
        Selenide.open("https://crm.geekbrains.space/");
        new LoginPage().fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin();
    }

    @Given("^Я перехожу с помощью интерфейса на страницу создания контактного лица$")
    public void goToCreateContraktorsPageUsingInterface() {
        new MainPage().navigationBar.openNavBarItem("Контрагенты");
        new SubMenu().subMenuItemClick("Контактные лица");
        new ContractorsPage().clickCreateContractorRequest();
    }

    @When("^Я заполняю имя лица$")
    public void iFillLastName() {
        new CreateContractorPage().fillLastName("test");
    }

    @And("^Я заполняю фамилию лица$")
    public void iFillFirstName() {
        new CreateContractorPage().fillFirstName("test");
    }

    @And("^Я выбираю организацию$")
    public void iFillOrganization() {
        new CreateContractorPage().touchOrganization();
        new CreateContractorPage().organizationItem.shouldBe(Condition.visible, Duration.ofMillis(10_000));
        new CreateContractorPage().fillOrganization();
    }

    @And("я заполняю должность лица значением {string}")
    public void iFillJobTitle(String name) {
        new CreateContractorPage().fillJobTitle(name);
    }

    @And("^я кликаю на кнопку сохранить и закрыть$")
    public void clickButtonSave() {
        new CreateContractorPage().clickSaveAndCloseButton();
    }

    @Then("^Я вижу сообщение об успехе$")
    public void iSeeSuccsesMessage() {
        new CreateContractorPage().successMessage.shouldBe(Condition.visible, Duration.ofMillis(10_000));
    }
}
