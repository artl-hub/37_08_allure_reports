
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class AllureSelenideTests extends TestBase {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");

        $("button[aria-label='Search or jump to…']").click();
        $("#query-builder-test").sendKeys("artl-hub");
        $("#query-builder-test").pressEnter();
        $("[href='/artl-hub/artl-hub']").click();

        $("#issues-tab").shouldHave(text("Issues"));


//

    }








        }

