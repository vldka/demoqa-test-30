package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.text.SimpleDateFormat;
import java.util.Locale;

import static utils.RandomUtils.getMonthBrithday;

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
        var gender = enfaker.options().option("Male", "Female", "Other");
        var phone = rufaker.phoneNumber().subscriberNumber(10);
        var dayOfBirth = new SimpleDateFormat("d").format(enfaker.date().birthday());
        var monthOfBirth = getMonthBrithday();
        var yearOfBirth = new SimpleDateFormat("yyyy").format(enfaker.date().birthday());
        var subjects = enfaker.options().option("Maths", "English");
        var hobbies = enfaker.options().option("Sports", "Reading", "Music");
        var fileName = "tst.jpg";
        var currentAddress = rufaker.address().fullAddress();
        var state = enfaker.options().option("NCR", "Haryana");
        var city = switch (state) {
            case "NCR" -> enfaker.options().option("Delhi", "Gurgaon", "Noida");
            case "Haryana" -> enfaker.options().option("Karnal", "Panipat");
            default -> "";
        };
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