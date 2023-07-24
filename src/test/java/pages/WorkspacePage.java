package pages;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkspacePage {
    public WorkspacePage openPage(String baseUrl, String openUrl) {
        open(baseUrl+openUrl);
        return this;
    }

    public WorkspacePage checkTitle(String nameTitle, String tagTitle) {
        $(tagTitle).shouldHave(text(nameTitle));
        return this;
    }

    public WorkspacePage checkUrl(String expectedUrl) {
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        return this;
    }
    public WorkspacePage createWorkspace(String nameBtn){
        $(byTagAndText("button", nameBtn)).click();
        return this;
    }
    public WorkspacePage setNameWorkspace(String name){
        $$("input.form-control").first().setValue(name).pressEnter();
        return this;
    }
    public WorkspacePage setShortNameWorkspace(String shortName){
        $$("input.form-control").get(1).setValue(shortName);

        return this;
    }
    public WorkspacePage switchSideMenu (String nameBtn){
        $("div.left-sidebar__menu-item[title='"+nameBtn+"']").click();
        return this;
    }
    public WorkspacePage switchTabWorkspace (String nameBtn){
        $$("li.nav-item").findBy(text(nameBtn)).click();
        return this;
    }
    public WorkspacePage clickBtn(String nameBtn){
        $(byTagAndText("button", nameBtn)).shouldHave(visible).click();
        return this;
    }
    public WorkspacePage selectWorkspace(String nameWorkspace){
        $(byText(nameWorkspace)).shouldBe(visible).click();
        return this;
    }
    public WorkspacePage selectProject(String nameWorkspace){
        $(byText(nameWorkspace)).click();
        return this;
    }
    public WorkspacePage createProject(String nameBtn){
        $(byTagAndText("button", nameBtn)).click();
        return this;
    }

    public WorkspacePage setNameProject(String name){
        $$("input.form-control").first().setValue(name).pressEnter();
        return this;
    }
    public WorkspacePage setShortNameProject(String shortName){
        $$("input.form-control").get(1).setValue(shortName);

        return this;
    }
}
