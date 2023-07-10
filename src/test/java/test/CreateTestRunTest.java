package test;

import helpers.StringModifier;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static helpers.TestValues.*;
import static helpers.TestValues.TEST_NAME_SHORT_PROJECT;

public class CreateTestRunTest extends BaseTest {

    @Test
    void createTestRunTest() {

        loginPage.openPage(BASE_URL, LOGIN_URL)
                .checkTitle("Вход в учетную запись", "h4")
                .setEmail(TEST_EMAIL)
                .setPasswordFirst(TEST_PASSWORD);
        workspacePage.switchSideMenu("Мои пространства")
                .selectWorkspace(TEST_NAME_WORKSPACES);
        $$("td.align-middle div div").findBy(text(TEST_NAME_SHORT_PROJECT)).doubleClick();
        $("div.left-sidebar__menu-item[title='Тест-раны']").click();

        testRunPage.clickBtn("Добавить тест-ран")
                .setNameTestRun(TEST_TEST_RUN_NAME)
                .setDescriptionTestRun("Информация ",TEST_TEST_RUN_TITLE_INFO)
                .selectOptionMilestone(TEST_MILESTONE_NAME)
                .selectOptionEnvironment("Production")
                .selectOptionResponsible(0);
        executeJavaScript("document.querySelector('footer.site-footer').style.display = 'none'");
        $x("//button[text()=' Добавить тест-кейсы ']").click();
        testRunPage.selectTestCase(TEST_CASE_NAME);
        $x("//button[text()=' Готово ']").click();
        // проверка количества выбранных тест-кейсов
        TEST_ACTUAL_DATE_DD_MM_YYYY_HM = StringModifier.getActualDateDayMonthYearHourMinute();
        testRunPage.clickBtn("Сохранить и перейти к записи");
        testRunPage.checkTitle("h3",TEST_TEST_RUN_NAME);
        testRunPage.checkTestCase(TEST_CASE_NAME);
        testRunPage.checkInfoTestRun("Дата создания:",TEST_ACTUAL_DATE_DD_MM_YYYY_HM);
        testRunPage.checkResponsiblePersonTestRun("Ответственный:","@latest_0001");



    }

}
