package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class TestPlanPage {

    public TestPlanPage checkTitle(String tagTitle, String nameTitle) {
        $(tagTitle).shouldHave(text(nameTitle));
        return this;
    }
    public TestPlanPage checkCardBodyTestPlanSelectionName (String tagTitle, String description) {
        $x("//"+tagTitle+"[text()='"+description+"']")
                .shouldHave(text(description));
        return this;
    }
    public TestPlanPage checkCardBodyTestPlanMilestone (String titleDescription, String description) {
        $x("//div[@class='card-body']//b[text()='"+titleDescription+"']//following-sibling::a")
                .shouldHave(text(description));
        return this;
    }
    public TestPlanPage checkCardBodyTestPlanName (String titleDescription, String description) {
        $x("//div[@class='card-body']//h3[text()='"+titleDescription+"']")
                .shouldHave(text(description));
        return this;
    }
    public TestPlanPage checkCardBodyTestPlanDescription (String titleDescription, String description) {
        $x("//div[@class='card-body']//b[text()='"+titleDescription+"']//following::div[1]//p")
                .shouldHave(text(description));
        return this;
    }
    public TestPlanPage checkCardBodyTestPlanNameTestCase (String titleDescription, String description) {
        $x("//div[@class='card-body']//td[text()='"+titleDescription+"']//self::td")
                .shouldHave(text(description));
        return this;
    }

    public TestPlanPage clickBtn(String nameBtn){
        $(byTagAndText("button", nameBtn)).shouldHave(visible).click();
        return this;
    }

    public TestPlanPage setNameTestPlan(String name){
        $("input.form-control").setValue(name);
        return this;
    }
    public TestPlanPage setDescriptionTestPlan(String titleDescription, String description){
        $x("//label[text()='"+ titleDescription +"']//following-sibling::div/child::div[1]")
                .setValue(description);
        return this;
    }
    public TestPlanPage selectOptionMilestone(String name){
        $("select#milestone_id").selectOption(name);
        return this;
    }

    public TestPlanPage selectTestCase(String nameTestCase){
        $x(("//td[text()='") + nameTestCase + ("']//ancestor-or-self::tr/td/input")).click();
        return this;
    }

    public TestPlanPage deleteTestPlan(String nameTestPlan){
        $$x(".//*[@id='plan-list']//td").findBy(text(nameTestPlan)).doubleClick();
        $("div.bookmark li [data-tooltip='Удалить']").click();
        clickBtn("Ок");
        return this;
    }


}
