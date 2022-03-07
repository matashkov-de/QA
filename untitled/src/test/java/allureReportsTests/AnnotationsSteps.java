package allureReportsTests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AnnotationsSteps {


    @Step("Открыть github")
    public void openGitHubPage() {
        open("https://github.com/");
    }

    @Step("Ввести в поиске {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").setValue(repo);
        $(".header-search-input").submit();
    }

    @Step("Открыть первую ссылку")
    public void openFirstRepoLink() {
        $(".repo-list li a").click();
    }

    @Step("check: В навигации есть таб с названием {tab}")
    public void checkForVisibleTab(String tab) {
        $(".UnderlineNav-body").shouldHave((text(tab)));
    }
}

