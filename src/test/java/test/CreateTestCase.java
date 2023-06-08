package test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.TestValues.*;
import static helpers.TestValues.TEST_PASSWORD;

public class CreateTestCase extends BaseTest {
    @Test
    void createTestCase() {
        List<String> links = new ArrayList<>();
        loginPage.openPage(BASE_URL, LOGIN_URL)
                .checkTitle("Вход в учетную запись", "h4")
                .setEmail(TEST_EMAIL)
                .setPasswordFirst(TEST_PASSWORD);
        workspacePage.switchSideMenu("Мои пространства")
                .selectWorkspace(TEST_NAME_WORKSPACES);
       $$("td.align-middle div div").findBy(text(TEST_NAME_SHORT_PROJECT)).doubleClick();
//       $$("div.cases__header-plus-buttons button").findBy(text("Создать раздел")).click();
        workspacePage.clickBtn("+ Раздел");
        workspacePage.checkTitle("Новый раздел","div.modal-simple__content h5");
       $("input#section_title_input").setValue(TEST_NAME_BASIC_SECTION);
       $("div.modal-simple select.form-select").selectOption("Корневой раздел");
       $("div.modal-simple textarea.form-control").setValue(TEST_BODY);
       workspacePage.clickBtn("Сохранить");
       workspacePage.checkTitle(TEST_NAME_BASIC_SECTION,"div.cases__content h5");
       workspacePage.clickBtn("+ Кейс");
       workspacePage.checkTitle("Новая запись","div.card-header h5");
       $("input.form-control[placeholder]").setValue(TEST_TITLE);
       $$("div[aria-owns='quill-mention-list']").get(0).setValue(TEST_BODY);
       $$("div[aria-owns='quill-mention-list']").get(1).setValue(TEST_BODY);
       $$("div[aria-owns='quill-mention-list']").get(2).setValue(TEST_BODY);
       $$("div[aria-owns='quill-mention-list']").get(3).setValue(TEST_BODY);
       $$("div[aria-owns='quill-mention-list']").get(4).setValue(TEST_BODY);
       $$("div[aria-owns='quill-mention-list']").get(5).setValue(TEST_BODY);
       $("select#section").selectOption("Основной раздел");
       $("select#responsible_id").selectOption(0);
       $("select#status_id").selectOption("Draft");
       $("select#type_id").selectOption("Smoke");
       $("select#priority_id").selectOption("High");
       $("select#priority_id").selectOption("High");
       $("select#severity_id").selectOption("Blocker");
       $$("div.btns-group button").findBy(text("Сохранить и перейти к записи")).click();
       workspacePage.checkTitle(TEST_TITLE,"div.card-body h5");


       int a=1;

        leftNavigationSideBar(links);
        printList(links);
    }

}
