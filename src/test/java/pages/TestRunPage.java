package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class TestRunPage {

    public TestRunPage checkTitle(String tagTitle, String nameTitle) {
        $$(tagTitle).findBy(text(nameTitle)).shouldHave(text(nameTitle));
        return this;
    }

    public TestRunPage clickBtn(String nameBtn){
        $(byTagAndText("button", nameBtn)).shouldHave(visible).click();
        return this;
    }

    public TestRunPage setNameTestRun (String name){
        $("input.form-control").setValue(name);
        return this;
    }

    public TestRunPage setDescriptionTestRun (String titleDescription, String description){
        $x("//label[text()='"+ titleDescription +"']//following-sibling::div/child::div[1]")
                .setValue(description);
        return this;
    }

    public TestRunPage selectOptionMilestone(String name){
        $("select#milestone_id").selectOption(name);
        return this;
    }

    public TestRunPage selectOptionResponsible (int index){
        $("select#responsible_id").selectOption(index);
        return this;
    }

    public TestRunPage selectOptionEnvironment(String name){
        $("select#environment_id").selectOption(name);
        return this;
    }

    public TestRunPage selectTestCase(String nameTestCase){
        $x(("//td[text()='") + nameTestCase + ("']//ancestor-or-self::tr/td/input")).click();
        return this;
    }

    public TestRunPage checkTestCase (String nameCase){
        $$x("//div[@class='card-body']//td[@class='text-break']//self::td").findBy(text(nameCase)).shouldBe(visible);
    return this;
    }
    public TestRunPage checkInfoTestRun (String nameTitle, String value) {
        $x("//div[@class='card-body']//following-sibling::p/b[text()='"+nameTitle+"']/..").shouldHave(text(value));
        return this;
    }
    public TestRunPage checkResponsiblePersonTestRun (String nameTitle, String value) {
        $x("//div[@class='card-body']//following-sibling::div/b[text()='"+nameTitle+"']//following-sibling::div/span").shouldHave(text(value));
        return this;
    }

}
