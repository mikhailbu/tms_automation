package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class MilestonePage {

    public MilestonePage checkTitle(String tagTitle, String nameTitle) {
        $(tagTitle).shouldHave(text(nameTitle));
        return this;
    }

    public MilestonePage clickBtn(String nameBtn) {
        $(byTagAndText("button", nameBtn)).shouldHave(visible).click();
        return this;
    }

    public MilestonePage setNameMilestone(String name) {
        $("input.form-control").setValue(name);
        return this;
    }

    public MilestonePage selectOptionStatus(String name) {
        $("select#status_id").selectOption(name);
        return this;
    }

    public MilestonePage setDescriptionMilestone(String titleDescription, String description) {
        $x("//label[text()='" + titleDescription + "']//following-sibling::div/child::div[1]")
                .setValue(description);
        return this;
    }

    public MilestonePage setDateMilestone(String actualDate) {
        $("input[placeholder='дд.мм.гггг']").setValue(actualDate);
        return this;
    }

    public MilestonePage checkDescriptionTitleMilestone(String titleDescription, String description) {
        $x("//h4[text()='" + titleDescription + "']//following::div[1]//p")
                .shouldHave(text(description));
        return this;
    }

    public MilestonePage checkLoginAuthorMilestone(String loginAuthor) {
        $("img.avatar + div").shouldHave(text("@" + loginAuthor));
        return this;
    }

    public MilestonePage checkInfoMilestone(String nameTitle, String value) {
        $x("//*[@id='top-tabContent']//span[text()='" + nameTitle + "']/..").shouldHave(text(value));
        return this;
    }

    public MilestonePage deleteTestMilestone(String nameMilestone) {
        $x(("//td[text()='") + nameMilestone + ("']//ancestor-or-self::tr/td/div/input")).click();
        $$("div.bottom-toolbar button")
                .findBy(text(" Удалить ")).shouldHave(visible).click();
        $$("div.modal-simple button")
                .findBy(text(" Удалить ")).shouldHave(visible).click();
        return this;
    }

    public MilestonePage switchSideMenu(String nameBtn) {
        $(byText(nameBtn)).click();
        return this;

    }
}
