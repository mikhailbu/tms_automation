package test;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static helpers.TestValues.*;
import static helpers.TestValues.TEST_NAME_SHORT_PROJECT;

public class CreateTestPlanTest extends BaseTest {
    @Test
    @Feature("Тестироване сущности 'TEST_PLAN'")
    @Owner("buyanovMV")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тестироване создания новой сущности 'TEST_PLAN'")
    public void createTestPlanTest(){
        loginPage.openPage(BASE_URL, LOGIN_URL)
                .checkTitle("Вход в учетную запись", "h4")
                .setEmail(TEST_EMAIL)
                .setPasswordFirst(TEST_PASSWORD);
        workspacePage.switchSideMenu("Мои пространства")
                .selectWorkspace(TEST_NAME_WORKSPACES);
        $$("td.align-middle div div").findBy(text(TEST_NAME_SHORT_PROJECT)).doubleClick();
        $("div.left-sidebar__menu-item[title='Тест-планы']").click();

        testPlanPage.clickBtn("Добавить тест-план")
                .setNameTestPlan(TEST_TEST_PLAN_NAME);
        executeJavaScript("document.querySelector('footer.site-footer').style.display = 'none'");
        testPlanPage.setDescriptionTestPlan("Информация ", TEST_TEST_PLAN_TITLE_INFO)
                .selectOptionMilestone(TEST_MILESTONE_NAME);
        $x("//button[text()=' Добавить тест-кейсы ']").click();
        testPlanPage.selectTestCase(TEST_CASE_NAME);
        $x("//button[text()=' Готово ']").click();
        // проверка количества выбранных тест-кейсов
        testPlanPage.clickBtn("Сохранить и перейти к записи");

        testPlanPage.checkTitle("h3",TEST_NAME_PROJECT)
                .checkCardBodyTestPlanName(TEST_TEST_PLAN_NAME,TEST_TEST_PLAN_NAME)
                .checkCardBodyTestPlanMilestone("Milestone:",TEST_MILESTONE_NAME)
                .checkCardBodyTestPlanDescription("Описание:",TEST_TEST_PLAN_TITLE_INFO)
                .checkCardBodyTestPlanSelectionName("h5",TEST_CASE_BASIC_SECTION)
                .checkCardBodyTestPlanNameTestCase(TEST_CASE_NAME,TEST_CASE_NAME);

        executeJavaScript("window.open()");
        switchTo().window(1);
        open(PROJECT_BASE_URL + PROJECT_PLANS_URL);
        testPlanPage.deleteTestPlan(TEST_TEST_PLAN_NAME);








    }
}
