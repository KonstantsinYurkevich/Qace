package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LogInPage extends BasePage {
    public static final String LOGIN_BUTTON = "#btnLogin";

    public LogInPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public SelenideElement IsPageOpened() {
        return $(LOGIN_BUTTON).should(Condition.exist);
    }

    public LogInPage openPage() {
        log.info("Opening LogIn page");
        open("/login");
        return new LogInPage(driver);
    }

    public HomePage logIn() {
        log.info("Fill in login form and press button login");
        open("/login");
        $("#inputEmail").sendKeys(user);
        $("#inputPassword").sendKeys(password);
        $("#btnLogin").click();
        $("#user-menu").shouldBe(Condition.visible);
        return new HomePage(driver);
    }

}
