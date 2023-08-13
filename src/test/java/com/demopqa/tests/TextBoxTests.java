package com.demopqa.tests;

import com.demopqa.pages.TextBoxPage;
import com.demopqa.utils.RandomUtils;
import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase {
    private final TextBoxPage textBoxPage = new TextBoxPage();
    private final RandomUtils randomUtils = new RandomUtils();
    private final String textBoxPageUrl = "/text-box";

    @Test
    void testBoxTests() {
        String name = randomUtils.getRandomFirstName() + " " + randomUtils.getRandomLastName(),
                email = randomUtils.getRandomEmail(),
                currentAddress = randomUtils.getRandomAddress(),
                permanentAddress = randomUtils.getRandomAddress();
        textBoxPage
                .openPage(textBoxPageUrl)
                .removeBannerAndFooter()
                .setFullName(name)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submitForm();
        textBoxPage
                .checkThatTextBoxHasText(name)
                .checkThatTextBoxHasText(email)
                .checkThatTextBoxHasText(currentAddress)
                .checkThatTextBoxHasText(permanentAddress);
    }
}
