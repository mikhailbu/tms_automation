package pages;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SettingProjectPage {
    public SettingProjectPage openPage(String baseUrl, String openUrl) {
        open(baseUrl+openUrl);
        return this;
    }
    public SettingProjectPage clickBtn(String nameBtn){
        $(byTagAndText("button", nameBtn)).shouldHave(visible).click();
        return this;
    }
    public SettingProjectPage checkTitle(String nameTitle, String tagTitle) {
        $(tagTitle).shouldHave(text(nameTitle));
        return this;
    }


    public SettingProjectPage setTextDelete(String setText) {
        $("input[modelmodifiers='[object Object]']").setValue(setText).pressEnter();
        return this;
    }

}
