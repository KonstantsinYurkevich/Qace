package pages;

import Base.Enum;
import lombok.extern.log4j.Log4j2;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public abstract class BasePage {
    String user = System.getenv().getOrDefault("QASE_USER", PropertyReader.getProperty("qase.user"));
    String password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));


    public abstract boolean IsPageOpened();

    public LogInPage logOut() {
        log.info("logout");
        $(Enum.userMenuLocator.getValue()).click();
        $(Enum.signOutLocator.getValue()).click();
        return new LogInPage();
    }

}
