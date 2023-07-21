
package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StringModifier {

    public static String getActualDateDayMonthYear() {
        return new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    }
    public static String getActualDateDayMonthYearHourMinute() {
        return new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date());
    }


    public static void emailAndLoginRandom() {
        Random random = new Random();
        String randomNumber = String.valueOf(random.nextInt(10000));
        TestValues.NEW_TEST_LOGIN = ("latest_0" + randomNumber);
        TestValues.NEW_TEST_EMAIL = ("latest_0" + randomNumber + "@gmail.com");
        System.out.println("Новый email:" + TestValues.NEW_TEST_EMAIL);
        System.out.println("Новый login:" + TestValues.NEW_TEST_LOGIN);

    }
    public static void nameWorkspaceAndShortNameWorkSpaceRandom() {
        Random random = new Random();
        String randomNumber = String.valueOf(random.nextInt(10000));
        TestValues.NEW_NAME_WORKSPACES = ("WORK" + randomNumber);
        TestValues.NEW_NAME_SHORT_WORKSPACES = ("work" + randomNumber);;
        System.out.println("Новый nameWorkSpace:" + TestValues.NEW_NAME_WORKSPACES);
        System.out.println("Новый nameShortWorkSpace:" + TestValues.NEW_NAME_SHORT_WORKSPACES);

    }    public static void nameProjectAndShortNameProjectRandom() {
        Random random = new Random();
        String randomNumber = String.valueOf(random.nextInt(10000));
        String randomNumberShort = String.valueOf(random.nextInt(999));
        TestValues.NEW_TEST_NAME_PROJECT = ("PROJECT" + randomNumber);
        TestValues.NEW_TEST_NAME_SHORT_PROJECT = ("pr" + randomNumberShort);;
        System.out.println("Новый nameProject:" + TestValues.NEW_TEST_NAME_PROJECT);
        System.out.println("Новый nameProject:" + TestValues.NEW_TEST_NAME_SHORT_PROJECT);

    }
    public static void phoneRandom(){
        Random random = new Random();
        Integer volume = (random.nextInt(10000)+1000000000);
        TestValues.NEW_TEST_PHONE = String.valueOf(volume);
        System.out.println("Новый номер:" + volume);
    }
}