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

public class CreateProjectTest extends BaseTest {

    @Test
    @Tag("project")
    @Feature("Тестироване сущности 'PROJECT'")
    @Owner("buyanovMV")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тестироване сущности 'PROJECT' с созданием нового Workspace")
    void CreateNewProjectTest(){
        StringModifier.nameWorkspaceAndShortNameWorkSpaceRandom();
        StringModifier.nameProjectAndShortNameProjectRandom();
        LoginTest loginTest = new LoginTest();
        loginTest.loginAccount();

        CreateWorkspaceTest createWorkspaceTest = new CreateWorkspaceTest();
        createWorkspaceTest.createWorkspace();
        createWorkspaceTest.checkWorkspace();

        workspacePage.openPage(BASE_URL,DESKTOP_URL);
        createProject(NEW_TEST_NAME_PROJECT,NEW_TEST_NAME_SHORT_PROJECT,NEW_NAME_WORKSPACES);
        checkProject(NEW_TEST_NAME_PROJECT,NEW_NAME_WORKSPACES);
    }


    void createProject(String nameProject,String shortNameProject,String nameWorkspace){
        workspacePage.switchSideMenu("Мои пространства")
                .selectWorkspace(nameWorkspace)
                .switchTabWorkspace("Проекты")
                .createProject("Добавить проект")
                .setNameProject(nameProject)
                .setShortNameProject(shortNameProject)
                .clickBtn("Создать");
    }
    void checkProject(String nameProject,String nameWorkspace){
        executeJavaScript("window.open()");
        switchTo().window(1);
        workspacePage.openPage(BASE_URL,WORKSPACES_URL);
        workspacePage.selectWorkspace(nameWorkspace)
                .checkTitle(nameWorkspace,"h3")
                .selectProject(nameProject)
                .checkTitle(nameProject,"h3");
    }

    void cleanOldProject(){
        executeJavaScript("window.open()");
        switchTo().window(1);
        open(PROJECT_BASE_URL + "/settings");
        settingProjectPage.clickBtn("Удалить")
                .setTextDelete("УДАЛИТЬ");




    }

}
