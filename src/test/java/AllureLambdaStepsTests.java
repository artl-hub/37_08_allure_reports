import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AllureLambdaStepsTests {
    private static final String REPOSITORY = "artl-hub";
    private static final String ISSUE_SECTION = "Issues";

    @Test
    @Feature("Разделы в репозитории")
    @Story("Взаимодействие с Issue")
    @DisplayName("Проверка наличия раздела Issue ")

    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий", () -> {
            $("button[aria-label='Search or jump to…']").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").pressEnter();
        });

        step("Кликаем по ссылке репозитория", () -> {
            $("[href='/artl-hub/artl-hub']").click();
        });

        step("Проверяем наличие раздела" + ISSUE_SECTION, () -> {
            $("#issues-tab").shouldHave(text(ISSUE_SECTION));
        });
    }
}
