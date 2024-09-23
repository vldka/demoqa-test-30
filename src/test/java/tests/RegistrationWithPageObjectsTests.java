package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        // Тестовые данные
        var firstName = "Vlad";
        var lastName = "Kashkarov";
        var email = "test@yandex.ru";
        var gender = "Male";
        var phone = "8999111111";
        var dayOfBirth = "30";
        var monthOfBirth = "June";
        var yearOfBirth = "2008";
        var subjects = new String[]{"Maths", "English"};
        var hobbies = new String[]{"Sports", "Reading", "Music"};
        var fileName = "tst.jpg";
        var currentAddress = "Some address 1";
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
                .checkResults (firstName + " " + lastName)
                .checkResults (email)
                .checkResults (gender)
                .checkResults (phone)
                .checkResults (dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResults (subjects[0] + ", " + subjects[1])
                .checkResults (hobbies[0] + ", " + hobbies[1] + ", " + hobbies[2])
                .checkResults (fileName)
                .checkResults (currentAddress)
                .checkResults (state + " " + city);
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