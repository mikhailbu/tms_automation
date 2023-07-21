package helpers;

import static helpers.StringModifier.*;

public class TestValues {
    public static String TEST_ACTUAL_DATE_DD_MM_YYYY = "";
    public static String TEST_ACTUAL_DATE_DD_MM_YYYY_HM = "";
    public static String TEST_BODY = "Тестовое сообщение 101!";
    public static String TEST_TITLE = "Тестовый заголовок";

    public static String TEST_EMAIL = "latest_0001@gmail.com";
    public static String TEST_NAME = "\u0410\u043b\u0435\u043a\u0441\u0430\u043d\u0434\u0440";
    public static String TEST_PASSWORD = "QWE123asdzxc";
    public static String TEST_FIRST_NAME = "\u0418\u0432\u0430\u043d\u043e\u0432";
    public static String TEST_PHONE = "79001112233";
    public static String TEST_LOGIN = "latest_0001";
    public static String TEST_NAME_WORKSPACES = "WORK";
    public static String TEST_NAME_SHORT_WORKSPACES = "work12";
    public static String TEST_NAME_PROJECT = "PROJECT";
    public static String TEST_NAME_SHORT_PROJECT = "pr1";
    public static String TEST_NAME_BASIC_SECTION = "Основной раздел";

    public static String NEW_TEST_EMAIL = "";
    public static String NEW_TEST_LOGIN = "";
    public static String NEW_TEST_PHONE = "";
    public static String NEW_NAME_WORKSPACES = "";
    public static String NEW_NAME_SHORT_WORKSPACES = "";
    public static String NEW_TEST_NAME_PROJECT = "";
    public static String NEW_TEST_NAME_SHORT_PROJECT = "";


    public static String BASE_URL = "https://firetms.ru";
    public static String LOGIN_URL = "/sign";
    public static String DESKTOP_URL = "/desktop";
    public static String WORKSPACES_URL = "/workspaces";

    /**
     * Workspaces_url
     */
    public static String WORKSPACES_BASE_URL = "https://" + TEST_NAME_SHORT_WORKSPACES +".firetms.ru";
    public static String WORKSPACES_MEMBERS_URL= "/members";
    /**
     * Project_url
     */

    public static String PROJECT_BASE_URL = "https://" + TEST_NAME_SHORT_WORKSPACES + ".firetms.ru/p/"+TEST_NAME_SHORT_PROJECT;
    public static String PROJECT_CASES_URL = "/cases";
    public static String PROJECT_PLANS_URL = "/plans";
    public static String PROJECT_RUNS_URL = "/runs";
    public static String PROJECT_MILESTONES_URL = "/milestones";



    public static String TEST_CASE_TITLE_INFO = "Информация о тест кейсе";
    public static String TEST_CASE_NAME = "Новый тест кейс";
    public static String TEST_CASE_TITLE_PRECONDITION = "Предусловие тест кейса";
    public static String TEST_CASE_STEP_DESCRIPTION = "Описание шага";
    public static String TEST_CASE_STEP_RESULT = "Результат шага";
    public static String TEST_CASE_BASIC_SECTION = "Основной раздел";


    public static String TEST_MILESTONE_TITLE_INFO = "Информация о тест Milestone";
    public static String TEST_MILESTONE_NAME = "Новый Milestone";
    public static String TEST_STATUS_MILESTONE = "";


    public static String TEST_TEST_PLAN_TITLE_INFO = "Информация о тест-плане";
    public static String TEST_TEST_PLAN_NAME = "Новый тест-план";


    public static String TEST_TEST_RUN_TITLE_INFO = "Информация о тест-ране";
    public static String TEST_TEST_RUN_NAME = "Новый тест-ран";

}