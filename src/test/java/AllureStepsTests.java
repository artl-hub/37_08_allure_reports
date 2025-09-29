import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class AllureStepsTests extends TestBase {
    private static final String REPOSITORY = "artl-hub";

    @Test
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

        step("Проверяем наличие раздела \"Issues\"", () -> {
            $("#issues-tab").shouldHave(text("Issues"));
        });











//

    }


}

