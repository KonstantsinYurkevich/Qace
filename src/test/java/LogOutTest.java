import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {
    @Test
    public void logOut() {
        logInPage
                .openPage()
                .IsPageOpened();
        logInPage
                .logIn();
        homePage
                .IsPageOpened().should(Condition.exist);
        homePage
                .logOut();
        logInPage.IsPageOpened().should(Condition.exist);
    }
}
