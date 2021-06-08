package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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
    public SelenideElement IsPageOpened() {
        return $("#createButton").should(Condition.exist);
    }

    public LogInPage logOut() {
        $("#user-menu").click();
        $(By.cssSelector("a[href=\"https://app.qase.io/logout\"]")).click();
        return new LogInPage(driver);
    }
}
