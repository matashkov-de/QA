package FirstTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstAutoTests {

    @Test
    void successFillTest () {
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");

        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("My");
        $("#lastName").setValue("Name");
        $("#userEmail").setValue("myEmail@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__month-select").selectOption("December");
        $(byText("31")).click();
        $("#subjectsInput").setValue("Math");
        $(byText("Maths")).click();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/java/data/swef.png"));
        $("#currentAddress").setValue("MyAdress 14-88");
        $("#state").scrollTo();
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();
        $("#submit").click();

    }
}



