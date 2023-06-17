package test;

import helpers.StringModifier;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static helpers.TestValues.*;

public class CreateMilestoneTest extends BaseTest {
    @Test
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
                .setNameMilestone("NameMilestone")
                .setDescriptionMilestone("Информация ", "DescMilestone")
                .setDateMilestone(TEST_ACTUAL_DATE_DD_MM_YYYY);
        executeJavaScript("document.querySelector('footer.site-footer').style.display = 'none'");
        TEST_ACTUAL_DATE_DD_MM_YYYY_HM = StringModifier.getActualDateDayMonthYearHourMinute();
        milestonePage.clickBtn("Сохранить и перейти к записи")
                .checkTitle("div.container-fluid h5", "NameMilestone")
                .checkDescriptionTitleMilestone("Информация", "DescMilestone")
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
//todo дописать проверки, удаление


