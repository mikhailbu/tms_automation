package test;

import helpers.StringModifier;
import org.junit.jupiter.api.Test;

import static helpers.TestValues.*;
import static helpers.TestValues.TEST_PASSWORD;

public class CreateProject extends BaseTest {
    @Test
    void createWorkspace() {
        StringModifier.nameWorkspaceAndShortNameWorkSpaceRandom();
        loginPage.openPage(BASE_URL, LOGIN_URL)
                .checkTitle("Вход в учетную запись", "h4")
                .setEmail(TEST_EMAIL)
                .setPasswordFirst(TEST_PASSWORD);
        workspacePage.switchSideMenu("Мои пространства")
                .selectWorkspace(TEST_NAME_WORKSPACES)
                .switchTabWorkspace("Проекты")
                .createProject("Добавить проект")
                .setNameProject(TEST_NAME_PROJECT)
                .setShortNameProject(TEST_NAME_SHORT_PROJECT)
                .clickBtn("Создать")
                .checkTitle(TEST_NAME_PROJECT,"h3");
    }
}
