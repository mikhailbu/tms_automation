package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static helpers.TestValues.*;

public class LoginPage {

    public LoginPage openPageLogin(String url){
        open(url);
        $("h4").shouldHave(text("Вход в учетную запись"));
        return this;
    }
    public LoginPage setEmail (String email) {
        $("input[placeholder='test@gmail.com']").setValue(NEW_TEST_EMAIL).pressEnter();
        return this;
    }

    public LoginPage setLogin (String login) {
        $("input[placeholder='User login']").setValue(NEW_TEST_LOGIN).pressEnter();
        return this;
    }

    public LoginPage setPasswordFirst (String password) {
        $$("input[placeholder='*****']").first().setValue(NEW_TEST_PASSWORD).pressEnter();
        return this;
    }

    public LoginPage setPasswordSecond (String password) {
        $$("input[placeholder='*****']").get(1).setValue(NEW_TEST_PASSWORD);
        return this;
    }

    public void submitForm () {
        $("button[type='submit']").shouldNotBe(disabled)
                .shouldHave(text("Зарегистрироваться")).click();

    }

}
