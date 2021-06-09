package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        return $("#createButton").isDisplayed();
    }

    @Step("LogOut from projects page")
    public LogInPage logOut() {
        log.info("logout");
        $("#user-menu").click();
        $(By.cssSelector("a[href=\"https://app.qase.io/logout\"]")).click();
        return new LogInPage(driver);
    }
}
