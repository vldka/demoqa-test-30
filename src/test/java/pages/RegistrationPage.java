package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateCityWrapperInput = $("#stateCity-wrapper"),
            submitInput = $("#submit"),
            responseTableInput = $(".table-responsive"),
            userFormInput = $("form#userForm");

    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Открытие страницы")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    @Step("Заполненение Имени")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Заполненение Фамилии")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Заполненение Email")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Выбор пола")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Заполненение номера телефона")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Заполненение Даты рождения")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Выбор Предмета")
    public RegistrationPage setSubjects(String values) {

        subjectsInput.setValue(values).pressEnter();

        return this;
    }

    @Step("Выбор Хобби")
    public RegistrationPage setHobbies(String values) {

        hobbiesInput.$(byText(values)).click();

        return this;
    }

    @Step("Загрузка изображения")
    public RegistrationPage setPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);

        return this;
    }

    @Step("Заполнение Адреса")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    @Step("Выбор штата")
    public RegistrationPage setState(String value) {

        stateInput.click();
        stateCityWrapperInput.$(byText(value)).click();

        return this;
    }

    @Step("Выбор города")
    public RegistrationPage setCity(String value) {

        cityInput.click();
        stateCityWrapperInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage clickButton() {

        submitInput.click();

        return this;
    }

    @Step("Проверка заполнения {value}")
    public RegistrationPage checkResults(String value) {
        responseTableInput.shouldHave(text(value));
        return this;
    }

    @Step("Проверка валидации")
    public RegistrationPage negativeResults() {
        userFormInput.shouldHave(attribute("class", "was-validated"));
        return this;
    }
}