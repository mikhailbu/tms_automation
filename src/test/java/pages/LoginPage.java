package pages;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static helpers.TestValues.DESKTOP_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {

    public LoginPage openPageLogin(String url){
        open(url);
        return this;
    }

    public LoginPage checkTitle(String nameTitle, String tagTitle){
        $(tagTitle).shouldHave(text(nameTitle));
        return this;
    }
    public LoginPage checkUrl(String expectedUrl){
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(DESKTOP_URL, actualUrl);
        return this;
    }

    public LoginPage setEmail (String email) {
        $("input[placeholder='test@gmail.com']").setValue(email).pressEnter();
        return this;
    }

    public LoginPage setLogin (String login) {
        $("input[placeholder='User login']").setValue(login).pressEnter();
        return this;
    }

    public LoginPage setPasswordFirst (String password) {

        $$("input[placeholder='*****']").first().setValue(password).pressEnter();
        return this;
    }

    public LoginPage setPasswordSecond (String password) {
        $$("input[placeholder='*****']").get(1).setValue(password);
        return this;
    }

    public void submitForm () {
        $("button[type='submit']").shouldNotBe(disabled)
                .shouldHave(text("Зарегистрироваться")).click();

    }

}
