package allureReportsTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;


public class WebStepsTest {

    public static final String repo = "Selenide";
    public static final String tab = "Issues";


    @Test
    void webStepsAllureTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        AnnotationsSteps annotationsSteps = new AnnotationsSteps();

        annotationsSteps.openGitHubPage();
        annotationsSteps.searchForRepository(repo);
        annotationsSteps.openFirstRepoLink();
        annotationsSteps.checkForVisibleTab(tab);
    }
}
