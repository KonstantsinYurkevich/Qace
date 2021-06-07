import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LogInTest extends BaseTest {
    @Test
    public void logIn()  {
        open("/login");
        $("#inputEmail").sendKeys(user);
        $("#inputPassword").sendKeys(password);
        $("#btnLogin").click();
        $("#user-menu").shouldBe(Condition.visible);

    }
}
