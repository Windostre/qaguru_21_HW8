package com.demopqa.utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.time.Month;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    private final Faker fakerRus = new Faker(new Locale("ru"));
    private final Faker faker = new Faker();
    private final Random random = new Random();

    public String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb = sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public String getRandomEmail(int len) {
        return getRandomString(len) + '@' + getRandomString(5) + '.' + getRandomString(3);
    }

    public int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public String getRandomPhone() {
        return String.format("+%s (%s) - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999), getRandomInt(10, 99), getRandomInt(10, 99));
    }

    public String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    public String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);
        return array[index];
    }

    public String getRandomFirstName() {
        return fakerRus.name().firstName();
    }

    public String getRandomLastName() {
        return fakerRus.name().lastName();
    }

    public String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String getFakerPhone() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getRandomSubject() {
        String[] subjects = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"};
        return faker.options().option(subjects);
    }

    public String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    public String getRandomAddress() {
        return fakerRus.address().streetAddress(true);
    }

    public String getRandomItemFromList(List<String> elements) {
        return fakerRus.options().nextElement(elements);
    }

    public String getRandomDayOfAMonth() {
        int day = faker.number().numberBetween(1, 29);
        return (day < 10) ? "0" + day : String.valueOf(day);
    }

    public String getRandomMonth() {
        Month[] months = Month.values();
        int index = random.nextInt(months.length);
        String monthName = months[index].name();
        return monthName.substring(0, 1).toUpperCase() + monthName.substring(1).toLowerCase();
    }

    public String getRandomYear() {
        int year = faker.number().numberBetween(1900, 2023);
        return String.valueOf(year);
    }
}
