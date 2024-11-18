package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.RegistrationPage;
import utils.RandomUtils;

@DisplayName("Проверки на Practice Form")
public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    private final RandomUtils randomUtils = new RandomUtils();

    @Test
    @DisplayName("Проверка заполнения формы 'Practice Form'")
    void successfulRegistrationTest() {
        // Тестовые данные
        var firstName = randomUtils.firstName;
        var lastName = randomUtils.lastName;
        var email = randomUtils.email;
        var gender = randomUtils.gender;
        var phone = randomUtils.phone;
        var dayOfBirth = randomUtils.getDayBrithday();
        var monthOfBirth = randomUtils.monthBrithday;
        var yearOfBirth = randomUtils.yearBrithday;
        var subjects = randomUtils.subjects;
        var hobbies = randomUtils.hobbies;
        var fileName = "tst.jpg";
        var currentAddress = randomUtils.address;
        var state = randomUtils.state;
        var city = randomUtils.getCity(state);
        //Действия по заполнению
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phone)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(fileName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickButton();
        //проверки
        registrationPage
                .checkResults(firstName + " " + lastName)
                .checkResults(email)
                .checkResults(gender)
                .checkResults(phone)
                .checkResults(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResults(subjects)
                .checkResults(hobbies)
                .checkResults(fileName)
                .checkResults(currentAddress)
                .checkResults(state + " " + city);
    }
    @ValueSource(strings = {"NCR", "Haryana"})
    @Tag("fieldCheck")
    @ParameterizedTest(name = "Проверка наполнения полей по Штату {0}")
    void successfulCheckStateValueTest(String state) {
        // Тестовые данные
        var firstName = randomUtils.firstName;
        var lastName = randomUtils.lastName;
        var email = randomUtils.email;
        var gender = randomUtils.gender;
        var phone = randomUtils.phone;
        var dayOfBirth = randomUtils.getDayBrithday();
        var monthOfBirth = randomUtils.monthBrithday;
        var yearOfBirth = randomUtils.yearBrithday;
        var subjects = randomUtils.subjects;
        var hobbies = randomUtils.hobbies;
        var fileName = "tst.jpg";
        var currentAddress = randomUtils.address;
        var city = randomUtils.getCity(state);
        //Действия по заполнению
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phone)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(fileName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickButton();
        //проверки
        registrationPage
                .checkResults(firstName + " " + lastName)
                .checkResults(email)
                .checkResults(gender)
                .checkResults(phone)
                .checkResults(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResults(subjects)
                .checkResults(hobbies)
                .checkResults(fileName)
                .checkResults(currentAddress)
                .checkResults(state + " " + city);
        Selenide.sleep(10000);
    }

    @CsvSource(value = {
            "NCR| Delhi",
            "Haryana| Karnal"},delimiter = '|')
    @Tag("fieldCheck")
    @ParameterizedTest(name = "Проверка наполнения полей по Штату {0} и городу {1}")
    void successfulCheckStateCityCsvTest(String state,String city) {
        // Тестовые данные
        var firstName = randomUtils.firstName;
        var lastName = randomUtils.lastName;
        var email = randomUtils.email;
        var gender = randomUtils.gender;
        var phone = randomUtils.phone;
        var dayOfBirth = randomUtils.getDayBrithday();
        var monthOfBirth = randomUtils.monthBrithday;
        var yearOfBirth = randomUtils.yearBrithday;
        var subjects = randomUtils.subjects;
        var hobbies = randomUtils.hobbies;
        var fileName = "tst.jpg";
        var currentAddress = randomUtils.address;
        //Действия по заполнению
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phone)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(fileName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickButton();
        //проверки
        registrationPage
                .checkResults(firstName + " " + lastName)
                .checkResults(email)
                .checkResults(gender)
                .checkResults(phone)
                .checkResults(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResults(subjects)
                .checkResults(hobbies)
                .checkResults(fileName)
                .checkResults(currentAddress)
                .checkResults(state + " " + city);
    }

    @CsvFileSource(resources = "/test_data/successfulCheckStateCityCsvFile.csv",delimiter = '|')
    @Tag("fieldCheck")
    @ParameterizedTest(name = "Проверка наполнения полей из csv файла по Штату {0} и городу {1}")
    void successfulCheckStateCityCsvFileTest(String state,String city) {
        // Тестовые данные
        var firstName = randomUtils.firstName;
        var lastName = randomUtils.lastName;
        var email = randomUtils.email;
        var gender = randomUtils.gender;
        var phone = randomUtils.phone;
        var dayOfBirth = randomUtils.getDayBrithday();
        var monthOfBirth = randomUtils.monthBrithday;
        var yearOfBirth = randomUtils.yearBrithday;
        var subjects = randomUtils.subjects;
        var hobbies = randomUtils.hobbies;
        var fileName = "tst.jpg";
        var currentAddress = randomUtils.address;
        //Действия по заполнению
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phone)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(fileName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickButton();
        //проверки
        registrationPage
                .checkResults(firstName + " " + lastName)
                .checkResults(email)
                .checkResults(gender)
                .checkResults(phone)
                .checkResults(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResults(subjects)
                .checkResults(hobbies)
                .checkResults(fileName)
                .checkResults(currentAddress)
                .checkResults(state + " " + city);
    }
    @Test
    @DisplayName("Негативная проверка обязательных полей")
    void negativeRegistrationTest() {
        registrationPage
                //Действия
                .openPage()
                .clickButton()
                //Проверка валидаций
                .negativeResults();
    }
}