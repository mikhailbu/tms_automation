package test;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static helpers.TestValues.*;

public class CreateTestCaseTest extends BaseTest {

    @Test
    @Tag("testCase")
    @Feature("Тестироване сущности 'TEST_CASE'")
    @Owner("buyanovMV")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тестироване создания новой сущности 'TEST_CASE'")
    void createNewTestCaseTest() throws Exception{
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
        createSection();
        checkSection();
        createCase();
        checkCase();
        cleanOldTestCase();
    }

    void createTestCase() throws Exception {
        createSection();
        checkSection();
        createCase();
        checkCase();

    }

    void openMenuTestCase(int numberTabSwitch){
        executeJavaScript("window.open()");
        switchTo().window(numberTabSwitch);
        open(PROJECT_BASE_URL + PROJECT_CASES_URL);
    }

    void cleanOldTestCase(){
        openMenuTestCase(1);
        casesPage.deleteTestCase(TEST_CASE_NAME)
                .deleteSection("Основной раздел");
    }
    void createSection(){
        casesPage.clickBtn("Раздел");
        casesPage.checkTitle( "div.modal-simple__content h5", "Новый раздел");
        casesPage.setNameSection(TEST_NAME_BASIC_SECTION)
                .selectOptionSection("Корневой раздел")
                .setDescriptionSection(TEST_BODY)
                .clickBtn("Сохранить");
    }
    void checkSection(){
        casesPage.checkTitle("div.cases__content h5",TEST_NAME_BASIC_SECTION);
    }
    void createCase(){
                casesPage.clickBtn("Кейс")
                .checkTitle("div.card-header h5","Новая запись")
                .selectOptionCase("section","Основной раздел")
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
                .uploadFileInStep("Шаг 2","test_file_txt.txt")
                .clickBtn("Сохранить и перейти к записи");
    }
    void checkCase() throws Exception{
        casesPage.checkTitle("div.card-body h5", TEST_CASE_NAME)
                .checkDescriptionTitleCase("Информация",TEST_CASE_TITLE_INFO)
                .checkDescriptionTitleCase("Предусловие",TEST_CASE_TITLE_PRECONDITION)
                .checkDescriptionStepCase("Шаг № 1","Описание:",TEST_CASE_STEP_DESCRIPTION)
                .checkDescriptionStepCase("Шаг № 1","Результат:",TEST_CASE_STEP_RESULT)
                .checkDescriptionStepCase("Шаг № 2","Описание:",TEST_CASE_STEP_DESCRIPTION)
                .checkDescriptionStepCase("Шаг № 2","Результат:",TEST_CASE_STEP_RESULT);
        casesPage.downloadTextFile("Шаг № 2");
    }

}
