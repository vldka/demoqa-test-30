package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    private SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            resultName = $("#output #name"),
            resultEmail = $("#output #email"),
            resultCurrentAddressInput = $("#output #currentAddress"),
            resultPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage openPage () {
        open("/text-box");

        return this;
    }

    public TextBoxPage setUserName (String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserCurrentAddress (String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserPermanentAddress (String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage pressSubmitButton () {
        submitButton.click();

        return this;
    }

    public TextBoxPage checkName (String value) {
        resultName.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkEmail (String value) {
        resultEmail.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkCurrentAddress (String value) {
        resultCurrentAddressInput.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkPermanentAddress (String value) {
        resultPermanentAddress.shouldHave(text(value));

        return this;
    }



}