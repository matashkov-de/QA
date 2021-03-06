package allureReportsTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ListenerTest {

    private static final String searchValue = "Selenide";
    private static final String visibleTabs = "Issues";
    @Test
    public void firstIssueSelenideNameCheck() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        //Открыть  главную страницу github
        open("https://github.com/");

        //Перейти в поле ввода и ввести Selenide
        $(".header-search-input").setValue(searchValue);
        $(".header-search-input").submit();

        //Открыть первую ссылку
        $(".repo-list li a").click();

        //Перейти на таб Issues
        $("#issues-tab").click();

        //check: check: В навигации есть таб с названием Issues
        $(".UnderlineNav-body").shouldHave((text(visibleTabs)));
    }

}
