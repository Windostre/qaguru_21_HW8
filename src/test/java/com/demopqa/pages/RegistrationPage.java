package com.demopqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

/**
 * Student Registration Form description
 * <a href="https://demoqa.com/automation-practice-form">...</a>
 */
public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    SelenideElement firstNameInput = $("#firstName"),  //убарть лишние selenide element
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            genderRadioButton = $("#genterWrapper"),
            submitButton = $("#submit"),
            modalWindow = $(".modal-dialog"),
            modalWindowHeader = $("#example-modal-sizes-title-lg"),
            tableInModalWindow = $(".table-responsive"),
            subjectInput = $("#subjectsInput"),
            hobbiesCheckBox = $("#hobbiesWrapper"),
            addressInput = $("#currentAddress"),
            stateDropDown = $("#state"),
            cityDropDown = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            dateOfBirthInput = $("#dateOfBirthInput");

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage selectGender(String gender) {
        genderRadioButton.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbiesCheckBox.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    public RegistrationPage waitModalWindowIsOpened() {
        modalWindow.should(Condition.appear);
        modalWindowHeader.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationPage checkModalWindowHasText(List<String> texts) {
        texts.forEach(values -> tableInModalWindow.shouldHave(text(values)));
        return this;
    }

    public RegistrationPage checkValueNextToColumnInTableInModalWindow(String columnName, String expectedValue) {
        tableInModalWindow.$(byText(columnName)).sibling(0)
                .shouldHave(text(expectedValue));
        return this;
    }

    public RegistrationPage openPage(String url) {
        Selenide.open(url);
        return this;
    }

    public RegistrationPage removeBannerAndFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage waitUntilRegistrationPageIsLoaded() {
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage uploadFile(String fileName) {
        $("#uploadPicture").uploadFromClasspath("files/jpg/" + fileName);
        return this;
    }

    public RegistrationPage selectState(String state) {
        stateDropDown.click();
        stateCityWrapper.$(byText(state)).shouldBe(visible).click();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        cityDropDown.click();
        stateCityWrapper.$(byText(city)).click();
        return this;
    }

    public List<String> getStates() {
        stateDropDown.click();
        List<String> states = stateCityWrapper.$$("div[id^='react-select']").texts();
        stateDropDown.click();
        return states;

    }

    public List<String> getCities() {
        cityDropDown.click();
        List<String> cities = cityDropDown.$$("div[id^='react-select']").texts();
        cityDropDown.click();
        return cities;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }
}
