package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import java.util.Locale;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    private final RandomUtils randomUtils = new RandomUtils();
    @Test
    void successfulRegistrationTest() {
        Faker enfaker = new Faker(new Locale("en-US"));
        // Тестовые данные
        var firstName = randomUtils.getFirsttName();
        var lastName = randomUtils.getLastName();
        var email = randomUtils.getEmail();
        var gender = randomUtils.getGender();
        var phone = randomUtils.getPhone();
        var dayOfBirth = randomUtils.getDayBrithday();
        var monthOfBirth = randomUtils.getMonthBrithday();
        var yearOfBirth = randomUtils.getYearBrithday();
        var subjects = randomUtils.getSubjects();
        var hobbies = randomUtils.getHobbies();
        var fileName = "tst.jpg";
        var currentAddress = randomUtils.getAddress();
        var state = randomUtils.getState();
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

    @Test
    void negativeRegistrationTest() {
        registrationPage
                //Действия
                .openPage()
                .clickButton()
                //Проверка валидаций
                .negativeResults();
    }
}