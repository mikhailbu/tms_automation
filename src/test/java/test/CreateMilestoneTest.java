package test;

import helpers.StringModifier;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static helpers.TestValues.*;

public class CreateMilestoneTest extends BaseTest {

    @Test
    @Tag("milestone")
    @Feature("Тестироване сущности 'MILESTONE'")
    @Owner("buyanovMV")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тестироване создания новой сущности 'MILESTONE'")

    void createNewMilestoneTest() {
        LoginTest loginTest = new LoginTest();
        loginTest.loginAccount();

        CreateProjectTest createProjectTest = new CreateProjectTest();
        createProjectTest
                .cleanOldProject();
        switchTo().window(0);
        createProjectTest
                .createProject(
                        TEST_NAME_PROJECT,
                        TEST_NAME_SHORT_PROJECT,
                        TEST_NAME_WORKSPACES);

        $("div.left-sidebar__menu-item[title='Milestones']").click();
        createMilestone();
        checkMilestone();
        cleanOldMilestone(1);

    }


    void createMilestone() {
        TEST_ACTUAL_DATE_DD_MM_YYYY = StringModifier.getActualDateDayMonthYear();
        milestonePage.clickBtn("Добавить milestone")
                .setNameMilestone(TEST_MILESTONE_NAME)
                .setDescriptionMilestone("Информация ", TEST_MILESTONE_TITLE_INFO)
                .setDateMilestone(TEST_ACTUAL_DATE_DD_MM_YYYY);
        //todo добавить статус
//        executeJavaScript("document.querySelector('footer.site-footer').style.display = 'none'");
        TEST_ACTUAL_DATE_DD_MM_YYYY_HM = StringModifier.getActualDateDayMonthYearHourMinute();
        milestonePage.clickBtn("Сохранить и перейти к записи");
    }
    void checkMilestone(){
        milestonePage.checkTitle("div.container-fluid h5", TEST_MILESTONE_NAME)
                .checkDescriptionTitleMilestone("Информация", TEST_MILESTONE_TITLE_INFO)
                .checkLoginAuthorMilestone(TEST_LOGIN)
                .checkInfoMilestone("Статус:", "-")
                .checkInfoMilestone("Дата создания:", TEST_ACTUAL_DATE_DD_MM_YYYY_HM)
                .checkInfoMilestone("Дата завершения:", TEST_ACTUAL_DATE_DD_MM_YYYY);
    }

    void openMenuMilestone(int numberTabSwitch){
        executeJavaScript("window.open()");
        switchTo().window(numberTabSwitch);
        open(PROJECT_BASE_URL + PROJECT_MILESTONES_URL);
    }
    void cleanOldMilestone(int numberTabSwitch){
        openMenuMilestone(numberTabSwitch);
        milestonePage.deleteTestMilestone("Новый Milestone");

    }

}


