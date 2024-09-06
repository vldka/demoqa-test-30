import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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

    String gender;
    String state;
    String city;


    @Test
    void readTestForm() {
        //Действия
        open("/automation-practice-form");
        $("#firstName").setValue("Vlad");
        $("#lastName").setValue("kashkarov");
        $("#userEmail").setValue("test@yandex.ru");
        $("#userNumber").setValue("8999111111");
        $("#genterWrapper").find(".custom-control-label").click();
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "A");
        $("#dateOfBirthInput").sendKeys("6.12.1996");
        $("#dateOfBirthInput").pressEnter();
        $("#subjectsInput").setValue("Math");
        $("#react-select-2-option-0").click();
        $("#subjectsInput").setValue("English");
        $("#react-select-2-option-0").click();
        $("#hobbiesWrapper").find("[for=hobbies-checkbox-1]").click();
        $("#hobbiesWrapper").find("[for=hobbies-checkbox-2]").click();
        $("#hobbiesWrapper").find("[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFromClasspath("tst.jpg");
        $("#currentAddress").setValue("Krasnodar st. Severnaya 200 h.1");
        $("#state").click();
        state = $("#react-select-3-option-0").getText();
        $("#react-select-3-option-0").click();
        $("#city").click();
        city = $("#react-select-4-option-0").getText();
        $("#react-select-4-option-0").click();
        $("#submit").click();

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
        $(".table-responsive").shouldHave(text(state + " " + city));
    }

}
