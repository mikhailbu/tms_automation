package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.LoginPage;

public class BaseTest {
    LoginPage loginPage = new LoginPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://firetms.ru";
        Configuration.browserSize = "1980x1080";

    }
}
