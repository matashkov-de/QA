package firstTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTestWithPageObj {

    @Test
    void successFillTest () {
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");

        // Заполнение формы
        new RegistrationPage().setPageLoadCheck("Practice Form");
        new RegistrationPage().setFirstName("My");
        new RegistrationPage().setLastName("Name");
        new RegistrationPage().setUserEmail("myEmail@gmail.com");
        new RegistrationPage().setUserGender("Male");
        new RegistrationPage().setUserNumber("1234567890");
        new RegistrationPage().setDateOfBirth("1999", "December","31");
        new RegistrationPage().setSubject("Ma", "Maths");
        new RegistrationPage().setHobby("Sports");
        new RegistrationPage().uploadPicture("src/test/resources/swef.png");
        new RegistrationPage().setCurrentAddress("MyAdress 14-88");
        new RegistrationPage().setStateCity("NCR", "Delhi");
        new RegistrationPage().clickSubmit();

        //Проверка отправленной формы

        $(".table-responsive").shouldHave(
                text("My Name"),
                text("myEmail@gmail.com"),
                text("Male"),
                text("1234567890"),
                text("Maths"),
                text("Sports"),
                text("swef.png"),
                text("MyAdress 14-88"),
                text("NCR"),
                text("Delhi")
                );
    }
}