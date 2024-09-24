package utils;

import com.github.javafaker.Faker;

import java.time.ZoneId;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static Faker enfaker = new Faker();

    public static void main(String[] args) {
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public static String getMonthBrithday() {

        var month = enfaker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonth().toString();

        return month.charAt(0) + month.substring(1).toLowerCase();
    }
}