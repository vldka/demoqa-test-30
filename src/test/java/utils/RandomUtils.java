package utils;

import com.github.javafaker.Faker;

import java.time.ZoneId;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static Faker enfaker = new Faker();

    public static void main(String[] args) {
    }

    public static String getMonthBrithday() {
        //перевод даты в LocalDate
        var month = enfaker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonth().toString();
        // Верхний регистр только для первого элемента
        return month.charAt(0) + month.substring(1).toLowerCase();
    }
}