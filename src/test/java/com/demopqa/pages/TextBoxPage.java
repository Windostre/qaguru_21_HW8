package com.demopqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

/**
 * Text Box Form description
 * <a href="https://demoqa.com/text-box">...</a>
 */

public class TextBoxPage {

    SelenideElement fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            textBox = $("#output");

    public TextBoxPage openPage(String url) {
        Selenide.open(url);
        return this;
    }

    public TextBoxPage removeBannerAndFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName(String fullName) {
        fullNameInput.setValue(fullName);
        return this;
    }

    public TextBoxPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public TextBoxPage setPermanentAddress(String address) {
        permanentAddressInput.setValue(address);
        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    public TextBoxPage checkThatTextBoxHasText(String expectedText) {
        textBox.shouldHave(Condition.text(expectedText));
        return this;
    }
}
