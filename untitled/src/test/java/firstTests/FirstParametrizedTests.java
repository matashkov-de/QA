package firstTests;



import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FirstParametrizedTests {


    @DisplayName("Отображение текста в отправленной форме")
    @BeforeEach
    void openPage () {
        Configuration.browserSize = "1920x1600";
        open("https://demoqa.com/text-box");
    }


    @AfterEach
    void closeWebDriver () {
        Selenide.closeWebDriver();
    }

    @ValueSource (strings = {"English", "Русского"})
    @ParameterizedTest (name = "Отображение {0} текста в отправленной форме")
    void textVisibleInOutputForm (String testData) {
        //Ввести полное имя
        $("#userName").setValue(testData);

        //Нажать кнопку отправки формы
        $(byText("Submit")).click();

        //check: В отправленной форме отображается введенное имя
        $$("#name").find(text(testData)).shouldBe(visible);
    }

    @CsvSource ({
            "Букв, МоеИмя",
            "Цифр, 123"
    })
    @ParameterizedTest (name = "Отображение {0}  в отправленной форме")
    void languageTextVisibleInOutputForm (String testData, String visibleResult) {
        //Ввести полное имя
        $("#userName").setValue(testData);

        //Нажать кнопку отправки формы
        $(byText("Submit")).click();

        //check: В отправленной форме отображается имя на нужном языке
        $$("#name").find(text(visibleResult)).shouldBe(visible);
    }
}
