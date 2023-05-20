package test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import helpers.StringModifier;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static helpers.TestValues.*;

public class RegistrationTest {
    @Test
    void registrationRandomTest() {
        StringModifier.emailRandom();


        open(LOGIN_URL);
        $("input[type='text']").setValue(NEW_TEST_EMAIL).pressEnter();
        $("input[placeholder='User login']").setValue(NEW_TEST_LOGIN).pressEnter();
        $$("input[type=password]").first().setValue(NEW_TEST_PASSWORD).pressEnter();
        $$("input[type=password]").get(1).setValue(NEW_TEST_PASSWORD);
        $("button[type='submit']").shouldNotBe(disabled).click();
        ElementsCollection results = $$("div.actions-after-registration__list");
        for (SelenideElement element : results){
            element.shouldHave(textsINAnyOrder(
                    "- Создать первое рабочее пространство",
                    "- Создать демонстрационный проект",
                    "- Перейти к рабочему столу"));
        }

//        shouldHave(texts(
//                        "- Создать первое рабочее пространство",
//                        "- Создать демонстрационный проект",
//                        "- Перейти к рабочему столу"));
    //TODO дописать ветвление после регистрации

        $(byAttribute("a","https://firetms.ru/desktop")).click();


        new LoginTest()
                .loginTest();
    }
}
