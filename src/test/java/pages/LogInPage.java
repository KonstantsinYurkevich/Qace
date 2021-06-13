package pages;

import Base.Enum;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LogInPage extends BasePage {


    @Override
    public boolean IsPageOpened() {
        return $(Enum.logInButtonLocator.getValue()).isDisplayed();
    }

    @Step("Opening logIn page")
    public LogInPage openPage() {
        log.info("Opening LogIn page");
        open(Enum.pageLogIn.getValue());
        return new LogInPage();
    }

    @Step("LogIn according data")
    public HomePage logIn() {
        log.info("Fill in login form and press button login");
        open(Enum.pageLogIn.getValue());
        $(Enum.inputEmailLocator.getValue()).sendKeys(user);
        $(Enum.inputPasswordLocator.getValue()).sendKeys(password);
        $(Enum.logInButtonLocator.getValue()).click();
        $(Enum.userMenuLocator.getValue()).shouldBe(Condition.visible);
        return new HomePage();
    }

}
