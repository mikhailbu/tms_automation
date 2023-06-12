package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static helpers.TestValues.*;

public class CasesPage {

    public CasesPage checkTitle(String tagTitle, String nameTitle) {
        $(tagTitle).shouldHave(text(nameTitle));
        return this;
    }
    public CasesPage checkDescriptionStepCase (String nameStep, String titleStepDescription, String description) {
        $x("//div[text()='"+nameStep+"']//following::div[text()='"+titleStepDescription+"']/following::div[1]//p")
                .shouldHave(text(description));
        return this;
    }
    public CasesPage checkDescriptionTitleCase (String titleDescription, String description) {
        $x("//h4[text()='"+titleDescription+"']//following::div[1]//p")
                .shouldHave(text(description));
        return this;
    }
    public CasesPage clickBtn(String nameBtn){
        $(byTagAndText("button", nameBtn)).shouldHave(visible).click();
        return this;
    }
    public CasesPage setNameSection(String name){
        $("input#section_title_input").setValue(name);
        return this;
    }
    public CasesPage selectOptionSection(String name){
        $("div.modal-simple select.form-select").selectOption(name);
        return this;
    }

    public CasesPage setDescriptionSection(String text){
        $("div.modal-simple #info").setValue(text);
        return this;
    }

    public CasesPage selectOptionCase(String nameOption, String nameSelectorIndex){
        $("select#" + nameOption).selectOption(nameSelectorIndex);
        return this;
    }

    public CasesPage setNameCase(String name){
        $("input.form-control[placeholder]").setValue(name);
        return this;
    }
    public CasesPage setDescriptionCase(String titleDescription, String description){
        $x("//label[text()='"+ titleDescription +"']//following-sibling::div/child::div[1]")
                .setValue(description);
        return this;
    }

    public CasesPage setDescriptionStepCase(String nameStep, String titleStepDescription, String description){
        $x("//div[text()='"+nameStep+"']//following-sibling::div//div[@data-placeholder='"+ titleStepDescription +"']")
                .setValue(description);
        return this;
    }
    public CasesPage deleteTestCase(String nameTestCase){
        $x(("//td[text()='") + nameTestCase + ("']//ancestor-or-self::tr/td/input")).click();
        $("div.opened-view__section-header div.section-dd__button").click();
        $$("div.section-dd__dropdown_item")
                .findBy(text(" Удалить ")).click();
        $$("div.modal-simple button")
                .findBy(text(" Удалить ")).shouldHave(visible).click();
        return this;
    }
    public CasesPage deleteSection(String nameSection){
        $x("//h5[text()='"+nameSection+"']//following::div[@class='section-dd__button']").click();
        $$("div.section-dd__dropdown_item")
                .findBy(text(" Удалить раздел ")).click();
        $$("div.modal-simple button").findBy(text(" Ок ")).shouldHave(visible).click();

        return this;
    }

}
