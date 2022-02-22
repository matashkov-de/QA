package firstTests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class GitHubJunit5ExampleTest {

    @Test
    void gitHubSoftAssertionsShouldHaveJunit5Example () {

        //Открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        //Перейти в раздел Wiki проекта
        $("#wiki-tab").click();

        //Развернуть весь список страниц (Pages)
        $("#wiki-pages-box").$(byTagName("button")).click();

        //check:  В списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));

        //Открыть страницу SoftAssertions
        $(byText("SoftAssertions")).click();

        //check: На странице есть пример кода для JUnit5
        $$("ol").findBy(text("Using JUnit5 extend test class")).sibling(0)
                .shouldHave(text("@Test"));
    }
}
