package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    private final RandomUtils randomUtils = new RandomUtils();

    @Test
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