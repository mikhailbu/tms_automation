package test;

import helpers.StringModifier;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static helpers.TestValues.*;

public class CreateMilestoneTest extends BaseTest {
    @Test
    @Feature("Тестироване сущности 'MILESTONE'")
    @Owner("buyanovMV")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тестироване создания новой сущности 'MILESTONE'")

    void createMilestoneTest() {

        loginPage.openPage(BASE_URL, LOGIN_URL)
                .checkTitle("Вход в учетную запись", "h4")
                .setEmail(TEST_EMAIL)
                .setPasswordFirst(TEST_PASSWORD);
        workspacePage.switchSideMenu("Мои пространства")
                .selectWorkspace(TEST_NAME_WORKSPACES);
        $$("td.align-middle div div").findBy(text(TEST_NAME_SHORT_PROJECT)).doubleClick();
        $("div.left-sidebar__menu-item[title='Milestones']").click();

        TEST_ACTUAL_DATE_DD_MM_YYYY = StringModifier.getActualDateDayMonthYear();
        milestonePage.clickBtn("Добавить milestone")
                .setNameMilestone(TEST_MILESTONE_NAME)
                .setDescriptionMilestone("Информация ", TEST_MILESTONE_TITLE_INFO)
                .setDateMilestone(TEST_ACTUAL_DATE_DD_MM_YYYY);
        //todo добавить статус
        executeJavaScript("document.querySelector('footer.site-footer').style.display = 'none'");
        TEST_ACTUAL_DATE_DD_MM_YYYY_HM = StringModifier.getActualDateDayMonthYearHourMinute();
        milestonePage.clickBtn("Сохранить и перейти к записи")
                .checkTitle("div.container-fluid h5", TEST_MILESTONE_NAME)
                .checkDescriptionTitleMilestone("Информация", TEST_MILESTONE_TITLE_INFO)
                .checkLoginAuthorMilestone(TEST_LOGIN)
                .checkInfoMilestone("Статус:", "-")
                .checkInfoMilestone("Дата создания:", TEST_ACTUAL_DATE_DD_MM_YYYY_HM)
                .checkInfoMilestone("Дата завершения:", TEST_ACTUAL_DATE_DD_MM_YYYY);

        executeJavaScript("window.open()");
        switchTo().window(1);
        open(PROJECT_BASE_URL + PROJECT_MILESTONES_URL);
        milestonePage.deleteTestMilestone("NameMilestone");
    }

}


