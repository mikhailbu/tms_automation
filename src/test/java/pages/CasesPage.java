package pages;

import com.codeborne.selenide.SelenideElement;

import javax.lang.model.element.Element;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static helpers.TestValues.*;
import static org.assertj.core.api.Assertions.assertThat;

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

    public CasesPage uploadFileInStep (String stepName ,String pathFile) {
        $x("//div[text()='"+stepName+"']/..//div[@class='files-group']//button").click();
        $("input[type='file']").uploadFromClasspath(pathFile);
        $$("div.modal-footer button").findBy(text(" Загрузить ")).click();
        return this;
    }

    public CasesPage downloadTextFile  (String stepName) throws Exception {
        executeJavaScript("document.querySelector('footer.site-footer').style.display = 'none'");
        executeJavaScript("document.querySelector('div.file__info').style.display='flex'");
       File textfile = $("div.file__info a").scrollIntoView(false).download();
        try (InputStream input = new FileInputStream(textfile)) {
            byte[] fileContent = input.readAllBytes();
            String strContent = new String(fileContent, StandardCharsets.UTF_8);
            assertThat(strContent).contains("Текст файла");
            //todo BufferedReader add and xls parser

        }
        return this;

    }


}
