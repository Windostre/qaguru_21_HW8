package com.demopqa.tests;

import com.demopqa.pages.RegistrationPage;
import com.demopqa.utils.RandomUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RegistrationFormTests extends TestBase {
    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RandomUtils randomUtils = new RandomUtils();
    private final String registrationPageUrl = "/automation-practice-form";


    @Test
    void registrationFormSuccessTest() {
        String firstName = randomUtils.getRandomFirstName(),
                lastName = randomUtils.getRandomLastName(),
                email = randomUtils.getRandomEmail(),
                gender = randomUtils.getRandomGender(),
                phone = randomUtils.getFakerPhone(),
                subject = randomUtils.getRandomSubject(),
                hobby = randomUtils.getRandomHobby(),
                address = randomUtils.getRandomAddress(),
                day = randomUtils.getRandomDayOfAMonth(),
                month = randomUtils.getRandomMonth(),
                year = randomUtils.getRandomYear();
        registrationPage
                .openPage(registrationPageUrl)
                .waitUntilRegistrationPageIsLoaded()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setUserNumber(phone)
                .selectGender(gender)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadFile("test.jpg")
                .setAddress(address);

        List<String> states = registrationPage.getStates();
        String state = randomUtils.getRandomItemFromList(states);

        registrationPage
                .selectState(state);
        List<String> cities = registrationPage.getCities();
        String city = randomUtils.getRandomItemFromList(cities);
        registrationPage
                .selectCity(city)
                .submitForm()
                .waitModalWindowIsOpened()
                .checkValueNextToColumnInTableInModalWindow("Student Name", firstName + " " + lastName)
                .checkValueNextToColumnInTableInModalWindow("Student Email", email)
                .checkValueNextToColumnInTableInModalWindow("Gender", gender)
                .checkValueNextToColumnInTableInModalWindow("Mobile", phone)
                .checkValueNextToColumnInTableInModalWindow("Date of Birth", day + " " + month + "," + year)
                .checkValueNextToColumnInTableInModalWindow("Subjects", subject)
                .checkValueNextToColumnInTableInModalWindow("Hobbies", hobby)
                .checkValueNextToColumnInTableInModalWindow("Picture", "test.jpg")
                .checkValueNextToColumnInTableInModalWindow("Address", address)
                .checkValueNextToColumnInTableInModalWindow("State and City", state + " " + city);
    }

    @Test
    void registrationFormSuccessMinimalTest() {
        String firstName = randomUtils.getRandomFirstName(),
                lastName = randomUtils.getRandomLastName(),
                email = randomUtils.getRandomEmail(),
                gender = randomUtils.getRandomGender(),
                phone = randomUtils.getFakerPhone();

        registrationPage
                .openPage(registrationPageUrl)
                .waitUntilRegistrationPageIsLoaded()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setUserNumber(phone)
                .selectGender(gender)
                .submitForm()
                .waitModalWindowIsOpened()
                .checkModalWindowHasText(List.of(firstName, lastName, phone, gender));
    }
}
