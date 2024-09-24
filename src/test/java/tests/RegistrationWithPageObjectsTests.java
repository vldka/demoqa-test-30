package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.text.SimpleDateFormat;
import java.util.Locale;

import static utils.RandomUtils.getMonthBrithday;
import static utils.RandomUtils.getRandomGender;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        Faker rufaker = new Faker(new Locale("ru"));
        Faker enfaker = new Faker(new Locale("en-US"));
        // Тестовые данные
        var firstName = rufaker.name().firstName();
        var lastName = rufaker.name().lastName();
        var email = enfaker.internet().emailAddress();
        var gender = getRandomGender();
        var phone = rufaker.phoneNumber().subscriberNumber(10);
        var dayOfBirth = new SimpleDateFormat("d").format(enfaker.date().birthday());
        var monthOfBirth = getMonthBrithday();
        var yearOfBirth = new SimpleDateFormat("yyyy").format(enfaker.date().birthday());
        var subjects = new String[]{"Maths", "English"};
        var hobbies = new String[]{"Sports", "Reading", "Music"};
        var fileName = "tst.jpg";
        var currentAddress = rufaker.address().fullAddress();
        var state = "NCR";
        var city = "Delhi";
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
                .checkResults(subjects[0] + ", " + subjects[1])
                .checkResults(hobbies[0] + ", " + hobbies[1] + ", " + hobbies[2])
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