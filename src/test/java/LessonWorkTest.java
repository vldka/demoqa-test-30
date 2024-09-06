import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LessonWorkTest {
    @BeforeAll
    static void openPage() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterAll
    static void closeWindow() {
        WebDriverRunner.closeWindow();
    }

    @Test
    void readTestForm() {
        //Действия
        open("/automation-practice-form");
        $("[id = firstName]").setValue("Vlad");
        $("[id = lastName]").setValue("kashkarov");
        $("[id = userEmail]").setValue("test@yandex.ru");
        $("[id = userNumber]").setValue("8999111111");
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
        $("[id = uploadPicture]").uploadFromClasspath("tst.jpg");
        $("[id = currentAddress]").setValue("Krasnodar st. Severnaya 200 h.1");
        $("[id = state]").click();
        $("[id = react-select-3-option-0]").click();
        $("[id = city]").click();
        $("[id = react-select-4-option-0]").click();
        $("[id = submit]").click();

        // Проверки
        $(".table-responsive").shouldHave(text("Vlad kashkarov"));
        $(".table-responsive").shouldHave(text("test@yandex.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8999111111"));
        $(".table-responsive").shouldHave(text("12 June,1996"));
        $(".table-responsive").shouldHave(text("Maths, English"));
        $(".table-responsive").shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").shouldHave(text("tst.jpg"));
        $(".table-responsive").shouldHave(text("Krasnodar st. Severnaya 200 h.1"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }

}
