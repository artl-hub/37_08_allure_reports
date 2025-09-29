import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AllureStepsTests extends TestBase {
    private static final String REPOSITORY = "artl-hub";
    private static final String ISSUE_SECTION = "Issues";

    @Test
    @Feature("Разделы в репозитории")
    @Story("Взаимодействие с Issue")
    @DisplayName("Проверка наличия раздела Issue ")

    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();


        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.CheckIssuesSectionIsExists(ISSUE_SECTION);
    }


//


}

