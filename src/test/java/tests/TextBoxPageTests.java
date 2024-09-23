package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxPageTests extends TestBase {
    TextBoxPage textBox = new TextBoxPage();
    String userName = "Vlad";
    String userEmail = "test@yandex.ru";
    String userCurrentAddress = "Some street 1";
    String userPermanentAddress = "Another street 1";

    @Test
    void successfulTextBoxTest () {
        textBox.openPage()
                .setUserName(userName)
                .setUserEmail(userEmail)
                .setUserCurrentAddress(userCurrentAddress)
                .setUserPermanentAddress(userPermanentAddress)
                .pressSubmitButton()
                .checkName(userName)
                .checkEmail(userEmail)
                .checkCurrentAddress(userCurrentAddress)
                .checkPermanentAddress(userPermanentAddress);
    }

}