package test;

import helpers.StringModifier;
import org.junit.jupiter.api.Test;

import static helpers.TestValues.*;
import static helpers.TestValues.TEST_PASSWORD;

public class CreateWorkspace extends BaseTest{

    @Test
    void createWorkspace() {
        StringModifier.nameWorkspaceAndShortNameWorkSpaceRandom();
        loginPage.openPage(BASE_URL,LOGIN_URL)
                .checkTitle("Вход в учетную запись", "h4")
                .setEmail(TEST_EMAIL)
                .setPasswordFirst(TEST_PASSWORD);
        workspacePage.switchSideMenu("Мои пространства")
                .createWorkspace("Добавить рабочее пространство")
                .setNameWorkspace(NEW_NAME_WORKSPACES)
                .setShortNameWorkspace(NEW_NAME_SHORT_WORKSPACES)
                .clickBtn("Создать")
                .checkTitle(NEW_NAME_WORKSPACES,"h3");
        //todo добавить проверку данных card-body

    }
}
//открыть
//добавть РП
//заполнить данные
//нажать добавить
//проверить данные
//создать проект

