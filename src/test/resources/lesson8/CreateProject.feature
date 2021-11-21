Feature: create contractor request

  Background:
    Given I am authorized

  Scenario Outline:
    Given Я перехожу с помощью интерфейса на страницу создания контактного лица
    When Я заполняю имя лица
    And Я заполняю фамилию лица
    And Я выбираю организацию
    And я заполняю должность лица значением '<name>'
    And я кликаю на кнопку сохранить и закрыть
    Then Я вижу сообщение об успехе
    Examples:
    | name  |
    | QAA   |
    | QA1   |
