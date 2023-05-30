package test;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static helpers.TestValues.*;

public class LoginTest extends BaseTest{

    @Test
    void loginTest ()  {
        loginPage.openPageLogin(LOGIN_URLS)
                .checkTitle("Вход в учетную запись", "h4")
                .setEmail(TEST_EMAIL)
                .setPasswordFirst(TEST_PASSWORD)
                .checkTitle("Рабочий стол", "h3")
                .
                        checkUrl(DESKTOP_URL);

                $("div.top-navbar__right-part-item > i[data-tags='person,account']").hover();
                $("i[data-tags='person,account'] + a").click();


        int x = 1;
    }

}
