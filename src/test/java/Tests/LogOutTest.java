package Tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LogOutTest extends BaseTest {
    @Test(description = "LogOut test")
    public void logOut() {
        boolean isPageOpened = logInPage
                .openPage()
                .IsPageOpened();
        assertTrue(isPageOpened, "LogIn page doesn't open");
        logInPage
                .logIn();
        isPageOpened = homePage
                .IsPageOpened();
        assertTrue(isPageOpened, "Projects page doesn't open");
        homePage
                .logOut();
        isPageOpened = logInPage.IsPageOpened();
        assertTrue(isPageOpened, "LogIn page doesn't open");

    }
}
