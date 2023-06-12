package test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static helpers.TestValues.*;

public class CreateTestCaseTest extends BaseTest {
    @Test
    void createTestCase() {
        loginPage.openPage(BASE_URL, LOGIN_URL)
                .checkTitle("Вход в учетную запись", "h4")
                .setEmail(TEST_EMAIL)
                .setPasswordFirst(TEST_PASSWORD);
        workspacePage.switchSideMenu("Мои пространства")
                .selectWorkspace(TEST_NAME_WORKSPACES);
        $$("td.align-middle div div").findBy(text(TEST_NAME_SHORT_PROJECT)).doubleClick();
        casesPage.clickBtn("+ Раздел");
        casesPage.checkTitle( "div.modal-simple__content h5", "Новый раздел");
        casesPage.setNameSection(TEST_NAME_BASIC_SECTION)
                .selectOptionSection("Корневой раздел")
                .setDescriptionSection(TEST_BODY)
                .clickBtn("Сохранить")
                .checkTitle("div.cases__content h5",TEST_NAME_BASIC_SECTION)
                .clickBtn("+ Кейс")
                .checkTitle("div.card-header h5","Новая запись");

        executeJavaScript("document.querySelector('footer.site-footer').style.display = 'none'");
        casesPage.selectOptionCase("section","Основной раздел")
                .selectOptionCase("status_id","Draft")
                .selectOptionCase("type_id","Smoke")
                .selectOptionCase("priority_id","High")
                .selectOptionCase("severity_id","Blocker");
        $("select#responsible_id").selectOption(0);
        casesPage.setNameCase(TEST_CASE_NAME)
                .setDescriptionCase("Информация ",TEST_CASE_TITLE_INFO)
                .setDescriptionCase("Предусловие ",TEST_CASE_TITLE_PRECONDITION)
                .setDescriptionStepCase("Шаг 1","Описание шага",TEST_CASE_STEP_DESCRIPTION)
                .setDescriptionStepCase("Шаг 1","Ожидаемый результат",TEST_CASE_STEP_RESULT)
                .setDescriptionStepCase("Шаг 2","Описание шага",TEST_CASE_STEP_DESCRIPTION)
                .setDescriptionStepCase("Шаг 2","Ожидаемый результат",TEST_CASE_STEP_RESULT)
                .clickBtn("Сохранить и перейти к записи");

        casesPage.checkTitle("div.card-body h5", TEST_CASE_NAME)
                .checkTitle( "div.card-body h2", TEST_CASE_NAME)
                .checkDescriptionTitleCase("Информация",TEST_CASE_TITLE_INFO)
                .checkDescriptionTitleCase("Предусловие",TEST_CASE_TITLE_PRECONDITION)
                .checkDescriptionStepCase("Шаг № 1","Описание:",TEST_CASE_STEP_DESCRIPTION)
                .checkDescriptionStepCase("Шаг № 1","Результат:",TEST_CASE_STEP_RESULT)
                .checkDescriptionStepCase("Шаг № 2","Описание:",TEST_CASE_STEP_DESCRIPTION)
                .checkDescriptionStepCase("Шаг № 2","Результат:",TEST_CASE_STEP_RESULT);

        executeJavaScript("window.open()");
        switchTo().window(1);
        open(PROJECT_BASE_URL + PROJECT_CASES_URL);
        casesPage.deleteTestCase(TEST_CASE_NAME)
                .deleteSection("Основной раздел");
    }

}
