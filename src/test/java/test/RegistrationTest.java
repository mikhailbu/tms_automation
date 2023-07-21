package test;
import helpers.StringModifier;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static helpers.TestValues.*;



public class RegistrationTest extends BaseTest {
    @Disabled("Ввели верификацию по номеру телефона")
    @Test
    @Feature("Тестирование формы логирования")
    @Owner("buyanovMV")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тест на регистрацию пользователя с рандомными данными")

    void registrationRandomValueTest() {
        List<String> links = new ArrayList<>();

        StringModifier.emailAndLoginRandom();
        loginPage.openPage(BASE_URL,LOGIN_URL)
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
