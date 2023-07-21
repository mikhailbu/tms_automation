package test;

import helpers.StringModifier;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.TestValues.*;
import static helpers.TestValues.TEST_PASSWORD;

public class CreateWorkspaceTest extends BaseTest{

    @Test
    @Tag("workspace")
    @Feature("Тестироване сущности 'WORKSPACE'")
    @Owner("buyanovMV")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тестироване создания новой сущности 'WORKSPACE'")

    void loginAndCreateTestWorkspace() {
        StringModifier.nameWorkspaceAndShortNameWorkSpaceRandom();
        LoginTest loginTest = new LoginTest();
        loginTest.loginAccount();
        createWorkspace();
        checkWorkspace();

    }
    void createWorkspace() {
        workspacePage.switchSideMenu("Мои пространства")
                .createWorkspace("Добавить рабочее пространство")
                .setNameWorkspace(NEW_NAME_WORKSPACES)
                .setShortNameWorkspace(NEW_NAME_SHORT_WORKSPACES)
                .clickBtn("Создать");
    }
    void checkWorkspace(){
        workspacePage.checkTitle(NEW_NAME_WORKSPACES,"h3");
    }
        //todo добавить проверку данных card-body

}

