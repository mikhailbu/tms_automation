package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeAll;
import pages.CasesPage;
import pages.LoginPage;
import pages.WorkspacePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    LoginPage loginPage = new LoginPage();
    WorkspacePage workspacePage = new WorkspacePage();
    CasesPage casesPage = new CasesPage();

    @BeforeAll
    static void beforeAll() {
//        Configuration.baseUrl = "https://firetms.ru";
        Configuration.browserSize = "1980x1080";

    }

    public BaseTest leftNavigationSideBar(List<String> list) {
        ElementsCollection elementsList = $$("div#left-navigation-sidebar a");
        elementsList.forEach(x -> list.add(x.getAttribute("href")));


        return this;
    }

    public void printList (List<String> links) {
        for (int i = 0; i < links.size(); i++) {
            String elemLinks = links.get(i);
            System.out.println(elemLinks);
        }
    }
}