package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
     Faker enfaker = new Faker();
     Faker rufaker = new Faker(new Locale("ru"));
    public static void main(String[] args) {
    }

    public String getMonthBrithday() {
       return enfaker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public String getDayBrithday() {

        return String.format("%02d", enfaker.number().numberBetween(1,28));
    }

    public String getYearBrithday() {

        return new SimpleDateFormat("yyyy").format(enfaker.date().birthday());
    }

    public String getPhone() {

        return rufaker.phoneNumber().subscriberNumber(10);
    }

    public String getGender() {

        return enfaker.options().option("Male", "Female", "Other");
    }

    public String getEmail() {

        return enfaker.internet().emailAddress();
    }

    public String getAddress() {

        return rufaker.address().fullAddress();
    }
    public String getLastName() {

        return rufaker.name().lastName();
    }

    public String getFirsttName() {

        return rufaker.name().firstName();
    }

    public String getState() {

        return enfaker.options().option("NCR", "Haryana");
    }

    public String getCity(String state) {

        return switch (state) {
            case "NCR" -> enfaker.options().option("Delhi", "Gurgaon", "Noida");
            case "Haryana" -> enfaker.options().option("Karnal", "Panipat");
            default -> "";
        };
    }

    public String getSubjects() {

        return enfaker.options().option("Maths", "English");
    }

    public String getHobbies() {

        return enfaker.options().option("Sports", "Reading", "Music");
    }
}