import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step ("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }
    @Step ("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $("button[aria-label='Search or jump to…']").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").pressEnter();

    }
    @Step ("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $("[href='/artl-hub/artl-hub']").click();

    }
    @Step ("Проверяем наличие раздела {section}")
    public void CheckIssuesSectionIsExists(String section) {
        $("#issues-tab").shouldHave(text(section));

    }






}
