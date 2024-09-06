import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LessonWork {
    @BeforeAll
    static void openPage() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    static void closeWindow() {
        WebDriverRunner.closeWindow();
    }

    @Test
    void readTestForm() {
        open("/automation-practice-form");
        $("[id = firstName]").setValue("Vlad");
        $("[id = lastName]").setValue("kashkarov");
        $("[id = userEmail]").setValue("test@yandex.ru");
        $("[id = userNumber]").setValue("89991111111");
        $("[id = genterWrapper]").find(".custom-control-label").click();
        $("[id = dateOfBirthInput]").sendKeys(Keys.CONTROL + "A");
        $("[id = dateOfBirthInput]").sendKeys("6.12.1996");
        $("[id = dateOfBirthInput]").pressEnter();
        $("[id = subjectsInput]").setValue("Math");
        $("[id = react-select-2-option-0]").click();
        $("[id = subjectsInput]").setValue("English");
        $("[id = react-select-2-option-0]").click();
        $("[id = hobbiesWrapper]").find("[for=hobbies-checkbox-1]").click();
        $("[id = hobbiesWrapper]").find("[for=hobbies-checkbox-2]").click();
        $("[id = hobbiesWrapper]").find("[for=hobbies-checkbox-3]").click();
        $("[id = uploadPicture]").uploadFile(new File("src/test/resources/tst.jpg"));
        $("[id = currentAddress]").setValue("Krasnodar st. Severnaya 200 h.1");
        $("[id = state]").click();
        $("[id = react-select-3-option-0]").click();
        $("[id = city]").click();
        $("[id = react-select-4-option-0]").click();
        Selenide.sleep(10000);
        $("[id = submit]").click();
    }

}
