package test;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.TestValues.*;

public class LoginTest {
    @Test
    void loginTest() {
        open(LOGIN_URL);
        $("input[type='text']").setValue(NEW_TEST_EMAIL).pressEnter();
//        $("button.btn").$(byText("Войти")).click();
        $("input[type='password']").setValue(NEW_TEST_PASSWORD).pressEnter();
    }

}
