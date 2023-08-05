package helpers;

import org.jsoup.Jsoup;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class EmailParserCheck {
    @Test
    @Tag("email")
    void parseCodeEmail() throws IOException, MessagingException {
        FileInputStream fileInputStream = new FileInputStream("config.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);

        String user = properties.getProperty("mail.user");
        String password  = properties.getProperty("mail.password");
        String host = properties.getProperty("mail.host");

        Properties prop = new Properties();
        prop.put("mail.store.protocol","imaps");

        Store store = Session.getInstance(prop).getStore();
        store.connect(host,user,password);
        Folder spam = store.getFolder("Inbox"); //or Spam
        spam.open(Folder.READ_ONLY);


        Message message = spam.getMessage(spam.getMessageCount());
        String emailTo = Arrays.toString(message.getRecipients(Message.RecipientType.TO))
                .replace("[","")
                .replace("]","");

        InternetAddress address = new InternetAddress(emailTo);
        String personal = address.getPersonal();
        if(personal != null) {
            address.setPersonal(personal, "utf-8");
        }
        System.out.println(address);


        String string = (String) message.getContent();
        var document = Jsoup.parse(string);
        var titleElem = document.selectFirst("span");
        assert titleElem != null;
        TestValues.NEW_EMAIL_CODE = titleElem.text();
        System.out.println(TestValues.NEW_EMAIL_CODE);

    }
}
