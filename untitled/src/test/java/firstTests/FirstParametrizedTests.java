package firstTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;



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
        $$("#output").find(text(testData)).shouldBe(visible);
    }


    @CsvSource ({
            "text, МоеИмя",
            "email, name@example.com"
    })
    @ParameterizedTest (name = "Отображение типа текста \"{0}\" в отправленной форме")
    void languageTextVisibleInOutputForm (String testData, String visibleResult) {
        //Ввести полное имя
        $$("input").findBy(type(testData)).setValue(visibleResult);

        //Нажать кнопку отправки формы
        $(byText("Submit")).click();

        //check: В отправленной форме отображается имя на нужном языке
        $$("#output").find(text(visibleResult)).shouldBe(visible);
    }
}