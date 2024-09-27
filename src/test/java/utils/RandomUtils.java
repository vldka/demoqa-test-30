package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class RandomUtils {
    Faker enfaker = new Faker();
    Faker rufaker = new Faker(new Locale("ru"));

    public String firstName = rufaker.name().firstName();
    public String lastName = rufaker.name().lastName();
    public String email = enfaker.internet().emailAddress();
    public String gender = enfaker.options().option("Male", "Female", "Other");
    public String phone = rufaker.phoneNumber().subscriberNumber(10);
    public String monthBrithday = enfaker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public String yearBrithday = new SimpleDateFormat("yyyy").format(enfaker.date().birthday());
    public String address = rufaker.address().fullAddress();
    public String state = enfaker.options().option("NCR", "Haryana");
    public String subjects = enfaker.options().option("Maths", "English");
    public String hobbies = enfaker.options().option("Sports", "Reading", "Music");

    public static void main(String[] args) {
    }


    public String getDayBrithday() {
        var year = Integer.parseInt(yearBrithday);
        if (monthBrithday.equals("February")) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                return Integer.toString(enfaker.number().numberBetween(1, 29));
            } else {
                return Integer.toString(enfaker.number().numberBetween(1, 28)); // Невисокосный год
            }
        } else if (monthBrithday.equals("April") || monthBrithday.equals("June") ||
                monthBrithday.equals("September") || monthBrithday.equals("November")) {
            return Integer.toString(enfaker.number().numberBetween(1, 30));
        } else {
            return Integer.toString(enfaker.number().numberBetween(1, 31));
        }
    }


    public String getCity(String state) {

        return switch (state) {
            case "NCR" -> enfaker.options().option("Delhi", "Gurgaon", "Noida");
            case "Haryana" -> enfaker.options().option("Karnal", "Panipat");
            default -> "";
        };
    }
}