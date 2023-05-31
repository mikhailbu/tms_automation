package test;
import org.junit.jupiter.api.Test;
import static helpers.TestValues.*;
public class LoginTest extends BaseTest{

    @Test
    void loginTest ()  {
        loginPage.openPageLogin(LOGIN_URL)
                .checkTitle("Вход в учетную запись", "h4")
                .setEmail(TEST_EMAIL)
                .setPasswordFirst(TEST_PASSWORD)
                .checkTitle("Рабочий стол", "h3")
                .checkUrl(DESKTOP_URL)
                .optionMenu("Мой профиль")
                .checkTitle("Информация","h4")
                .checkLogin(TEST_LOGIN)
                .checkEmail(TEST_EMAIL);
    }

}
