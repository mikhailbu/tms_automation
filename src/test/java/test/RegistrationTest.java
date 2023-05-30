package test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import helpers.StringModifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;
import static helpers.TestValues.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegistrationTest extends BaseTest {


    @Test
    void registrationRandomValueTest() {

        StringModifier.emailAndLoginRandom();
        loginPage.openPageLogin(LOGIN_URL)
                .checkTitle("Вход в учетную запись","h4")
                .setEmail(NEW_TEST_EMAIL)
                .setLogin(NEW_TEST_LOGIN)
                .setPasswordFirst(TEST_PASSWORD)
                .setPasswordSecond(TEST_PASSWORD)
                .submitForm();
        List<String> links = new ArrayList<>();
        listAddElement(links);

        for (int i = 0; i < links.size(); i++) {
            String elemLinks = links.get(i);
            open(elemLinks);
            String elemUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            assertEquals(elemLinks, elemUrl);

        }

//        links.forEach(System.out::println);
//        links.forEach(Selenide::open);
    }


    void listAddElement(List<String> list) {
        ElementsCollection elementsList = $$x("//div[@class='actions-after-registration__action']//a");
        elementsList.forEach(x -> list.add(x.getAttribute("href")));
    }
    //TODO дописать ветвление после регистрации


//        List<String> links = new ArrayList<>();
//        for (SelenideElement selenideElement : href) {
//            links.add(selenideElement.getAttribute("href"));

    //            printList(lists);
    int x = 1;
}


//            element.shouldHave(textsINAnyOrder(
//                    "- Создать первое рабочее пространство",
//                    "- Создать демонстрационный проект",
//                    "- Перейти к рабочему столу"));


//        shouldHave(texts(
//                        "- Создать первое рабочее пространство",
//                        "- Создать демонстрационный проект",
//                        "- Перейти к рабочему столу"));

//        $(byAttribute("a","https://firetms.ru/desktop")).click();
//
//
//        new LoginTest()
//                .loginTest();
//    }
//}
