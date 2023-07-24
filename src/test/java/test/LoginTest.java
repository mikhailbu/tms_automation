package test;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static helpers.TestValues.*;
public class LoginTest extends BaseTest{
    @Test
    @Tag("login")
    @Feature("Тестирование формы логирования")
    @Owner("buyanovMV")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тест на логин зарегистрированного пользователя")

    void loginTest ()  {
        loginAccount();
        loginAccountCheck();
    }

    void loginAccount(){
        loginPage.openPage(BASE_URL,LOGIN_URL)
//                .checkTitle("Вход в учетную запись", "h4")
                .setEmail(TEST_EMAIL)
                .setPasswordFirst(TEST_PASSWORD)
                .checkTitle("Рабочий стол", "h3");
    }
    void loginAccountCheck(){
        loginPage.checkUrl(BASE_URL+DESKTOP_URL)
                .optionMenu("Мой профиль")
                .checkTitle("Информация","h4")
                .checkLogin(TEST_LOGIN)
                .checkEmail(TEST_EMAIL);
    }

}
