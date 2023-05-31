package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static helpers.TestValues.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {

    public LoginPage openPage(String baseUrl, String openUrl) {
        open(baseUrl+openUrl);
        return this;
    }

    public LoginPage checkTitle(String nameTitle, String tagTitle) {
        $(tagTitle).shouldHave(text(nameTitle));
        return this;
    }

    public LoginPage checkUrl(String expectedUrl) {
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        return this;
    }

    public LoginPage setEmail(String email) {
        $("input[placeholder='test@gmail.com']").setValue(email).pressEnter();
        return this;
    }

    public LoginPage checkEmail(String expectedEmail) {
        String actualEmail = Selenide
                .executeJavaScript("return document.getElementsByClassName('form-control')[1].value");
        assertEquals(expectedEmail, actualEmail);
        return this;
    }

    public LoginPage setLogin(String login) {
        $("input[placeholder='User login']").setValue(login).pressEnter();
        return this;
    }

    public LoginPage checkLogin(String expectedLogin) {
        String actualLogin = Selenide
                .executeJavaScript("return document.getElementsByClassName('form-control')[0].value");
        assertEquals(expectedLogin, actualLogin);
        return this;
    }

    public LoginPage setPasswordFirst(String password) {

        $$("input[placeholder='*****']").first().setValue(password).pressEnter();
        return this;
    }

    public LoginPage setPasswordSecond(String password) {
        $$("input[placeholder='*****']").get(1).setValue(password);
        return this;
    }

    public LoginPage submitForm() {
        $("button[type='submit']").shouldNotBe(disabled)
                .shouldHave(text("Зарегистрироваться")).click();
        return this;

    }

    public LoginPage optionMenu(String nameButton) {
        $("div.top-navbar__right-part-item > [data-tags='person,account']").click();
        $$("div.chat-dropdown a").find(text(nameButton)).click();
        return this;

    }

    public LoginPage listAddElement(List<String> list) {
        ElementsCollection elementsList = $$x("//div[@class='actions-after-registration__action']//a");
        elementsList.forEach(x -> list.add(x.getAttribute("href")));
        return this;
    }

    public LoginPage checkUrlLinks(List<String> links) {
        for (int i = 0; i < links.size(); i++) {
            String elemLinks = links.get(i);

            executeJavaScript("window.open()");
            List<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
            switchTo().window(tabs.get(i+1));
            open(elemLinks);
            String elemUrl = getWebDriver().getCurrentUrl();
            assertEquals(elemLinks, elemUrl);
            if (elemUrl.equals(DESKTOP_URL)) {
                LoginPage loginPage = new LoginPage();
                loginPage.optionMenu("Мой профиль")
                        .checkTitle("Информация", "h4")
                        .checkLogin(NEW_TEST_LOGIN)
                        .checkEmail(NEW_TEST_EMAIL);
            }
            //todo выделить if в отдельный метод и добавить в тест регистрации
        }
        return this;
    }
}
