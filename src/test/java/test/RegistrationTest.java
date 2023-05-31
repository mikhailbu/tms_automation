package test;
import helpers.StringModifier;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static helpers.TestValues.*;



public class RegistrationTest extends BaseTest {
    @Test
    void registrationRandomValueTest() {
        List<String> links = new ArrayList<>();

        StringModifier.emailAndLoginRandom();
        loginPage.openPageLogin(LOGIN_URL)
                .checkTitle("Вход в учетную запись", "h4")
                .setEmail(NEW_TEST_EMAIL)
                .setLogin(NEW_TEST_LOGIN)
                .setPasswordFirst(TEST_PASSWORD)
                .setPasswordSecond(TEST_PASSWORD)
                .submitForm()
                .checkTitle("Выберите дальнейшее действие", "h5")
                .listAddElement(links)
                .checkUrlLinks(links);

    }
}
        //todo дописать ветвление на проверку создания демо проекта
