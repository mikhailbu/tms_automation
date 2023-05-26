package test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.StringModifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;
import static helpers.TestValues.*;


public class RegistrationTest extends BaseTest {


    @Test
    void registrationRandomValueTest() {

        StringModifier.emailRandom();
        loginPage.openPageLogin(LOGIN_URL)
                .setEmail(NEW_TEST_EMAIL)
                .setLogin(NEW_TEST_LOGIN)
                .setPasswordFirst(NEW_TEST_PASSWORD)
                .setPasswordSecond(NEW_TEST_PASSWORD)
                .submitForm();
        List<String> links = new ArrayList<>();
        listAdd(links);
//        links.forEach(System.out::println);
//        links.forEach(Selenide::open);
    }

    void listAdd (List<String> list) {
        ElementsCollection elementsList = $$x("//div[@class='actions-after-registration__action']//a");
        elementsList.forEach(x -> list.add(x.getAttribute("href")));
    }
    //TODO дописать ветвление после регистрации


//        List<String> links = new ArrayList<>();
//        for (SelenideElement selenideElement : href) {
//            links.add(selenideElement.getAttribute("href"));

    //            printList(lists);
    int x = 1;

    private static void printList(List<String> list) {
        list.forEach(System.out::println);
    }
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
