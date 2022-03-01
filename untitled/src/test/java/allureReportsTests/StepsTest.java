package allureReportsTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class StepsTest {

    private static final String searchValue = "Selenide";
    private static final String visibleTab = "rurgu";

    @Test
    public void firstIssueSelenideNameCheckWithSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть github", () -> {
            open("https://github.com/");
        });

        step("Ввести в поиске Selenide", () -> {
            $(".header-search-input").setValue(searchValue);
            $(".header-search-input").submit();
        });

        step("Открыть первую ссылку", () -> {
            $(".repo-list li a").click();
        });


        step("check: В навигации есть таб с названием Issues", () -> {
            $(".UnderlineNav-body").shouldHave((text(visibleTab)));
        });
}
}
